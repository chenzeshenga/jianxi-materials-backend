package com.jianxi.materials.jianximaterialsbackend.controller;

import com.jianxi.materials.jianximaterialsbackend.mapper.ImgMapper;
import com.jianxi.materials.jianximaterialsbackend.pojo.Img;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

/**
 * @author chenzeshenga
 * @since 2020-07-12
 */
@RestController
@RequestMapping("/img")
@CrossOrigin("*")
public class ImgController {

    @Resource
    private ImgMapper imgMapper;

    @GetMapping("/{uuid}")
    @ResponseBody
    public void getImg(@PathVariable String uuid, HttpServletResponse httpServletResponse)
            throws IOException {
        Img image = imgMapper.getImgByUuid(uuid);
        httpServletResponse.setContentType("image/jpeg");
        OutputStream outputStream = httpServletResponse.getOutputStream();
        InputStream in = new ByteArrayInputStream(image.getImg());
        IOUtils.copy(in, outputStream);
        in.close();
        outputStream.close();
    }

    @PostMapping(value = "/img")
    public String putImg(@RequestParam(value = "file") MultipartFile multipartFile)
            throws IOException {
        String uuid = UUID.randomUUID().toString();
        Img img = new Img(uuid, multipartFile.getBytes());
        imgMapper.insert(img);
        return uuid;
    }
}
