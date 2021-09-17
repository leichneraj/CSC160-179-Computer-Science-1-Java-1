/*

    AJ Leichner
    Douglas Lundin
    CSC160-179 - Computer Science 1: Java
    19 September 2021

    A program that asks the user for a string then counts the number of vowels and consanants in it.

*/

import java.util.Scanner;

public class ConsonantsVowels {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String s = input.nextLine().toUpperCase();

        input.close();

        int vowels = 0, consonants = 0;

        for(int i = 0; i < s.length(); i++) { // Runs a loop through each of the letters and does a switch statement to see if they are a vowel or not.
            switch(s.charAt(i)) {

                case 'A': case 'E': case 'I': case 'O': case 'U':
                vowels++;
                break;

                default:
                if(s.charAt(i) != ' ') { // If the char is not a space, it adds one to the consonants.
                    consonants++;   
                }
                break;
            }
        }

        System.out.println("The number of vowels is " + vowels + "\nThe number of consonants is " + consonants);

    }

}