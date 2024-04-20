package hw_3.part2.models;

import hw_3.part2.contracts.Obstacle;
import hw_3.part2.contracts.Participant;

public class Wall implements Obstacle {
    private double height;

    public Wall(double height) {
        this.height = height;
    }

    @Override
    public void overcome(Participant participant) {
        participant.jump();
        System.out.println("Participant " + participant + " jumped over the wall");
    }
}
