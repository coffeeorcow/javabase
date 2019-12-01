package com.yi.pattern.factory;

public class Test {

    public static void main(String[] args) {
        AbstractHumanFactory factory = new HumanFatory();
        Human human = factory.createHuman(WhiteHuman.class);
        human.getColor();
        human.talk();
        human = factory.createHuman(BlackHuman.class);
        human.getColor();
        human.talk();
        YellowHuman yellowHuman = factory.createHuman(YellowHuman.class);
        yellowHuman.getColor();
        yellowHuman.talk();

        BlackHuman blackHuman = SimpleHuamnFactory.createHuman(BlackHuman.class);
        blackHuman.getColor();
        blackHuman.talk();
    }

}
