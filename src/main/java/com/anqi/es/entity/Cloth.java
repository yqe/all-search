package com.anqi.es.entity;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author anqi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cloth {

    private String id;

    private String name;

    private String desc;

    private Integer num;

    private double price;

    private String date;
}
