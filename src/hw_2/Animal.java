package hw_2;

public abstract class Animal {

    public String name;
    private static int count = 0;

    public Animal(String name) {
        this.name = name;
        count++;

    }

    public abstract void run(double length);
    public abstract void swim(double length);
}
