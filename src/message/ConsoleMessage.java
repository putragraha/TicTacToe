package message;

import java.util.Scanner;

public class ConsoleMessage {
    public boolean showIntro() {
        System.out.println("Welcome to Tic Tac Toe Games");
        System.out.println();
        System.out.println("Mini Instruction : ");
        System.out.println("1. Insert tile id by key in \"n-n\", replace n with number from 0, 1, or 2");
        System.out.println("2. Make sure you're inserting available tile id");
        System.out.println("3. You're marked with \"x\" mark, and \"o\" is your opponent");

        System.out.print("4. Ready to start? (y/n) : ");
        Scanner intro = new Scanner(System.in);
        String answer = intro.nextLine();
        return (answer.toLowerCase().equals("y") || answer.toLowerCase().equals("yes"));
    }

    public void showAcceptedGameMessage() {
        System.out.println("Enjoy the game!!!");
    }

    public void showCanceledGameMessage() {
        System.out.println("Bye... You know what to click if you want to play the game again later :(");
    }

    public void showVictoryMessage() {
        System.out.println("YOU WIN! Your superior intellect prevailed and assured a sound victory.");
    }

    public void showDefeatMessage() {
        System.out.println("You've lost. Better luck next time!");
    }

    public void showDrawMessage() {
        System.out.println("Mheh! A smelly draw. Beats losing though, right?");
    }
}
