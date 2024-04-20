package hw_3.part2.contracts;

public abstract class Participant {
    public String name;
    public double maxJump;
    public double maxRun;

    public Participant(String name, double maxJump, double maxRun) {
        this.name = name;
        this.maxJump = maxJump;
        this.maxRun = maxRun;
    }

    public abstract boolean run(double distance);

    public abstract boolean jump(double height);

}
