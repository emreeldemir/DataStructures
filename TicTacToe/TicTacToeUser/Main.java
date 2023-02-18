

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int row = 0;
        int column = 0;

        TicTacToe ticTacToe = new TicTacToe();

        for (int i = 0; i < 9; i++) {
            if (ticTacToe.getPlayer()==1) {
                System.out.println("Player X");
                System.out.print("Row : ");
                row = scanner.nextInt();
                System.out.print("Column : ");
                column = scanner.nextInt();
            } else {
                System.out.println("Player O");
                System.out.print("Row : ");
                row = scanner.nextInt();
                System.out.print("Column : ");
                column = scanner.nextInt();
            }
            ticTacToe.putMark(row - 1 ,column - 1 );
            ticTacToe.printBoard();
        }





    }

}
