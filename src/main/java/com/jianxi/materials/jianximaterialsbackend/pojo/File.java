package com.jianxi.materials.jianximaterialsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author chenzeshenga
 * @since 2020-07-26
 */
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class File implements Serializable {

    private String uuid;
    private byte[] file;
    private Date ctime;
    private String name;

}
