package LR_4;

public class ArrayAverage {
    public static void main(String[] args){
        Object[] arr1 = {1, 2, 3, 4};
        Object[] arr2 = {"1", "2"};
        Object[] arr3 = {};

        System.out.println(getAverage(arr1));
        System.out.println(getAverage(arr2));
        System.out.println(getAverage(arr3));
    }

    public static String getAverage(Object[] arr){
        int sum = 0;
        try{
            for (int i = 0; i < arr.length; i++){
                sum += (int) arr[i];
            }
            return("Average = " + sum/arr.length);
        }  catch (ArrayIndexOutOfBoundsException e) {
            return("Error: Array index out of bounds");
        } catch (ClassCastException e) {
            return("Error: Array element is not an integer");
        } catch (ArithmeticException e) {
            return("Error: Array / by zero");
        }

    }
}