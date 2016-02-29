import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class main {

	public static void main(String[] args) {
        long fib = getFib();
        long output = getFibNumber(fib);
        System.out.println("Your answer is... " + output);
    }

	private static long getFibNumber(long num) {
		long previousFibo = 0;
        long currentFibo = 1;
        long nextFibo = 0;
        if (num > 0) {
	        for (int i = 0; i < num; i++) {
		        nextFibo = previousFibo + currentFibo;
                previousFibo = currentFibo;
    		    currentFibo = nextFibo;
            }
        }
    return previousFibo;
	}

	private static int getFib() {
		InputStreamReader stdin = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader(stdin);
        String  msg = "";
        int fib = 0;
        try {
            System.out.print("What is the fib number you want to find? ");
            msg = console.readLine();
            fib = Integer.parseInt(msg);
        } catch (IOException e) {
        	System.out.println("Error with input!");
        }
        if (fib < 0) {	
        	System.out.println("Error: You must enter a number greater than or equal to 0.");
            System.exit(1);
        }
        return fib;
	}
}
