package hw_3.part2.models;

import hw_3.part2.contracts.Participant;

public class Cat extends Participant {

    public Cat(String name, double maxJump, double maxRun) {
        super(name, maxJump, maxRun);
    }

    @Override
    public boolean run(double distance) {
        return distance <= maxRun;
    }

    @Override
    public boolean jump(double height) {
        return height <= maxJump;
    }
}
