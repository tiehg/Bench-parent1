package com.bench.bench_eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class BenchEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(BenchEurekaApplication.class, args);
    }

}
