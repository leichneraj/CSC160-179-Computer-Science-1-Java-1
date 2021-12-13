/*

    AJ Leichner
    Douglas Lundin
    CSC160-179 - Computer Science 1: Java
    3 October 2021

    A program that asks completes the requirements for the 6.30 problem on page 243.

*/

import java.util.Random;

public class Dice {

    public static void main(String[] args) {
        Random random = new Random();

        int firstN = 0, secondN = 0; // Initializes dice
        while((firstN + secondN) != 2 && (firstN + secondN) != 3 && (firstN + secondN) != 12 && (firstN + secondN) != 7 && (firstN + secondN) != 11) { // While total != special numbers defined in problem
            int points;
            firstN = random.nextInt(6) + 1;
            secondN = random.nextInt(6) + 1;

            System.out.println("You rolled " + firstN + " + " + secondN + " = " + (firstN + secondN) );
            if((firstN + secondN) != 2 && (firstN + secondN) != 3 && (firstN + secondN) != 12 && (firstN + secondN) != 7 && (firstN + secondN) != 11) { // While total != special numbers defined in problem
                points = firstN + secondN; // Initalizes points
                do { // Do-while for as long as the total doesn't equal points or 7
                    System.out.println("Point is " + points);
                    
                    firstN = random.nextInt(6) + 1;
                    secondN = random.nextInt(6) + 1;

                    System.out.println("You rolled " + firstN + " + " + secondN + " = " + (firstN + secondN) );
                } while((firstN + secondN) != 7 && (firstN + secondN) != points);

                if(firstN + secondN == 7) { // Checks which result after do-while ends
                    System.out.println("You lose!");
                    return; // Stops the program if the total equals 7
                } else {
                    System.out.println("You win!");
                    return; // Stops the program if the total equals the points
                }
            }

            //Checks result of first roll if there is no point rolled
            if((firstN + secondN) == 2 || (firstN + secondN) == 3 || (firstN + secondN) == 12) 
                System.out.println("You lose!");
            else if((firstN + secondN) == 7 || (firstN + secondN) == 11)
                System.out.println("You win!");

        }

    }

}