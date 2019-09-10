package com.xy.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@Component
@Configuration
public class User {

    @Value("${com.xy.type}")
    private String type;

    @Value("${com.xy.title}")
    private String title;
}
