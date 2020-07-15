package com.anqi.es.controller;

import com.anqi.es.entity.Cloth;
import com.anqi.es.highclient.RestHighLevelClientService;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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

    @PostMapping("/search")
    public String search(String productName) throws IOException {
        SearchResponse search = service.search("name", productName, 0, 10, "idx_clouthing");
        System.out.println("搜索到 " + search.getHits().getTotalHits() + " 条数据.");
        SearchHits hits = search.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        return "成功";
    }

    @GetMapping("/multiSearch")
    public String multiSearch() throws IOException {
        Map<String, Object> termsMap = new HashMap<>();
        termsMap.put("price", "700");
        Map<String, Object> matchMap = new HashMap<>();
        matchMap.put("name", "阿迪");
        SearchResponse search = service.multiSearch(termsMap, matchMap, 0, 10, "idx_clouthing");
        System.out.println("搜索到 " + search.getHits().getTotalHits() + " 条数据.");
        SearchHits hits = search.getHits();
        for (SearchHit hit : hits) {
            System.out.println(hit.getSourceAsString());
        }
        return "成功";
    }
}
