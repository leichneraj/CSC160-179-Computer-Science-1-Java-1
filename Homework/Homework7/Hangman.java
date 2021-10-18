/*

    AJ Leichner
    Douglas Lundin
    CSC160-179 - Computer Science 1: Java
    17 October 2021

    A hangman game program.

*/

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    
    static Random random = new Random();

    static String[] words = {"child", "massive", "super", "computer", "science", "java", "south", "north", "west", "east", "impossible", "freezing", "winter", "summer", "spring", "fall", "January", "February", "March", "April", "June", "July", "August", "September", "October", "November", "December"};
    static int randomN = random.nextInt(27);
    static char[] letters = new char[words[randomN].length()];

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        char[] guessedLetters = new char[words[randomN].length()];
        for(int i = 0; i <= words[randomN].length() - 1; i++) {
            letters[i] = words[randomN].toLowerCase().charAt(i); 
            guessedLetters[i] = '*';
        }

        boolean wordGuessed = false;
        int counter = 0;
        while(!wordGuessed) {
            System.out.print("Enter a letter in word: "); System.out.print(guessedLetters); System.out.print(" > ");

            String guess = input.next();
            String found = checkLetter(guess, guessedLetters, letters);
            if(found == "within")
            System.out.println("Correct!");
            else if(found == "wrong") {
                System.out.println("You missed!");
                counter++;
            } else 
                System.out.println(guess.charAt(0) + " has already been found in the word.");
            

            if(checkIfSolved(guessedLetters, letters)) 
            wordGuessed = true;
        }
        
        System.out.println("The word is " + words[randomN] + ". You missed " + counter + " times.");

        input.close();
    }

    public static String checkLetter(String input, char[] guessedWord, char[] word) {
        char letter = input.toLowerCase().charAt(0);

        String result = "wrong";
        for(int i = 0; i <= word.length -1; i++) {
            if(letter == word[i] && !checkPrevious(letter)) {
                guessedWord[i] = letter;
                result = "within";
            } else if(letter != word[i] && !checkPrevious(letter)) {
                
            }
        }

        return result;
    }

    static final char[] checkedPrevious = new char[letters.length];
    public static boolean checkPrevious(char guess) {
        boolean usedBefore = false;

        for(int i = 0; i <= checkedPrevious.length - 1; i ++) {
            if(guess == checkedPrevious[i])
            usedBefore = true;
        }

        return usedBefore;
    }

    public static boolean checkIfSolved(char[] solving, char[] answer) {
        boolean correct = true;

        for(int i = 0; i <= solving.length - 1; i++) {
            if(solving[i] != answer[i]) {
                correct = false;
            }
        }

        return correct;
    }

}