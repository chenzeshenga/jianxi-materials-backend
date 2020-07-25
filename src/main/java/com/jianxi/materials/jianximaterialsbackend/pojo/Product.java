package com.jianxi.materials.jianximaterialsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author chenzeshenga
 * @since 2020-07-25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {

    private int id;
    private String name;
    private String introduce;
    private String img;

}
