package com.yi.pattern.factory;

public class SimpleHuamnFactory {
    public static <T extends Human> T createHuman(Class<T> clazz) {
        Human human = null;
        try {
            human = (Human) Class.forName(clazz.getName()).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("人种创建失败");
        }
        return (T) human;
    }
}
