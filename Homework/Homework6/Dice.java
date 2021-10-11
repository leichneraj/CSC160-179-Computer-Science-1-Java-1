/*

    AJ Leichner
    Douglas Lundin
    CSC160-179 - Computer Science 1: Java
    3 October 2021

    A program that asks completes the requirements for the 6.30 problem on page 243.

    Not for Doug:
    This is a terrible program I have written. My deadline is coming due and this 
    program is not nearly as good as I can make it. I'm sorry but I've been very busy
    and needed to get this done.

*/

import java.util.Random;

import javax.management.monitor.GaugeMonitor;

public class Dice {

    public static void main(String[] args) {
        game(-1);
    }

        static int repeats = 0;
    public static void game(int previousPoints) {
        Random random = new Random();

        int firstN, secondN = 0;
        boolean success = false;
        while(success == false) {
            int points;
            firstN = random.nextInt(6) + 1;
            secondN = random.nextInt(6) + 1;
            
            int total = firstN + secondN;
            System.out.println("You rolled " + firstN + " + " + secondN + " = " + total);

            if(total == 7 || total == 11) {
                System.out.println("You win!");
                success = true;
            } else if(total == 2 || total == 3 || total == 12) {
                System.out.println("You lose!");
                success = true;
            } else {
                points = total;
                if(repeats == 0) {
                    System.out.println("point is " + points);
                    repeats++;
                    game(points);
                } else if ((repeats == 1 && previousPoints != points) && success == false) {
                    System.out.println("You lose!");
                    success = true;
                    System.exit(1);
                } else {
                    System.out.println("You win!");
                    success = true;
                }
            }
        }
    }

}