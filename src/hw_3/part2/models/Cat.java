package hw_3.part2.models;

import hw_3.part2.contracts.Participant;

public class Cat extends Participant {

    public Cat(String name, double maxJump, double maxRun) {
        super(name, maxJump, maxRun);
    }

    @Override
    public void run() {
        System.out.println("Cat run");
    }

    @Override
    public void jump() {
        System.out.println("Cat Jump");
    }
}
