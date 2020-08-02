package com.jianxi.materials.jianximaterialsbackend.controller;

import com.jianxi.materials.jianximaterialsbackend.mapper.HrMapper;
import com.jianxi.materials.jianximaterialsbackend.pojo.Job;
import com.jianxi.materials.jianximaterialsbackend.pojo.News;
import com.jianxi.materials.jianximaterialsbackend.pojo.Pagination;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author chenzeshenga
 * @since 2020-08-02
 */
@RestController
@RequestMapping("/job")
@Slf4j
@CrossOrigin("*")
public class JobController {

    @Resource
    private HrMapper hrMapper;

    @PostMapping("insert")
    public void insert(@RequestBody Job job) {
        log.info(job.toString());
        if (job.getId() == 0) {
            hrMapper.insert(job);
        } else {
            hrMapper.update(job);
        }
    }

    @GetMapping("list")
    public List<Job> listAll() {
        return hrMapper.listAll();
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        hrMapper.delete(id);
    }

}
