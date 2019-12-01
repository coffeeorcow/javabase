package com.yi.pattern.factory;

public class HumanFatory extends AbstractHumanFactory {
    @Override
    public <T extends Human> T createHuman(Class<T> c) {
        Human human = null;
        try {
            human = (Human) Class.forName(c.getName()).getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            System.out.println("人种创建错误");
        }
        return (T) human;
    }
}
