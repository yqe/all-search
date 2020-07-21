/**
 * Copyright 2020 meituan.com Inc. All Rights Reserved.
 */
package com.anqi.es.dto;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * @author yinqianen
 * @version 1.0 2020/7/16
 */
@Data
@Builder
@NoArgsConstructor
public class SearchDTO{
    private Integer page;
    private Integer size;
    private SearchInfoDTO searchInfoDTO;
}
