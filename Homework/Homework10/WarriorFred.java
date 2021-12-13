/*

    AJ Leichner
    Douglas Lundin
    CSC160-179 - Computer Science 1: Java
    7 November 2021

    A game program that fulfills the requirements of the 
	homework 10 assigned in CSC160-179.

*/

import java.util.Random;
public class WarriorFred {

	private String nickName = "unknown";
	private int lifeForce = 10;
	private int damage = 0;
	
	String[] armory = {"Exploding Pumpkin", "Candy Corn", "Paper Bag"};
	
	public void printInfo() {
        System.out.println("Nick Name:" + getNickName());
        System.out.println("Life Force:" + getLifeForce());
        System.out.println("Damage:" + getDamage());
        for(int i=0;i<armory.length;i++)
            System.out.println("Armory:" + this.armory[i]);
        System.out.println();
    }

	// Setter
	public void setNickname(String nick) { nickName = nick; }

	// Getters
	public String getNickName() { return nickName; }
	public int getLifeForce() { return lifeForce; }
	public int getDamage() { return damage; }

	public void reSpawn() {
		lifeForce = 10;
	}
	
	public void takeDamage(int n) {
		damage += n;
		if (damage >= 10) {
			lifeForce--;
			damage = 0;
		}
	}
	
	public String reaction() {
		Random r = new Random();
		String[] sound = {"OW!", "Wham!", "POW!", "Boffo!!", "KaPow!", "That one hurt!"};
		return sound[r.nextInt(sound.length)];
	}
	
	public boolean isDead() {
		if (lifeForce <= 0) return true;
		else return false;
	}
	
	public boolean isAlive() {
		if (lifeForce > 0) return true;
		else return false;
	}
	
}