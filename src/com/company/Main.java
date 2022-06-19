/**  Tutorial 17.06.2022: "Lerne Java in einem Video - Das Java All in One Tutorial"
 *   Quelle Youtube: https://youtu.be/s6i1Ou6R7vk
 *   Tik_Tak_Toe
 *   @version:Rev_A_19.06.2022
 *   @author:Sascha_Marinkovic
 *   Rev 0: 17.06.2022 - Erstellung
 *   Rev A: 19.06.2022 - Debugging (siehe Eintrag Datum Kommentare)
 *
 *   Information:
 *
 *   Darstellung Spielbrett:
 *
 *    # | # | #          Zeichen: Space#Space|Space#Space|Space#Space
 *    _____________               13 Stück Unterstrich: _
 *    # | # | #
 *    _____________
 *    # | # | #
 *
 *
 */

package com.company;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int turn = 0;                                   // beginnt mit einem Zug
        int winner = -1;                                // Gewinner steht noch nicht fest -> Wert: -1
        int[] board = new int[9];                       // Definition wie das Spielbrett aussieht.
                                                        /* For-Schleife -> Solange "Spielbrett Array" >9 (new in[9] nicht durch, definiere -1 für jeden Array als Wert.
                                                           Alternativ Zeile 35 (19.06.2022):
                                                           for(int i = 0; i < board.length; i++) {
                                                               board[i] = -1; */
        Arrays.fill(board, -1);

        Player a = new Player(0);
        Player b = new Player(1);
        Player[] players = new Player[2];
        players[0] = a;
        players[1] = b;


        while(winner == -1){                            // While-Schleife prüft ob die Konditionen in Methode checkwinner + board erfüllt werden.
            printBoard(board);
            int turnField = players[turn].getTurn();
            if(players[turn].validateTurn(board, turnField)){
                board[turnField] = players[turn].number;
                turn = (turn + 1) % 2;                  // Abwechselnde Spieler, Anzahl 2, stellt durch Modulo um: 0,1,0,1.
            }
            winner = checkWinner(board);
        }
        System.out.println( "Herzlichen Glückwunsch, Spieler " + winner + ". Du hast gewonnen!");
        printBoard(board);
    }

    public static int checkWinner(int[] board){
                                                        /* Prüft alle Möglichkeiten, dass ein Spieler gewonnen hat.

                                                           Alternative Zeile 62 (19.06.2022):
                                                           int winner = -1;         */
        int winner;

        if(board[0] == board[1] && board[0] == board[2] && board[0] != -1){
            winner = board[0];
                                                        // Horizontale Zeile 1
        }
        else if(board[3] == board[4] && board[3] == board[5] && board[0] != -1){
            winner = board[3];
                                                        // Horizontale Zeile 2
        }
        else if(board[6] == board[7] && board[6] == board[8] && board[0] != -1){
            winner = board[6];
                                                        // Horizontale Zeile 3
        }
        else if(board[0] == board[3] && board[0] == board[6] && board[0] != -1) {
            winner = board[0];
                                                        // Vertikale Spalte 1
        }
        else if(board[1] == board[4] && board[1] == board[7] && board[0] != -1) {
            winner = board[1];
                                                        // Vertikale Spalte 2
        }
        else if(board[2] == board[5] && board[2] == board[8] && board[0] != -1) {
            winner = board[2];
                                                        // Vertikale Spalte 3
        }
        else if(board[0] == board[4] && board[0] == board[8] && board[0] != -1){
            winner = board[0];
                                                        // Diagonale 1
        }
        else if(board[2] == board[4] && board[2] == board[6] && board[0] != -1){
            winner = board[2];
                                                        // Diagonale 2
        }
        else{
            winner = -1;
                                                        // noch kein Sieger gefunden.
        }
        return winner;                                  // Gibt den Wert der Abfrage als Zahlenwert aus.
    }


    public static void printBoard(int[] meinBoard){     /* Gibt das Spielfeld mit der vorgegebenen Zeichenkette, und dem int/array "board" aus "main" aus.
                                                           (-1 = noch nicht besetzt / 0 = Spieler 1 / 1 = Spieler 2) */

        System.out.println(meinBoard[0] + " | " + meinBoard[1] + " | " + meinBoard[2]);
        System.out.println("_____________");
        System.out.println(meinBoard[3] + " | " + meinBoard[4] + " | " + meinBoard[5]);
        System.out.println("_____________");
        System.out.println(meinBoard[6] + " | " + meinBoard[7] + " | " + meinBoard[8]);


    }
}
