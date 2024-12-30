package hw_2;

public class Dog extends Animal{

    private static int count = 0;

    public Dog(String name) {
        super(name);
        count++;
    }

    @Override
    public void run(double length) {
        if (length <= 500){
            System.out.println(name + " runs " + length + " m");
        }
        else{
            System.out.println(name + " can't run " + length + " m");
        }
    }

    @Override
    public void swim(double length) {
        if (length <= 10){
            System.out.println(name + " swims " + length + " m");
        }
        else {
            System.out.println(name + " can't swim " + length + " m");
        }
    }

    public static int getCount() {
        return count;
    }
}
