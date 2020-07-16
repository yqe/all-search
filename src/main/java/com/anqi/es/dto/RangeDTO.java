/**
 * Copyright 2020 meituan.com Inc. All Rights Reserved.
 */
package com.anqi.es.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

/**
 * @author yinqianen
 * @version 1.0 2020/7/16
 */
@Data
@AllArgsConstructor
@Builder
public class RangeDTO {
    private String name;
    private Object start;
    private Object end;
}
