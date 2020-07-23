package com.jianxi.materials.jianximaterialsbackend.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

/**
 * @param <E>
 * @author chenzeshenga
 * @since 2020-07-23
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Pagination<E> {

    private List<E> list;
    private long total;
    private int current;
    private int size;

}
