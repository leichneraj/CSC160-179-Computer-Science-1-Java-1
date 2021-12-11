/*

    AJ Leichner
    Douglas Lundin
    CSC160-179 - Computer Science 1: Java
    10 December 2021

    A program which creates a player for 
    the dice game. Initiated by the main file.

*/

public class Player {

    private int score = 0;
    private String name = null;
    
    public Player(int score, String name) { // Constructor
        this.score = score;
        this.name = name;
    }

    // Getters
    public String getName() { return this.name; }
    public int getScore() { return this.score; }

    // Adds an integer to a player's score
    public void addRoll(int roll) { this.score += roll; }

    // Sets a players score
    public void setScore(int newScore) { this.score = newScore; }

}
