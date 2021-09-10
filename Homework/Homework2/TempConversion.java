/*

    AJ Leichner
    Douglas Lundin
    CSC160-179 - Computer Science 1: Java
    12 September 2021

*/

import java.util.Scanner;

public class TempConversion { // To convert from celcius to fahrenheit

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double celcius = 0;

        System.out.print("What is your celcius input? ");
        try {                                               // Attempts to execute the input code.
            celcius = input.nextDouble();

            System.out.println("Fahrenheit equivalent is " + ((9.0 / 5) * celcius + 32)); // Prints conversions
        } catch(Exception e) {                              // If the code can't execute because of the wrong input type, it completes a print statement explaining so.
            System.out.println("Incorrect dataType. Please enter in a double or integer.\n");
            main(args);
        }

        input.close();
    }

}