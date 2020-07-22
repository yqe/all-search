/**
 * Copyright 2020 meituan.com Inc. All Rights Reserved.
 */
package com.anqi.es.bo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/** *
 * @author yinqianen
 * @version 1.0 2020/7/22 
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchInfoBO {
    private Integer type;
    private List<Integer> accessPoint;
    private List<String> cvId;
    private List<Long> bizId;
    private List<Long> userId;
    private List<Long> shopId;
    private String content;
    private Long startTime;
    private Long endTime;
}
