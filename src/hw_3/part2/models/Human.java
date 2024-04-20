package hw_3.part2.models;

import hw_3.part2.contracts.Participant;

public class Human extends Participant {

    public Human(String name, double maxJump, double maxRun) {
        super(name, maxJump, maxRun);
    }

    @Override
    public void run() {
        System.out.println(name + " run");
    }

    @Override
    public void jump() {
        System.out.println(name + " jump");
    }
}
