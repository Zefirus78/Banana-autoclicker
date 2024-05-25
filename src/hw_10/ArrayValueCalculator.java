package hw_10;

public class ArrayValueCalculator{
    public int doCalc(String[][] arrayOfNumbers) throws ArraySizeException, ArrayDataException{
        if(arrayOfNumbers.length != 4){
            throw new ArraySizeException("The array size must be 4*4!");
        }

        for(String[] arr: arrayOfNumbers){
            if(arr.length != 4){
                throw new ArraySizeException("The array size must be 4!");
            }
        }
        int sum = 0;
        for(int i = 0; i < 4; i++){
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(arrayOfNumbers[i][j]);
                } catch (NumberFormatException e) {
                    throw new ArrayDataException("Incorrect record in row:" + i + ", column" + j, i, j);
                }
            }
        }
        return sum;
    }
}