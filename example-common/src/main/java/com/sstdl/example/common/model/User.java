package com.sstdl.example.common.model;

import java.io.Serializable;

/**
 * @author SSTDL
 * @description 用户实体类
 */
public class User implements Serializable {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
