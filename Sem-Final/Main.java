/*

    AJ Leichner
    Douglas Lundin
    CSC160-179 - Computer Science 1: Java
    10 December 2021

    A program that plays the game '30 or bust' between two different players.
    Each player takes turns to try and get an exact score of 30.

*/

import java.util.Scanner;
import java.util.Random;

public class Main {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        introGame();
        // Creating players
        System.out.print("<===-- Player one, please enter your name --===>\n     > ");
        Player player1 = new Player(0, input.nextLine());
        System.out.print("\n\n<===-- Player two, please enter your name --===>\n     > ");
        Player player2 = new Player(0, input.nextLine());
        
        // Introduction to game
        System.out.println("\nWelcome to the game players '" + player1.getName() + "' and '" + player2.getName() + "'! The rules of the game are simple: Your goal is to reach a score of exactly 30. If you go over 30 you bust and restart at 0. In order to add to their score, a player may choose one of two dice that are rolled and add it to their score or choose both dice to be added to their score. Players each take turns, starting with player one, " + player1.getName() + "!\n\n");
        
        int dice1 = 0, dice2 = 0;
        Random random = new Random();
        boolean player1Turn = true; // Used to tell which players turn the loop is on (true for player1, false for player2)

        while ((player1.getScore() != 30) && (player2.getScore() != 30)) { // While loop for continuation of game
            displayTurn(player1Turn, player1, player2);

            // Creates new random integers for the dice and prints the dice.
            dice1 = random.nextInt(6) + 1;
            printDie(dice1);
            dice2 = random.nextInt(6) + 1;
            printDie(dice2);

            System.out.println("<===-- You rolled "+ dice1 +" and "+ dice2 + " --===>\n");
            // Score choosing/addition process
            System.out.print("Would you like to keep one or both dice? (o/b)\n     > ");
            char answer = input.next().charAt(0);
            if(answer == 'o') {
                System.out.print("Which dice would you like to keep? (" + 1 + "/" + 2 + ")\n     > ");
                int whichDie = input.nextInt();
                if(whichDie == 1) {
                    if(player1Turn) {
                        player1.addRoll(dice1);
                        displayScore(player1Turn, player1, player2);
                    } else {
                        player2.addRoll(dice1);
                        displayScore(player1Turn, player1, player2);
                    }
                } else if(whichDie == 2) {
                    if(player1Turn) {
                        player1.addRoll(dice2);
                        displayScore(player1Turn, player1, player2);
                    } else {
                        player2.addRoll(dice2);
                        displayScore(player1Turn, player1, player2);
                    }
                } else {
                    System.out.println("Invalid input. Restart game."); // Stops game if the player enters an invalid input.
                    return;
                }
            } else if(answer == 'b') {
                if(player1Turn) {
                    player1.addRoll(dice1 + dice2);
                    displayScore(player1Turn, player1, player2);
                } else {
                    player2.addRoll(dice1 + dice2);
                    displayScore(player1Turn, player1, player2);
                }
            } else {
                System.out.println("Invalid input. Restart game."); // Stops game if the player enters an invalid input.
                return;
            }

            if(player1Turn) { // Checks if the current player has reached a score of 30 or exceeded 30
                if(player1.getScore() == 30) {
                    displayWin();
                }
                else if (player1.getScore() > 30) { // Prints bust and resets score to 0
                    displayBust();
                    player1.setScore(0); 
                }
            } else {
                if(player2.getScore() == 30) {
                    displayWin();
                }
                else if (player2.getScore() > 30) { // Prints bust and resets score to 0
                    displayBust();
                    player2.setScore(0);
                }
            }

            if(player1Turn) // Swithces which players' turn it is
                player1Turn = false;
            else
                player1Turn = true;

            System.out.println("*------------------------------------------------------*\n");

        }   

        input.close();

    }

        public static void introGame() { // Introduces the game
            System.out.println("        *--------------------------------------------------*\n" +
                                "        |  ===   ===   ===== ===    ===  =   =  ===  ====  |\n" +
                                "        |     ] [  =]  [   ] [  ]   [  ] [   ] [      []   |\n" +
                                "        |  ===  [ = ]  [   ] ===    [ ]  [   ]  ===   []   |\n" +
                                "        |     ] [=  ]  [   ] [  ]   [  ] [   ]     ]  []   |\n" +
                                "        |  ===   ===   ===== [   ]  ===   ===   ===   []   |\n" +
                                "________|--------------------------------------------------|_______\n" + 
                                "|  ==  ==  ==  ====  =      ===   =====     ==  ==    ====  ||||  |\n" +
                                "|  ==  ==  ==  [     [     [     [     ]  ==  ==  ==  [     ||||  |\n" +
                                "|  ==  ==  ==  [===  [     [     [     ]  ==  ==  ==  [===   ||   |\n" +
                                "|  ==  ==  ==  [     [     [     [     ]  ==  ==  ==  [           |\n" +
                                "|    ==  ==    ====  ====   ===   =====   ==  ==  ==  ====   ||   |\n" + 
                                "*-----------------------------------------------------------------*");
        }

        public static void displayTurn(boolean player1Turn, Player player1, Player player2) {

            if(player1Turn) {
                System.out.println("\n<===-- " + player1.getName() + " --===>");
                displayScore(player1Turn, player1, player2);
            } else {
                System.out.println("\n<===-- " + player2.getName() + " --===>");
                displayScore(player1Turn, player1, player2);
            }

        }

        public static void displayScore(boolean player1Turn, Player player1, Player player2) {

            if(player1Turn) {
                System.out.println("\n[Current score for '" + player1.getName() + "' is " + player1.getScore() + "]          (" + (30 - player1.getScore()) + " away from 30!)\n");
            } else {
                System.out.println("\n[Current score for '" + player2.getName() + "' is " + player2.getScore() + "]          (" + (30 - player2.getScore()) + " away from 30!)\n");
            }

        }

        public static void printDie(int die) {

            switch (die) {

                case 1:
                System.out.println(   "*============*\n"
                                    + "[            ]\n"
                                    + "[            ]\n"
                                    + "[     ..     ]\n"
                                    + "[     ''     ]\n"
                                    + "[            ]\n"
                                    + "[            ]\n"
                                    + "*============*");
                break;
                
                case 2:
                System.out.println(   "*============*\n"
                                    + "[         .. ]\n"
                                    + "[         '' ]\n"
                                    + "[            ]\n"
                                    + "[            ]\n"
                                    + "[ ..         ]\n"
                                    + "[ ''         ]\n"
                                    + "*============*");
                break;

                case 3:
                System.out.println(   "*============*\n"
                                    + "[         .. ]\n"
                                    + "[         '' ]\n"
                                    + "[     ..     ]\n"
                                    + "[     ''     ]\n"
                                    + "[ ..         ]\n"
                                    + "[ ''         ]\n"
                                    + "*============*");
                break;

                case 4:
                System.out.println(   "*============*\n"
                                    + "[ ..      .. ]\n"
                                    + "[ ''      '' ]\n"
                                    + "[            ]\n"
                                    + "[            ]\n"
                                    + "[ ..      .. ]\n"
                                    + "[ ''      '' ]\n"
                                    + "*============*");
                break;

                case 5:
                System.out.println(   "*============*\n"
                                    + "[ ..      .. ]\n"
                                    + "[ ''      '' ]\n"
                                    + "[     ..     ]\n"
                                    + "[     ''     ]\n"
                                    + "[ ..      .. ]\n"
                                    + "[ ''      '' ]\n"
                                    + "*============*");
                break;

                case 6:
                System.out.println(   "*============*\n"
                                    + "[ ..      .. ]\n"
                                    + "[ ''      '' ]\n"
                                    + "[ ..      .. ]\n"
                                    + "[ ''      '' ]\n"
                                    + "[ ..      .. ]\n"
                                    + "[ ''      '' ]\n"
                                    + "*============*");
                break;

                default:
                System.out.println("Error, incorrect die roll.");
                break;

            }

        }

        public static void displayWin() { // If score of 30 is reached

            System.out.println( "*------------------------------------------------------*\n" +
                                "| ==    == ===== =   =  ==  ==  == ==== ==    ==  |||| |\n" +
                                "|  ==  ==  [   ] [   ]  ==  ==  ==  []  ====  ==  |||| |\n" +
                                "|    ==    [   ] [   ]  ==  ==  ==  []  == == ==   ||  |\n" +
                                "|    ==    [   ] [   ]  ==  ==  ==  []  ==  ====       |\n" +
                                "|    ==    =====  ===     ==  ==   ==== ==    ==   ||  |\n" +
                                "*------------------------------------------------------*");

        }

        public static void displayBust() { // If score over 30 is reached

            System.out.println( "*------------------------------*\n" +
                                "|  ===  =   =  ===  ====  |||| |\n" +
                                "|  [  ] [   ] [      []   |||| |\n" +
                                "|  [ ]  [   ]  ===   []    ||  |\n" +
                                "|  [  ] [   ]     ]  []        |\n" +
                                "|  ===   ===   ===   []    ||  |\n" +
                                "*------------------------------*");

        }

}
