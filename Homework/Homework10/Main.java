/*

    AJ Leichner
    Douglas Lundin
    CSC160-179 - Computer Science 1: Java
    7 November 2021

    A game program that fulfills the requirements of the 
	homework 10 assigned in CSC160-179.

*/

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random random = new Random();


		WarriorFred[] warriorArray = new WarriorFred[5];
		warriorArray[0] = new WarriorFred();
		warriorArray[1] = new WarriorFred();
		warriorArray[2] = new WarriorFred();
		warriorArray[3] = new WarriorFred();
		warriorArray[4] = new WarriorFred();

		warriorArray[0].setNickname("Archer");
		warriorArray[1].setNickname("Mage");
		warriorArray[2].setNickname("Healer");
		warriorArray[3].setNickname("Tank");
		warriorArray[4].setNickname("Rogue");

		System.out.println("*** Battle! ***   All warriors start with 10 units of health for 10 rounds");

		int round = 1;
		int damage = 0;
		while(round != 11) {
			System.out.println("\nRound " + round + "\n");

			for(int i = 0; i <= 4; i++) { // Damage taking loop
				if(warriorArray[i].isDead()) { // Death check
					System.out.println("Warrior " + warriorArray[i].getNickName() + " is dead.");
				} else {
					damage = random.nextInt(10) + 1;
					System.out.println("Warrior " + warriorArray[i].getNickName() + " status (health=" + warriorArray[i].getLifeForce() + ", damage=" + warriorArray[i].getDamage() + ")");
					System.out.println(warriorArray[i].getNickName() + " is attacked and takes " + damage + " units of damage\n    " + warriorArray[i].reaction()); 
					warriorArray[i].takeDamage(damage);
					if(warriorArray[i].isDead()) // Death check
						System.out.println("Warrior " + warriorArray[i].getNickName() + " has died!");
				}

			}

			round++;
		}

		System.out.println("How did the warriors fare?\n"); // Ending close
		for(int i = 0; i <= 4; i++) {
			warriorArray[i].printInfo();
		}

	}

}
