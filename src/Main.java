import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String word = "pizza";
        Scanner sc = new Scanner(System.in);
        int guess = 0;
        ArrayList<Character> wordState = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            wordState.add('_');
        }

        System.out.println("***********************");
        System.out.println("* Welcome to Hangman! *");
        System.out.println("***********************");
        WrongGuess wrongGuess = new WrongGuess();
        while (true) {
            int winCounter = 0;
            boolean isLetter = false;
            //wrongGuess.getPrintGuess(guess);
            System.out.print("Guess a letter: ");
            char letter = sc.next().charAt(0);
            for (int i = 0; i < word.length(); i++) {
                if (word.charAt(i) == letter) {
                    wordState.set(i, letter);
                    isLetter = true;
                }
            }
            if (!isLetter) {
                guess++;
            }
            wrongGuess.getPrintGuess(guess);
            System.out.println(wordState);
            for (Character character : wordState) {
                if (character != '_') {
                    winCounter++;
                    if (winCounter == word.length()) {
                        System.out.println("You win!");
                        return;
                    }
                }
            }

            if (guess == word.length() + 1) {
                System.out.println("You lose!");
                break;
            }
        }
        sc.close();
    }
}