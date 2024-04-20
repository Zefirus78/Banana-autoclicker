package hw_3.part2.models;

import hw_3.part2.contracts.Participant;

public class Robot extends Participant {

    public Robot(String name, double maxJump, double maxRun) {
        super(name, maxJump, maxRun);
    }

    @Override
    public void run() {
        System.out.println("Robot run");
    }

    @Override
    public void jump() {
        System.out.println("Robot jump");
    }
}
