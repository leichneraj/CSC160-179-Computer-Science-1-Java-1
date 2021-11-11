/*

    AJ Leichner
    Douglas Lundin
    CSC160-179 - Computer Science 1: Java
    24 October 2021

    A program which asks the user for an input
    between 0 and 511, then converts that input
    into a binary char array and prints it.

*/

import java.util.Scanner;

public class HeadsTails {
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a number between 0-511: ");
        int decimalN = input.nextInt();
        String binaryString = Integer.toBinaryString(decimalN); // Puts the integer into a binary string

        char[] binaryArray = {'0', '0', '0', '0', '0', '0', '0', '0', '0'};
        char[] tempBinaryArray = binaryString.toCharArray(); // Puts binaryString into a char array

        // System.out.println(tempBinaryArray); // For testing only

        // To put the binaryString into a binaryArray 
        if(tempBinaryArray.length != 9) {
            for(int i = 0, n = 9; i <= binaryArray.length - 1; i++, n--) {
                if(tempBinaryArray.length <= i && tempBinaryArray.length >= n) {
                    binaryArray[n - 1] = tempBinaryArray[n - 1];
                }
            }
        } else if(tempBinaryArray.length > 9) {
            System.out.println("Must enter a value within 0-511"); // Out-of-bounds protection
        } else {
            binaryArray = tempBinaryArray;
        }

        // Printing
        System.out.println(binaryArray[0] + " " + binaryArray[1] + " " + binaryArray[2]);
        System.out.println(binaryArray[3] + " " + binaryArray[4] + " " + binaryArray[5]);
        System.out.println(binaryArray[6] + " " + binaryArray[7] + " " + binaryArray[8]);

        input.close();
    }

}
