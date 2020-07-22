/**
 * Copyright 2020 meituan.com Inc. All Rights Reserved.
 */
package com.anqi.es.util;


import com.anqi.es.bo.SearchInfoBO;
import com.anqi.es.dto.SearchInfoDTO;
import org.springframework.beans.BeanUtils;

/**
 * @author yinqianen
 * @version 1.0 2020/7/17
 */
public class ConvertUtils {
    public static SearchInfoBO convertSearchInfoDTO(SearchInfoDTO searchInfoDTO) {
        SearchInfoBO searchInfoDO = SearchInfoBO.builder()
                .accessPoint(searchInfoDTO.getAccessPoints())
                .bizId(searchInfoDTO.getBizIds())
                .cvId(searchInfoDTO.getCvIds())
                .userId(searchInfoDTO.getUserIds())
                .shopId(searchInfoDTO.getShopIds())
                .build();
        BeanUtils.copyProperties(searchInfoDTO, searchInfoDO);
        return searchInfoDO;
    }
}
