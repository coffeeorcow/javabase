package com.yi.temp.fastjson;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Person {

    private Long id;
    private String name;
    private Integer age;
    private Integer gender;

    @JSONField(deserializeUsing = CommonConfigDeserializer.class, serializeUsing = CommonConfigSerializer.class)
    private Object[] data;

}
