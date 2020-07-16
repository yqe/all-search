package com.anqi.es.controller;

import com.alibaba.fastjson.JSON;
import com.anqi.es.dto.SearchDTO;
import com.anqi.es.entity.Cloth;
import com.anqi.es.highclient.RestHighLevelClientService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

/**
 * @author anqi
 */
@Slf4j
@RestController
public class EsController {

    @Autowired
    RestHighLevelClientService service;

    @GetMapping("/es")
    public String testHigh() throws IOException {
        String source = "{\n" +
                "  \"name\" : \"阿迪王运动鞋\",\n" +
                "  \"price\" : 100,\n" +
                "  \"num\" : 500,\n" +
                "  \"date\" : \"2019-08-28\"\n" +
                "}";
        IndexResponse response = service.addDoc("idx_clouthing", source);
        return response.toString();
    }

    @PostMapping("/save")
    public String save(@RequestBody Cloth cloth) throws IOException {
        String source = JSON.toJSONString(cloth);
        System.out.println(source);
        IndexResponse response = service.addDoc("idx_clouthing", source);
        return response.toString();
    }

    @PostMapping("/search")
    public String search(@RequestParam("file") String productName) throws IOException {
        SearchResponse search = service.search("name", productName, 0, 10, "idx_clouthing");
        System.out.println("搜索到 " + search.getHits().getTotalHits() + " 条数据.");
        SearchHits hits = search.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        return "成功";
    }

    @PostMapping("/multiSearch")
    public String multiSearch(@RequestBody SearchDTO searchDTO) throws IOException {
        service.multiSearch(searchDTO);
        SearchResponse search = service.multiSearch(searchDTO);
        System.out.println("搜索到 " + search.getHits().getTotalHits() + " 条数据.");
        SearchHits hits = search.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        return "成功";
    }
}
