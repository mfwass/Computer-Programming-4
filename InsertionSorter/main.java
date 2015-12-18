import java.io.*;

public class main {
    /*
     *  @author mfwass
     */
    private static int counter = 0;

    public static void main(String[] args) {
        int[] array = (int[]) getInput();
        int[] output = sortArray(array);
        showOutput(output);
    }

    private static void showOutput(int[] array) {
        // Print the array contents via a loop
        for (int i = 0; i < array.length; i++) { // loop through array length.
            // Go through each element in the array and print its contents.
            System.out.println("array[" + i + "] = " + array[i]);
        }
        // Print number of iterations it took.
        System.out.println("It took " + main.counter + " iterations to sort the array.");
    }

    private static int[] sortArray(int[] array) {
        int k = 0;
        int temp = 0;
        for (int i = 1; i <= array.length - 1; i++) {
            temp = array[i];  // back up array contents.
            k = i;            // assign i to k.
            while (k > 0 && array[k - 1] > temp) {  // go through each element in the array and find where the value should go.
                array[k] = array[k - 1];  // assign new value in the correct spot
                k = k - 1;     // Lower conditional.
                counter++;     // Increment the counter.
            }
            // Place the remaining value back into element "k".
            // Element "k" should be where the number that needed to be sorted came from originally.
            array[k] = temp;
        }
        return array;  // return the sorted array
        }

    private static int[] getInput() {
        // Initialize variables.
        InputStreamReader stdin = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader(stdin);
        int[] array = null;  // The array for storing the inputed data.
        int size = 0;        // used to input the array size.

        // Begin inputer.
        try {
            System.out.print("What is the size of the array? ");  // Ask for array size.
            String input = console.readLine();  // Read input.
            size = Integer.parseInt(input);     // Parse contents of input.
            array = new int [size];             // Initialize array with inputed size.

            // Begin input for each element in the array.
            for (int i = 0; i < array.length; i++) { // loops to ask the content of each element.
                System.out.println("What is the content of array[" + i + "]"); // Ask for contents of each element.
                String input1 = console.readLine(); // Read input.
                int inp = Integer.parseInt(input1); // Parse contents of input.
                array[i] = inp;                     // Assign the contents to the array.
            }
        } catch (IOException e) {   // Bad input.
            System.out.print("Invalid input!\n" + e); // notify user.
            System.exit(1); // Close program with exit code 1.
        }

        return array; // Return the array.
    }

}
