package hw_2;

public abstract class Animal {

    public String name;

    public Animal(String name) {
        this.name = name;

    }

    public abstract void run(double length);
    public abstract void swim(double length);
}
