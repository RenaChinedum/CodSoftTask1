package org.rena;

import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {

    public void guessNumberGame(){
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();

        int minRange = 1;
        int maxRange = 100;
        int attempts = 10;
        int score = 0;

        System.out.println("Welcome to Guess Right Game");
        System.out.println(
                                                        "Instruction: \n"+
                        "In This Game a Random Number is generated and you're to guess \n"+
                        "the number, if your guess is correct you're scored if not you try \n +" +
                                    " again till you exhaust your number of attempts \n" +
                                                "you have " + attempts + " left" +
                                    "\nGuess a number between " + minRange + " and" + maxRange +
                                                            "\nGoodLuck!"
        );
        boolean playAgain = true;
        while (playAgain){
            int randomNumber = rd.nextInt(maxRange - minRange + 1) + minRange;
            int attemptsLeft = attempts;
            System.out.println(
                    """

                            New Round!\s
                            Try Guessing a number"""
            );
            boolean numberGuessedCorrectly = false;
            while (attempts > 0 && !numberGuessedCorrectly) {
                System.out.println("Enter Your Guess: ");
                int guess = sc.nextInt();
                if (guess == randomNumber) {
                    System.out.println("Congrats! Your Guess is Correct");
                    numberGuessedCorrectly = true;
                    score++;
                } else if (guess > randomNumber) {
                    if (attempts == 0){
                        System.out.println("Your Guess is Higher! You have " + --attempts + " attempts left");
                    }
                    System.out.println("Your Guess is Higher! Try Again. You have " + --attempts + " attempts left");
                } else {
                    if (attempts == 0){
                        System.out.println("Your Guess is Higher! You have " + --attempts + " attempts left");
                    }
                    System.out.println("Your Guess is Lower!  Try Again. You have " + --attempts + " attempts left");
                }

            }
            System.out.println("Game over. The number was: " + randomNumber);
            System.out.println("You Scored " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            String answer = sc.next();
            playAgain = answer.equalsIgnoreCase("yes");
        }
        System.out.println("Thank You For Playing. \nFinal Score: " + score);
        sc.close();

    }

}
