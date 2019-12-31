package com.boot.gang;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.boot.gang.mapper")
//@EnableJms //启动消息队列
public class LinGangApplication {

    public static void main(String[] args) {
        SpringApplication.run(LinGangApplication.class, args);
    }

}
