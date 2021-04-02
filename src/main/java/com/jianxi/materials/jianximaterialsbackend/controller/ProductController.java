package com.jianxi.materials.jianximaterialsbackend.controller;

import com.jianxi.materials.jianximaterialsbackend.mapper.ProductMapper;
import com.jianxi.materials.jianximaterialsbackend.pojo.Pagination;
import com.jianxi.materials.jianximaterialsbackend.pojo.Product;
import java.util.Comparator;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
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
    public List<Product> list() {
        return productMapper.list(0, 999);
    }

    @PostMapping("listAll")
    public List<Product> listAll() {
        List<Product> productList = productMapper.listAll();
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            String category = product.getCategory();
            String level = product.getLevel();
            List<Product> subProductList = new ArrayList<>();
            if ("0".equals(level)) {
                result.add(product);
                for (Product sub : productList) {
                    if ("1".equals(sub.getLevel()) && category.equals(sub.getCategory())) {
                        subProductList.add(sub);
                    }
                }
            }
            product.setSub(subProductList);
        }
        result = result.stream().sorted(Comparator.comparingInt(Product::getOrder)).collect(Collectors.toList());
        return result;
    }

    @GetMapping("listProductDetail")
    public List<Product> listProductDetail(@RequestParam String id) {
        List<Product> productList = productMapper.listAll();
        List<Product> result = new ArrayList<>();
        for (Product product : productList) {
            String category = product.getCategory();
            String level = product.getLevel();
            List<Product> subProductList = new ArrayList<>();
            if ("0".equals(level)) {
                result.add(product);
                for (Product sub : productList) {
                    if ("1".equals(sub.getLevel()) && category.equals(sub.getCategory())) {
                        subProductList.add(sub);
                    }
                }
            }
            product.setSub(subProductList);
        }
        result = result.stream().sorted(Comparator.comparingInt(Product::getOrder)).collect(Collectors.toList());
        if (id == null || "".equals(id) || "undefined".equals(id)) {
            return result;
        } else {
            return result.stream().filter(product -> id.equals(String.valueOf(product.getId()))).collect(Collectors.toList());
        }
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        log.info("delete product id as {}", id);
        productMapper.delete(id);
    }

    @GetMapping()
    public List<Product> getProduct(@RequestParam String id) {
        return productMapper.getProduct(id);
    }

}
