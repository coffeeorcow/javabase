package com.yi.functional;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

public class StreamTest {

    public static void main(String[] args) {
        List<Entity> entities = new ArrayList<>();
        entities.add(new Entity(1, 2));
        entities.add(new Entity(1, 2));
        entities.add(new Entity(null, 2));
        entities.add(new Entity(1, 3));
        entities.add(new Entity(2, 4));
        entities.add(new Entity(2, null));

        entities = entities.stream()
                .filter((e) -> e.getId() != null)
                .collect(ArrayList::new,
                        (list, e) -> {e.setNum(e.getNum() == null ? 99 : e.getNum());list.add(e);},
                        ArrayList::addAll);

        System.out.println(entities.toString());
    }


    @Data
    private static class Entity {
        private Integer id;
        private Integer num;

        public Entity(Integer id, Integer num) {
            this.id = id;
            this.num = num;
        }
    }
}
