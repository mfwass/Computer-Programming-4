import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class Main extends JFrame {

    public static boolean move = false;
    public static JTextPane gameBoard = new JTextPane();
    public static JTextField txtInput = new JTextField("");
    static JLabel lbl = new JLabel("Player " + (char)(88+(move? 1 : 0)*-9) + ", make your move.");


    public static char board[][] = new char[3][3]; 

    public Main() {
        setTitle("Tic-Tac-Toe");

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        gameBoard.setEditable(false);
        gameBoard.setText("");
        gameBoard.setFont(new Font("Consolas", Font.PLAIN, 16));

        c.ipadx=100;
        c.ipady=90;
        c.weightx = 1;
        c.weighty = 1;
        c.gridwidth = 3;
        c.gridy = 0;
        add( gameBoard ,c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridy = 1;
        c.ipady = 0;
        add( lbl , c);

        txtInput.addActionListener(enterPress);
        c.ipady=10;
        c.weightx = 1;
        c.weighty = 1;
        c.gridy = 2;
        add( txtInput ,c);


        setResizable(false);

        setVisible(true);
        setSize(600,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) {
        Main ttt = new Main();
        for (int xx = 0; xx < 3; xx++) {
            for (int yy = 0; yy < 3; yy++) {
                board[xx][yy] = 32;
            }
        }
        drawBoard();
    }

    public static void drawBoard() {
        gameBoard.setText("Board      Key\n" + 
                          board[0][0] + "█" + board[1][0] + "█" +board[2][0] + "     1 2 3\n" + 
                          "█████\n" + 
                          board[0][1] + "█" + board[1][1] + "█" +board[2][1] + "     4 5 6\n" + 
                          "█████\n" + 
                          board[0][2] + "█" + board[1][2] + "█" +board[2][2] + "     7 8 9"
                            );
    }
    public static void getInput(int input) {

        if (input < 1 || input > 9) {
            txtInput.setText("ERROR: Not an eligible number.");
        }
        else {
            txtInput.setText("");
        int xx = ((input-1)%3);
        int yy = ((input-1)/3);

        //Check if space is empty
        if (board[xx][yy] == ' ') {
            //Put an X or O
            board[xx][yy] = (char)(88+(move? 1 : 0)*-9);
            drawBoard();

            //Check for win
            if (checkWin()) {
                lbl.setText("Player " + (char)(88+(move? 1 : 0)*-9) + " has won!!!!!!");
            }
            else {
                //Check if board is full with no wins
                if (checkMoves() >= 9) {
                    //Draw
                    lbl.setText("The game is a draw.");
                }
                else {
                    move = !move;
                    lbl.setText("Player " + (char)(88+(move? 1 : 0)*-9) + ", make your move.");
                }
            }
        }
 
        else {
            txtInput.setText("Error: Space " + input + " is already taken.");
        }
    }
    }

    //Win Checker
    public static boolean checkWin() {
        boolean win = false;

        //Columns
        for (int xx = 0; xx < 3; xx++) {
            if (board[xx][0] == board[xx][1] &&  board[xx][0] == board[xx][2] && board[xx][0] != ' ') {
                win = true;
            }
        }
        //Rows
        for (int yy = 0; yy < 3; yy++) {
            if (board[0][yy] == board[1][yy] &&  board[0][yy] == board[2][yy] && board[0][yy] != ' ') {
                win = true;
            }
        }

        //Diagonals
        if (board[1][1] == board[0][0] && board[1][1] == board[2][2] && board[1][1] != ' ') {
            win = true;
        }
        if (board[1][1] == board[0][2] && board[1][1] == board[0][2] && board[1][1] != ' ') {
            win = true;
        }


        return win;
    }

    //Check how much of board is filled
    public static int checkMoves() {
        int moves = 0;
        for (int xx = 0; xx < 3; xx++) {
            for (int yy = 0; yy < 3; yy++) {
                if (board[xx][yy] != ' ') {
                    moves++;
                }
            }
        }
        return moves;
    }

Action enterPress = new AbstractAction() {
    @Override
    public void actionPerformed(ActionEvent e) {
            int i = 0;
            try {  i = Integer.parseInt(txtInput.getText().replace(" ", ""));}
            catch (NumberFormatException n) {
                txtInput.setText("ERROR: You have not inputted a number.");
            }

            getInput(i);
        }

    };
}
