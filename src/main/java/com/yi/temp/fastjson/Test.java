package com.yi.temp.fastjson;

import com.alibaba.fastjson.JSON;

public class Test {

    public static void main(String[] args) {
        String json = "{\"name\":\"hah\",\"age\":13,\"gender\":1,\"data\":[{\"name\":\"bili\",\"age\":12,\"data\":[{\"commonId\":12}]}]}";
        Person p = JSON.parseObject(json, Person.class);
        System.out.println(p);
        System.out.println(JSON.toJSONString(p));
    }

}
