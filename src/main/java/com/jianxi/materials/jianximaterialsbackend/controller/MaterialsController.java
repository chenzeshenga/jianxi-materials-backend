package com.jianxi.materials.jianximaterialsbackend.controller;

import com.jianxi.materials.jianximaterialsbackend.mapper.MaterialsMapper;
import com.jianxi.materials.jianximaterialsbackend.pojo.Materials;
import com.jianxi.materials.jianximaterialsbackend.pojo.Pagination;
import com.jianxi.materials.jianximaterialsbackend.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.http.MediaType;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.support.StandardMultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * @author chenzeshenga
 * @since 2020-07-26
 */
@RestController
@RequestMapping("/document")
@Slf4j
@CrossOrigin("*")
public class MaterialsController {

    @Resource
    private MaterialsMapper materialsMapper;

    @PostMapping("list")
    public Pagination<Materials> listAll(@RequestBody Pagination pagination) {
        int current = pagination.getCurrent();
        int size = pagination.getSize();
        List<Materials> materialsList = materialsMapper.list((current - 1) * size, size);
        long total = materialsMapper.totalAll();
        return new Pagination<>(materialsList, total, current, size);
    }

    @GetMapping("/delete/{uuid}")
    public void delete(@PathVariable String uuid) {
        log.info("delete news id as {}", uuid);
        materialsMapper.delete(uuid);
    }

    @GetMapping(value = "/file/{uuid}")
    @ResponseBody
    public void commonFile(@PathVariable String uuid, HttpServletResponse httpServletResponse)
            throws IOException {
        Materials materials = materialsMapper.getFile(uuid);
        if (materials == null) {
            httpServletResponse.getOutputStream().write("no file related".getBytes());
        } else {
            File file = new File(materials.getPath());
            httpServletResponse.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            httpServletResponse.setHeader(
                    "Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(materials.getName(), "utf-8"));
            httpServletResponse.getOutputStream().write(FileUtils.readFileToByteArray(file));
        }
        httpServletResponse.flushBuffer();
    }

    @PostMapping(value = "/file")
    public Map<String, Object> putImg(HttpServletRequest request) throws IOException {
        MultiValueMap<String, MultipartFile> multiValueMap = ((StandardMultipartHttpServletRequest) request).getMultiFileMap();
        Set<String> keys = multiValueMap.keySet();
        List<String> keyList = new ArrayList<>(keys);
        MultipartFile multipartFile = multiValueMap.get(keyList.get(0)).get(0);
        String uuid = UUID.randomUUID().toString();
        String directoryPath = "/app/" + DateUtils.getDateStr(new Date());
        FileUtils.forceMkdir(new File(directoryPath));
        FileUtils.writeByteArrayToFile(new File(directoryPath + File.separator + multipartFile.getOriginalFilename()), multipartFile.getBytes());
        Materials materials = new Materials(uuid, new Date(), multipartFile.getOriginalFilename(), directoryPath + File.separator + multipartFile.getOriginalFilename());
        materialsMapper.insert(materials);
        Map<String, Object> result = new HashMap<>();
        result.put("errno", 0);
//        Map<String, String> imgDesc = new HashMap<>();
//        imgDesc.put("url", "http://47.111.170.208:8889/document/file/" + uuid);
//        imgDesc.put("alt", multipartFile.getOriginalFilename());
//        imgDesc.put("href", "#");
        List<String> data = new ArrayList<>();
        data.add("http://47.111.170.208:8889/document/file/" + uuid);
//        data.add(imgDesc);
        result.put("data", data);
        return result;
    }

}
