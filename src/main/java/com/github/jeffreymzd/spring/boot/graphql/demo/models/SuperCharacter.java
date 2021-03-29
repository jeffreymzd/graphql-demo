package com.github.jeffreymzd.spring.boot.graphql.demo.models;

import lombok.Builder;
import lombok.Data;

/**
 * Created by jeffreymzd on 3/28/21
 */
@Data
@Builder
public class SuperCharacter {
    private String id;
    private String name;
    private Integer age;
}
