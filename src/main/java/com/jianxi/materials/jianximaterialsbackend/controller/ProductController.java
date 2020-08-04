package com.jianxi.materials.jianximaterialsbackend.controller;

import com.jianxi.materials.jianximaterialsbackend.mapper.ProductMapper;
import com.jianxi.materials.jianximaterialsbackend.pojo.Pagination;
import com.jianxi.materials.jianximaterialsbackend.pojo.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author chenzeshenga
 * @since 2020-07-25
 */
@RestController
@RequestMapping("/product")
@Slf4j
@CrossOrigin("*")
public class ProductController {

    @Resource
    private ProductMapper productMapper;

    @PostMapping("insert")
    public void insert(@RequestBody Product product) {
        log.info(product.toString());
        if (product.getId() == 0) {
            productMapper.insert(product);
        } else {
            productMapper.update(product);
        }
    }

    @PostMapping("list")
    public Pagination<Product> list(@RequestBody Pagination pagination) {
        int current = pagination.getCurrent();
        int size = pagination.getSize();
        List<Product> productList = productMapper.list((current - 1) * size, size);
        long total = productMapper.total();
        return new Pagination<>(productList, total, current, size);
    }

    @PostMapping("listAll")
    public List<Product> listAll() {
        List<Product> productList = productMapper.listAll();
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            String category = product.getCategory();
            String level = product.getLevel();
            if ("0".equals(level)) {
                result.add(product);
                for (Product sub : productList) {
                    if ("1".equals(sub.getLevel()) && category.equals(sub.getCategory())) {
                        result.add(sub);
                    }
                }
            }
        }
        return result;
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        log.info("delete product id as {}", id);
        productMapper.delete(id);
    }

    @GetMapping()
    public Product getProduct(@RequestParam String id) {
        return productMapper.getProduct(id);
    }

}
