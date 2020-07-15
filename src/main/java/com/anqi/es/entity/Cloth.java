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

    @JSONField(ordinal = 0)
    private String id;

    @JSONField(ordinal = 1)
    private String name;

    @JSONField(ordinal = 2)
    private String desc;

    @JSONField(ordinal = 3)
    private Integer num;

    @JSONField(ordinal = 4)
    private double price;

    @JSONField(ordinal = 5, format = "yyyy-MM-dd HH:mm:ss")
    private Date date;
}
