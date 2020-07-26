package com.jianxi.materials.jianximaterialsbackend.controller;

import com.jianxi.materials.jianximaterialsbackend.mapper.FileMapper;
import com.jianxi.materials.jianximaterialsbackend.pojo.File;
import com.jianxi.materials.jianximaterialsbackend.pojo.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author chenzeshenga
 * @since 2020-07-26
 */
@RestController
@RequestMapping("/document")
@Slf4j
@CrossOrigin("*")
public class FileController {

    @Resource
    private FileMapper fileMapper;

    @PostMapping("list")
    public Pagination<File> listAll(@RequestBody Pagination pagination) {
        int current = pagination.getCurrent();
        int size = pagination.getSize();
        List<File> fileList = fileMapper.list((current - 1) * size, size);
        long total = fileMapper.totalAll();
        return new Pagination<>(fileList, total, current, size);
    }

    @GetMapping("/delete/{uuid}")
    public void delete(@PathVariable String uuid) {
        log.info("delete news id as {}", uuid);
        fileMapper.delete(uuid);
    }

    @GetMapping(value = "/file/{uuid}")
    @ResponseBody
    public void commonFile(@PathVariable String uuid, HttpServletResponse httpServletResponse)
            throws IOException {
        File file = fileMapper.getFile(uuid);
        if (file == null) {
            httpServletResponse.getOutputStream().write("no file related".getBytes());
            httpServletResponse.flushBuffer();
        } else {
            httpServletResponse.setContentType(MediaType.APPLICATION_OCTET_STREAM_VALUE);
            httpServletResponse.setHeader(
                    "Content-Disposition",
                    "attachment;filename=" + URLEncoder.encode(file.getName(), "utf-8"));
            httpServletResponse.getOutputStream().write(file.getFile());
            httpServletResponse.flushBuffer();
        }
    }

    @PostMapping(value = "/file")
    public void putImg(@RequestParam(value = "file") MultipartFile multipartFile)
            throws IOException {
        String uuid = UUID.randomUUID().toString();
        File file = new File(uuid, multipartFile.getBytes(), new Date(), multipartFile.getOriginalFilename());
        fileMapper.insert(file);
    }

}
