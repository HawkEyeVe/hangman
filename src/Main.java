import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String filepath = "src/words.txt";
        ArrayList<String> words = new ArrayList<>();
        String word;
        try (BufferedReader reader = new BufferedReader(new FileReader(filepath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                words.add(line.trim().toLowerCase());
            }
            int random = (int) (Math.random() * words.size());
            word = words.get(random);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
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
                System.out.println("The word was: " + word);
                break;
            }
        }
        sc.close();
    }
}