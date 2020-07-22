package com.anqi.es.controller;

import com.alibaba.fastjson.JSON;
import com.anqi.es.dto.SearchDTO;
import com.anqi.es.entity.CreditInfo;
import com.anqi.es.highclient.RestHighLevelClientService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

/**
 * @author anqi
 */
//@Slf4j
@RestController
public class EsController {

    @Autowired
    RestHighLevelClientService service;

    @GetMapping("/test")
    public String test() throws IOException {
        return "bbbbb";
    }

    @GetMapping("/delete")
    public Boolean testDelete(String index) throws IOException {
        AcknowledgedResponse response = service.deleteIndex(index);
        return response.isAcknowledged();
    }

    @PostMapping("/save")
    public String save(@RequestBody CreditInfo creditInfo) throws IOException {
        String source = JSON.toJSONString(creditInfo);
        System.out.println(source);
        IndexResponse response = service.addDoc("text_index", source);
        return response.toString();
    }

    @PostMapping("/search")
    public String search(@RequestParam("content") String content) throws IOException {
        SearchResponse search = service.search("content", content, 0, 1, "idx_credit");
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
