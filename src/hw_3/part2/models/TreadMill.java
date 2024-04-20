package hw_3.part2.models;

import hw_3.part2.contracts.Obstacle;
import hw_3.part2.contracts.Participant;

public class TreadMill implements Obstacle {
    private double distance;

    public TreadMill(double distance) {
        this.distance = distance;
    }

    @Override
    public void overcome(Participant participant) {
        participant.run();
        System.out.println("Participant " + participant + " run the track");
    }
}
