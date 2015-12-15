// Import IO so we can use console.readline()
import java.io.*;

public class main {
	/*
	 *  @author mfwass
	 */
	public static void main(String[] args) {
	    // Initialize variables.
	    InputStreamReader stdin = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader(stdin);
        int[] array = null; // The array for storing the inputed data.
        int size = 0;       // used to input the array size.
        int counter = 0;    // counter to keep track of data in the output.

        // Begin inputer.
		try {
			System.out.print("What is the size of the array? ");  // Ask for array size.
			String input = console.readLine();  // Read input.
			size = Integer.parseInt(input);     // Parse contents of input.
			array = new int [size];	            // Initialize array with inputed size.

			// Begin input for each element in the array.
			for (int i = 0; i < array.length; i++) { // loops to ask the content of each element.
				System.out.println("What is the content of array[" + i + "]"); // Ask for contents of each element.
				String input1 = console.readLine();	// Read input.
				int inp = Integer.parseInt(input1); // Parse contents of input.
				array[i] = inp;                     // Assign the contents to the array.
			}
		} catch (IOException e) {   // Bad input.
			System.out.print("Invalid input!\n" + e); // notify user.
			System.exit(1); // Close program with exit code 1.
		}

		// Begin of flipper / flopper.

		int temp; // Initialize temporary variable.

		for (int i = 0; i < array.length; i++){ // loop through array length.
            for (int j = 1; j < array.length-i; j++){ // loop through array length.
                if(array[j-1] > array[j]){    // change > to < for flip/flop order.
                    temp=array[j-1];          // store temporary variable in array[size].
                    array[j-1] = array[j];    // flip/flop array contents.
                    array[j] = temp;          // throw temporary variable into the other array element.
                    counter++;                // Increment the counter.
                }
			}
        }

		// Print the array contents via a loop
		for (int i = 0; i < array.length; i++) { // loop through array length.
			// Go through each element in the array and print its contents.
			System.out.println("array[" + i + "] = " + array[i]);
		}
		// Print number of iterations it took to sort the array.
		System.out.println("It took " + counter + " iterations to sort the array.");
	}
}
