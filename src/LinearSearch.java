import java.util.Scanner;

public class LinearSearch {
    // linear search method
    public static int linearSearch(int[] list, int key) {
        for (int i = 0; i < list.length; i++) {
            if (key == list[i])
                return i; // return index of the key in the array
        }
        return -1; // return -1 if key does not exist in the array
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] numbers = new int[5];
        // allows user to input values for five integer
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Insert the value for position number " + i);
            numbers[i] = input.nextInt();
        }
        // allows user to input key
        System.out.println("Insert the value to be searched: ");
        int key = input.nextInt();

        // print results
        System.out.println("Key: " + key);
        System.out.println("Index: " + linearSearch(numbers, key));

        // close scanner
        input.close();
    }
}
