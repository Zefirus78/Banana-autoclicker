package hw_2;

public class Application {
    public static void main(String[] args) {
        Cat cat = new Cat("Murzik");
        Cat cat2 = new Cat("Loki");
        Dog dog = new Dog("Rex");
        //Dog dog2 = new Dog("Luna");

        cat.run(200);
        cat2.run(350);
        cat.swim(1);
        dog.run(500);
       // dog2.run(550);
        dog.swim(5);
       // dog2.swim(15);

        System.out.println("Amount of cats being domesticated " + Cat.getCount());
        System.out.println("Amount of dogs being domesticated " + Dog.getCount());
    }
}
