/**
 * Copyright 2020 meituan.com Inc. All Rights Reserved.
 */
package com.anqi.es.enums;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author yinqianen
 * @version 1.0 2020/7/17
 */
@Slf4j
@Getter
@AllArgsConstructor
public enum IndexType {
    //分为文字，图片，视频三个索引
    TEXT(1, "text_index", "文字"),
    PIC(2, "pic_index", "图片"),
    VIDEO(3, "video_index", "视频");

    private int code;
    private String name;
    private String desc;

    public static IndexType of(int code) {
        try {
            for (IndexType item : IndexType.values()) {
                if (item.code == code) {
                    return item;
                }
            }
        } catch (IllegalArgumentException e) {
            log.error("Unknown IndexType code:" + code, e);
        }
        // default
        return IndexType.TEXT;
    }
}