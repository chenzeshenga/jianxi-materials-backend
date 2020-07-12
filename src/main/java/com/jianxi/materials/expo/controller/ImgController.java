package com.jianxi.materials.expo.controller;

import com.jianxi.materials.expo.mapper.ImgMapper;
import com.jianxi.materials.expo.pojo.Img;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author chenzeshenga
 * @since 2020-07-12
 */
@RestController
@RequestMapping("/img")
public class ImgController {

  @Resource private ImgMapper imgMapper;

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
}
