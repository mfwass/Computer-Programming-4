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
        int temp = 0;
        for (int i = array.length - 1; i > 0; i--) {
            int start = 0; // Make our starting variable which will be the first element in the array.
            for (int k = 1; k <= i; k++) {
                if (array[k] > array[start]) {   // Flip/flop < > to change output order. 
                    start = k;    // Set starting element to the smallest value.
                }
                /*
                 * Flips two array elements.
                 * 
                 * =================
                 * ==== Example ====
                 * =================
                 * | Before:       |
                 * | array[0] = 1  |
                 * | array[1] = 0  |
                 * |---------------|
                 * | After:        |
                 * | array[0] = 0  |
                 * | array[1] = 1  |
                 * =================
                 */
                temp = array[start];      // Throw starting value into a temporary variable.
                array[start] = array[i];  // Flip the contents of array[start] and array[i].
                array[i] = temp;          // Assign the temporary variable to array[i] completing the flip.
                }
            main.counter++; // increment counter.
            }
        return array;  // return the sorted array back
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
