/**
 * Copyright 2020 meituan.com Inc. All Rights Reserved.
 */
package com.anqi.es.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


/**
 * @author yinqianen
 * @version 1.0 2020/7/16
 */
@Data
@Builder
public class SearchInfoDTO{
    private Integer type;
    private List<Integer> accessPoints;
    private List<String> cvIds;
    private List<Long> bizIds;
    private List<Long> userIds;
    private List<Long> shopIds;
    private String content;
    private Long startTime;
    private Long endTime;
}
