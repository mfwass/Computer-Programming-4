import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class main {

    public static void main(String[] args) {
        long fact = getInput();
        long output = getFactNumber(fact);
        System.out.println("Your (potentially long) answer is... " + output);
    }

    private static long getFactNumber(long num) {
        long number = 1;
        if (num > 0) {
            for (int i = 1; i <= num; i++) {
                number *= i;
            }
        }
        return number;
    }

    private static int getInput() {
        InputStreamReader stdin = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader(stdin);
        String  msg = "";
        int factorial = 0;
        try {
            System.out.print("What is the factorial number you want to find? ");
            msg = console.readLine();
            factorial = Integer.parseInt(msg);
        } catch (IOException e) {
            System.out.println("Error with input!");
        }
        if (factorial < 0) {
            System.out.println("Error: You must enter a number greater than or equal to 0.");
            System.exit(1);
        }
        return factorial;
    }
}
