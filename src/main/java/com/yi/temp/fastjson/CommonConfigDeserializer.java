package com.yi.temp.fastjson;

import com.alibaba.fastjson.parser.DefaultJSONParser;
import com.alibaba.fastjson.parser.deserializer.ObjectDeserializer;

import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class CommonConfigDeserializer implements ObjectDeserializer {

    @Override
    public <T> T deserialze(DefaultJSONParser parser, Type type, Object o) {
        List<Object> list = new ArrayList<>();
        if (parser.getContext().object instanceof Person) {
            Person person = (Person) parser.getContext().object;
            if (person.getGender() == null) {
                list = parser.parseArray(Object.class);
            } else if (person.getGender() == 1) {
                List<Person> persons = parser.parseArray(Person.class);
                for (Person p : persons) {
                    p = copy(p, Person.class);
                    list.add(p);
                }
            } else if (person.getGender() == 0) {
                List<Long> ids = null;
                ids = parser.parseArray(Long.class);
                CommonConfig config;
                for (Long id : ids) {
                    config = CommonConfig.builder().commonId(id).build();
                    list.add(config);
                }
            } else {
                list = parser.parseArray(Object.class);
            }
        }
        return (T)list.toArray(new Object[list.size()]);
    }

    @Override
    public int getFastMatchToken() {
        return 0;
    }

    private Person copy(Person from, Class clazz) {
        try {
            Object to = clazz.newInstance();
            Field[] fields = Person.class.getDeclaredFields();
            for (Field field : fields) {
                field.setAccessible(true);
                field.set(to, field.get(from));
            }
            return (Person) to;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
