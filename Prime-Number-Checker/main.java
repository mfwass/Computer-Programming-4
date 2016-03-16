import java.io.*;
import java.util.Random;

public class main {

    public static void main(String[] args) throws IOException {
        int max = getNum();
        int isNumPrime = 0;
        int input = 0;
        int numOfPrimes = 0;
        Random random = new Random();
        while (isNumPrime != 1 && numOfPrimes != max) {
            System.out.println(numOfPrimes);
            // System.out.println(numOfPrimes); // debug prints <3
            isNumPrime = 0;
            input = random.nextInt(1000000);
            if (input > 2 | input <= 1000000) {
                isNumPrime = checkIsPrime(input);
                if (isNumPrime == 1) {
                    System.out.println("Your magical prime number is... " + input);
                    numOfPrimes++;
                }
            } // end of if
        } // end of while
    } // end of main

    private static int checkIsPrime(int input) {
        if (input <= 1) {
            return 0;
        } else if (input <= 3) {
            return 1;
        } else if ((input % 2 == 0) | (input % 3) == 0 ) {
            return 0;
        }
        int i = 5;
        while ((i*i) <= input) {
            if ((input % i) == 0 | (input % (i+2) == 0)) {
                return 0;
            }
            i += 6;
        }
        return 1;
    }

    private static int getNum() throws IOException {
        InputStreamReader stdin = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader(stdin);
        System.out.print("What is the number of prime numbers you want?\n, > ");
        String input = console.readLine();
        int inp = Integer.parseInt(input);
        return inp;
    }

}
