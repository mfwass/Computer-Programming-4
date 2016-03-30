import java.awt.*;
import java.io.*;
import javax.swing.*;

public class main {

    public static void main(String[] args) {
        int input = getInput();
        int numOfMoves = getNumOfMoves(input);
        System.out.println("It will take you " + numOfMoves + " moves to complete this.");
        hanoi(input,'A','B','C');
        createWindow();
    }

    private static void createWindow() {
        JFrame frame = new JFrame("Tower of Hanoi");
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(500, 500));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int height = screenSize.height;
        int width = screenSize.width;
        frame.setSize(width/2, height/2);
        frame.setLocationRelativeTo(null);
        frame.pack();
        frame.setVisible(true);
    }

    private static int getNumOfMoves(int input) {
        int numOfMoves = (int) (Math.pow(2, input) - 1);
        // FUN DEBUG PRINTS! :D
        // System.out.println("input = " + input + "; numOfMoves = " + (int) (Math.pow(2, input) - 1));
        return numOfMoves;
    }

    private static int getInput() {
        InputStreamReader stdin = new InputStreamReader(System.in);
        BufferedReader console = new BufferedReader(stdin);
        String  msg = "";
        int input = 0;
        try {
            System.out.print("What is the number of disks? ");
            msg = console.readLine();
            input = Integer.parseInt(msg);
        } catch (IOException e) {
            System.out.println("Error with input!");
        } catch (NumberFormatException e) {
            System.out.println("Error: Bad input! You must enter in a NUMBER greater than 0 and less than 64!");
            System.exit(1);
        }
        if (input <= 0 || input >= 64) {
            System.out.println("Error: You must enter a number greater than 0 and less than 64.");
            System.exit(1);
        }
        return input;
    }

    public static void hanoi(int i, char a, char b, char c) {
        if (i<=1) {
            System.out.println("Move disk from " + a + " to " + c + ".");
        } else {
            hanoi(i-1,a,c,b);
            System.out.println("Move disk from " + a + " to " + c + ".");
            hanoi(i-1,b,a,c);
        }
    }
}
