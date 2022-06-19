package com.company;

                                                /* Player.java = Erstellte Klasse zum erstellen von Spielern.
                                                   import java.util.Scanner = bestehende Klasse, importiert für weitere Funktionen. */
import java.util.Scanner;


public class Player {
    int number;
    Scanner scanner = new Scanner(System.in);

    public Player(int number){                 // Erstellen eines Konstruktors, um das Objekt Spieler zu erzeugen.
        this.number = number;                  // Instanzierung der Erweiterung des Konstruktors.
    }


    public int getTurn() {                      /* Spielerzug einfordern durch Eingabe.
                                                   Falscheingabe führt zu: Fehlermeldung + Rekursion. */
        System.out.println("Player " + number + " - du bist am Zug!");
        int input = scanner.nextInt();
        if (input < 9 && input >= 0) {
            return input;
        }
        System.out.println("Ungültige Eingabe! Bitte eine Zahl für das Feld 0-8 eingeben");
        return getTurn();

    }

    public boolean validateTurn(int[] board, int turn){
                                                // Prüft ob der Turn gültig ist -> das Feld noch nicht ausgefüllt.
        if(board[turn] == -1){
            return true;
        }
                                                // Gibt eine Fehlermeldung aus, da Wert "valdidateTurn" false ausgibt.
        System.out.println("Feld ist schon belegt");
        return false;
    }
}
