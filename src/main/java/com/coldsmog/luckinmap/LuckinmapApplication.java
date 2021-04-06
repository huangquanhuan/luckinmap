package com.coldsmog.luckinmap;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@MapperScan("com.coldsmog.luckinmap.mapper")
public class LuckinmapApplication {

    public static void main(String[] args) {
        SpringApplication.run(LuckinmapApplication.class, args);
    }

}
