package se.stefan.projectdice;

import java.util.Scanner;
import java.util.Random;

public class Game {

    private Scanner scanner = new Scanner(System.in);

    private Random random = new Random();
    //scanner och random instanser


    private void gameMessage(String message) {
        System.out.println(message);
    }


    //Skapar en ny player/instans i metoden
    // med public Player kan vi return en player som kan användas
    private Player getPlayerNameInput(String message) {

        System.out.println(message);

        String playerName = scanner.nextLine();

        Player player = new Player(playerName);
        return player;
    }


    public void startGame() {

        gameMessage("Welcome to the Dice game!");


        Player playerOne = getPlayerNameInput("Player1 input your name");


        Player playerTwo = getPlayerNameInput("Player2 input your name");


        gameMessage("Welcome " + playerOne.getPlayerName()
                + " and " + playerTwo.getPlayerName());
        gameMessage("Lets play the game!");

        boolean diceGame = true;

        while (diceGame) {

            gameMenu();

            int menuChoice = scanner.nextInt();
            scanner.nextLine();//För att hantera radbrytning

            switch (menuChoice) {

                case 1:
                    gameMessage("The players will get two throws each, the one with " +
                            "the highest total score wins, good luck!");
                    int roll1 = throwDice(playerOne.getPlayerName());

                    int roll2 = throwDice(playerTwo.getPlayerName());

                    int roll3 = throwDice(playerOne.getPlayerName());

                    int roll4 = throwDice(playerTwo.getPlayerName());

                    int sumOne = giveSum(roll1, roll3);

                    int sumTwo = giveSum(roll2, roll4);

                    giveScore(playerOne.getPlayerName(), playerTwo.getPlayerName(), sumOne, sumTwo);


                    if (sumOne > sumTwo) {

                        gameMessage(playerOne.getPlayerName() + " wins!");
                        gameMessage("Press enter to go back to menu");
                        scanner.nextLine();

                    } else if (sumTwo > sumOne) {
                        gameMessage(playerTwo.getPlayerName() + " wins!");
                        gameMessage("Press enter to go back to menu");
                        scanner.nextLine();
                    } else {
                        gameMessage("It's a tie! Lets play again!");
                        gameMessage("Press enter to go back to menu");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    gameMessage("See you next time!");
                    diceGame = false;
                    break;

                default:
                    gameMessage("Invalid choice!");
                    break;
            }


        }

    }

    private int throwDice(String message) {
        System.out.println(message + " your turn, press enter to roll");
        scanner.nextLine();
        int roll = random.nextInt(6) + 1;
        System.out.println(message + " got " + roll);
        return roll;
    }

    private int giveSum(int a, int b) {
        return a + b;
    }

    private void giveScore(String name1, String name2, int score1, int score2) {

        gameMessage("*-------------------*");
        System.out.println(name1 + ", your total score is: " + score1);
        System.out.println(name2 + ", your total score is: " + score2);
        gameMessage("*-------------------*");

    }

    private void gameMenu() {
        gameMessage("DICE MENU");
        gameMessage("*-----------------*");
        gameMessage("1. Play");
        gameMessage("2. Quit game");
        gameMessage("*-----------------*");

    }


}
