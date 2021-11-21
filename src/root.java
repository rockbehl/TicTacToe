import java.util.Random;
import java.util.Scanner;

public class root {
    static char[] numbers = {'1','2','3','4','5','6','7','8','9'};
    static boolean win;
    int occupied = 9;
    public static void main(String[] args) {
        char[][] board = new char[3][3];
        board = setup(board);
        display(board);
        System.out.println();
        while (!win) {
            board = playTurn(board);
            display(board);
            System.out.println();
            System.out.println("[][][][][][][][][][]");
            gameLogic(board);
            if (win){
                break;
            }
            board = compTurn(board);
            display(board);
            System.out.println();
            gameLogic(board);
        }



    }
    private static char[][] setup(char[][] board){
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                board[j][i] = numbers[count];
                count++;
            }
        }

        return board;
    }
    private static void display(char[][] board){

        for (int i = 0; i < board.length; i++) {
            System.out.println(" ");
            for (int j = 0; j < board.length; j++) {
                System.out.print(" [ " + board[j][i] + " ] ");
            }
            System.out.println();
        }

    }
    private static char[][] playTurn(char[][] board){
        Scanner sc = new Scanner(System.in);

        boolean validMove = false;
        int cord;
        int cordX;
        int cordY;

        while (!validMove) {

            System.out.println("enter a coordinate: ");
             cord = sc.nextInt();
             cordX = 0;
             cordY = 0;

            switch (cord) {
                case 1 -> cordX = 0;
                case 2 -> cordX = 0;
                case 3 -> cordX = 0;
                case 4 -> cordX = 1;
                case 5 -> cordX = 1;
                case 6 -> cordX = 1;
                case 7 -> cordX = 2;
                case 8 -> cordX = 2;
                case 9 -> cordX = 2;
            }
            switch (cord) {
                case 1 -> cordY = 0;
                case 2 -> cordY = 1;
                case 3 -> cordY = 2;
                case 4 -> cordY = 0;
                case 5 -> cordY = 1;
                case 6 -> cordY = 2;
                case 7 -> cordY = 0;
                case 8 -> cordY = 1;
                case 9 -> cordY = 2;
            }
            if(board[cordY][cordX] == 'X' || board[cordY][cordX] == 'O'){
                System.out.println("This spot is occupied. Please try again");
                continue;
            }
            board[cordY][cordX] = 'X';
            validMove = true;
        }

        return board;
    }
    private static char[][] compTurn(char[][] board){
        Random rand = new Random();
        boolean validMove = false;

        while (!validMove) {
            int cord = rand.nextInt(8)+1;
            int cordX = 0;
            int cordY = 0;

            switch (cord) {
                case 1 -> cordX = 0;
                case 2 -> cordX = 0;
                case 3 -> cordX = 0;
                case 4 -> cordX = 1;
                case 5 -> cordX = 1;
                case 6 -> cordX = 1;
                case 7 -> cordX = 2;
                case 8 -> cordX = 2;
                case 9 -> cordX = 2;
            }
            switch (cord) {
                case 1 -> cordY = 0;
                case 2 -> cordY = 1;
                case 3 -> cordY = 2;
                case 4 -> cordY = 0;
                case 5 -> cordY = 1;
                case 6 -> cordY = 2;
                case 7 -> cordY = 0;
                case 8 -> cordY = 1;
                case 9 -> cordY = 2;
            }
            if(board[cordY][cordX] == 'X' || board[cordY][cordX] == 'O'){
                continue;
            }
            board[cordY][cordX] = 'O';
            validMove = true;

        }

        return board;
    }
    private static void gameLogic(char[][] board){
        int occupied = 9;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] == 'X' || board[j][i] == 'O'){
                    occupied--;
                }
            }
        }

        if (occupied>0) {
            for (int i = 0; i < board.length; i++) { //vertical checks
                if ((board[i][1] == board[i][2] && board[i][1] == board[i][0]) && board[i][1] == 'O') {
                    System.out.println("COMP WIN");
                    win = true;
                }
            }
            for (int i = 0; i < board.length; i++) { // horizontal check
                if ((board[1][i] == board[2][i] && board[1][i] == board[0][i]) && board[i][1] == 'O') {
                    System.out.println("COMP WIN");
                    win = true;
                }
            }
            if ((board[1][1] == board[0][0] && board[1][1] == board[2][2] || board[1][1] == board[0][2] && board[1][1] == board[2][0]) && board[1][1] == 'O') {
                System.out.println("COMP WIN");
                win = true;
            }
        }
        if (occupied>0) {
            for (int i = 0; i < board.length; i++) { //vertical checks
                if ((board[i][1] == board[i][2] && board[i][1] == board[i][0]) && board[i][1] == 'X') {
                    System.out.println("YOU WIN");
                    win = true;
                }
            }
            for (int i = 0; i < board.length; i++) { // horizontal check
                if ((board[1][i] == board[2][i] && board[1][i] == board[0][i]) && board[i][1] == 'X') {
                    System.out.println("YOU WIN");
                    win = true;
                }
            }
            if ((board[1][1] == board[0][0] && board[1][1] == board[2][2] || board[1][1] == board[0][2] && board[1][1] == board[2][0]) && board[1][1] == 'X') {
                System.out.println("YOU WIN");
                win = true;
            }
        }
        if (occupied == 0) { //player
            System.out.println("TIE!");
            win = true;
        }



    }
}
