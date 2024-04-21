package hw_3.part2.models;

import hw_3.part2.contracts.Obstacle;
import hw_3.part2.contracts.Participant;

public class Wall extends Obstacle {

    public Wall(String obstacleType, double size) {
        super(obstacleType, size);
    }

    @Override
    public boolean overcome(Participant participant) {
        return participant.jump(size);
    }
}
