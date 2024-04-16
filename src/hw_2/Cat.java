package hw_2;

public class Cat extends Animal{
    private  static int count = 0;

    public Cat(String name) {
        super(name);
        count++;
    }

    @Override
    public void run(double length) {
        if (length <= 200){
            System.out.println(name + " runs " + length + " m");
        }
        else {
            System.out.println(name + " can't run " + length + " m");
        }
    }

    @Override
    public void swim(double length) {
        System.out.println(name + " can't swim ;)");
    }

    public static int getCount() {
        return count;
    }
}
