package com.jianxi.materials.jianximaterialsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author chenzeshenga
 * @since 2020-07-22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {

    private String username;
    private String pwd;

}
