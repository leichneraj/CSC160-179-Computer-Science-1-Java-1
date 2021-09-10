import java.util.Random;
import java.util.Scanner;

public class RandomAddition {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner input = new Scanner(System.in);

        int number1 = random.nextInt(9) + 1;
        int number2 = random.nextInt(9) + 1;
        int answer = 0;

        if(number1 < number2) {
            int temp = number1;
            number1 = number2;
            number2 = temp;
        }

        try {                            // Attempts to execute the input code.
            System.out.print("What is " + number1 + " + " + number2 + " ? ");
            answer = input.nextInt();
        } catch(Exception e) {           // If the code can't execute because of the wrong input type, it completes a print statement explaining so.
            System.out.println("Incorrect dataType. Please enter in an integer.\n");
            main(args);
        }

        if(number1 + number2 == answer) {
            System.out.println("You are correct!");
        } else {
            System.out.println("Your answer is wrong.");
            System.out.println(number1 + " + " + number2 + " should be " + (number1 + number2));
        }

        input.close();
    }

}
