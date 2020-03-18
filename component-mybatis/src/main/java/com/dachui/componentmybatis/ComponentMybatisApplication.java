package com.dachui.componentmybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableAspectJAutoProxy(exposeProxy = true)
@MapperScan(value = "com.dachui.componentmybatis.dao")
@SpringBootApplication
public class ComponentMybatisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ComponentMybatisApplication.class, args);
    }

}
