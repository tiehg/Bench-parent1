package com.bench.bench_article;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableCircuitBreaker
@SpringBootApplication
@EnableFeignClients
@MapperScan("com.bench.Bench.dao")
public class BenchArticleApplication {

    public static void main(String[] args) {
        SpringApplication.run(BenchArticleApplication.class, args);
    }

}
