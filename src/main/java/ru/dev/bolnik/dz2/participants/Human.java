package ru.dev.bolnik.dz2.participants;

public class Human implements Contestant {
    private String name;
    private int maxRun;
    private int maxJump;

    public Human(String name, int maxRun, int maxJump) {
        this.name = name;
        this.maxRun = maxRun;
        this.maxJump = maxJump;
    }


    @Override
    public boolean run(int distance) {
        if (distance > maxRun) {
            System.out.println(name + " не пробежал дистанцию " + distance + "m");
            return false;
        }
        System.out.println(name + " пробежал дистанцию " + distance + "m");
        return true;
    }

    @Override
    public boolean jump(int height) {
        if (height > maxJump) {
            System.out.println(name + " не перепрыгнул стену " + height + "m");
            return false;
        }
        System.out.println(name + " перепрыгнул стену " + height + "m");
        return true;
    }
}
