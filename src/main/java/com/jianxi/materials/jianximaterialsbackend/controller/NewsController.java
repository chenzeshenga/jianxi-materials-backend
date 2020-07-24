package com.jianxi.materials.jianximaterialsbackend.controller;

import com.jianxi.materials.jianximaterialsbackend.mapper.NewsMapper;
import com.jianxi.materials.jianximaterialsbackend.pojo.News;
import com.jianxi.materials.jianximaterialsbackend.pojo.Pagination;
import com.jianxi.materials.jianximaterialsbackend.util.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author chenzeshenga
 * @since 2020-07-23
 */
@RestController
@RequestMapping("/news")
@Slf4j
@CrossOrigin("*")
public class NewsController {

    @Resource
    private NewsMapper newsMapper;

    @PostMapping("insert")
    public void insert(@RequestBody News news) {
        log.info(news.toString());
        news.setTime(DateUtils.getDateStr(new Date()));
        if (news.getId() == 0) {
            newsMapper.insert(news);
        } else {
            newsMapper.update(news);
        }
    }

    @PostMapping("list/{type}")
    public Pagination<News> list(@RequestBody Pagination pagination, @PathVariable String type) {
        int current = pagination.getCurrent();
        int size = pagination.getSize();
        List<News> newsList = newsMapper.list(type, (current - 1) * size, size);
        long total = newsMapper.total(type);
        return new Pagination<>(newsList, total, current, size);
    }

    @PostMapping("list")
    public Pagination<News> listAll(@RequestBody Pagination pagination) {
        int current = pagination.getCurrent();
        int size = pagination.getSize();
        List<News> newsList = newsMapper.listAll((current - 1) * size, size);
        long total = newsMapper.totalAll();
        return new Pagination<>(newsList, total, current, size);
    }

    @GetMapping("/delete/{newsId}")
    public void delete(@PathVariable String newsId) {
        log.info("delete news id as {}", newsId);
        newsMapper.delete(newsId);
    }

}
