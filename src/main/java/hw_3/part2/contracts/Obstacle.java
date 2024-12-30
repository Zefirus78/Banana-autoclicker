package hw_3.part2.contracts;

public abstract class Obstacle {
    public String obstacleType;
    public double size;

    public Obstacle(String obstacleType, double size) {
        this.obstacleType = obstacleType;
        this.size = size;
    }

    public abstract boolean overcome(Participant participant);
}
