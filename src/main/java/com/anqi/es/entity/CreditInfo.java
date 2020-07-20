/**
 * Copyright 2020 meituan.com Inc. All Rights Reserved.
 */
package com.anqi.es.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author yinqianen
 * @version 1.0 2020/7/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditInfo {
    private String cvId;
    private int accessPoint;
    private long bizId;
    private long userId;
    private long shopId;
    private String content;
    private long addTime;
}
