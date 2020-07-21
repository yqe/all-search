/**
 * Copyright 2020 meituan.com Inc. All Rights Reserved.
 */
package com.anqi.es.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/** *
 * @author yinqianen
 * @version 1.0 2020/7/21 
 */
@Data
@Builder
public class CreditInfo {
    private Long userId;
    private Long shopId;
    private Long bizId;
    private String content;
    private Long addTime;
}
