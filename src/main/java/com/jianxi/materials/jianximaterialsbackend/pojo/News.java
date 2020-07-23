package com.jianxi.materials.jianximaterialsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author chenzeshenga
 * @since 2020-07-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class News {

    private int id;
    private String title;
    private String content;
    private String time;
    private String type;

}
