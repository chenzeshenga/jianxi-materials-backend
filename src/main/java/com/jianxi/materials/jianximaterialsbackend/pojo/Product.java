package com.jianxi.materials.jianximaterialsbackend.pojo;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author chenzeshenga
 * @since 2020-07-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product implements Serializable {

    private int id;
    private String name;
    private String introduce;
    private String img;
    private String category;
    private String level;
    private int order;
    private List<Product> sub;

}
