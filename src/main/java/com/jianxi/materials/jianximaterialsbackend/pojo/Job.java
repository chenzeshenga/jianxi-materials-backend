package com.jianxi.materials.jianximaterialsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author chenzeshenga
 * @since 2020-08-02
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Job implements Serializable {

    private int id;
    private String title;
    private String content;
    private String contact;

}
