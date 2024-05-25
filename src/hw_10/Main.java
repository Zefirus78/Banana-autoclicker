package hw_10;

public class Main {
    public static void main(String[] args) {
        ArrayValueCalculator calculator = new ArrayValueCalculator();
        String[][] numbers = {
                {"1", "5", "10", "34"},
                {"8", "9", "3", "4"},
                {"124", "6", "s", "0"},
                {"4", "56", "78", "313"},
        };
        try{
            int sum = calculator.doCalc(numbers);
            System.out.println("Sum of converted numbers in a 2D array is: " + sum);
        }
        catch(ArraySizeException e){
            System.out.println("Array size exception: " + e.getMessage());
        }
        catch (ArrayDataException e){
            System.out.println("Array data exception: " + e.getMessage());
        }
    }
}
