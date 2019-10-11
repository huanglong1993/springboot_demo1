package com.hl.springboot_demo1.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author 黄龙
 * @Date 2019/10/9 11:16
 * @Description TODO
 * @Version 1.0.0
 */
@ConfigurationProperties(prefix = "girl")
@Component
public class GirlProperties {

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
