package com.bench.Bench;

import com.bench.Bench.service.ArticleService;
import com.bench.Bench.utils.pageUtils;
import com.bench.Bench.utils.pages;
import com.bench.bean.S3Article;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

@SpringBootTest
public class BenchBackApplicationTests {

    @Autowired
    private ArticleService articleService;

    @Test
    void contextLoads() {

        S3Article article=new S3Article();
        pages pages=new pages(0,5, "sendtime","DESC");
        /*int id=1;
        List<S3Article> list=articleService.findAllByAid(id);*/

        Page<S3Article> page=  articleService.findAll( pageUtils.createPageRequest(pages));
        System.out.println("====1====="+articleService.findAll( pageUtils.createPageRequest(pages)));
        System.out.println("========"+page);
    }

}
