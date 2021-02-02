package hangman;

import java.util.Scanner;

public class GallowsUI {

    private static Scanner scanner = new Scanner(System.in);
	private static Gallows game;

    public void initializeGame(){
        System.out.println("Welcome to Hangman!");
		System.out.println("Please enter a word or press Enter to randomly pick one");
		String word = scanner.nextLine();
		if(word.isEmpty()){
			System.out.println("Randomly picking a word");
			game = new Gallows();
		} else{
			game = new Gallows(word);
		}
    }

    public void playGame(){
        while(!game.checkEnd()){
			game.printmistakes();
			game.printGuesses();
			game.printDots();
			char letter = scanner.next().charAt(0);
			scanner.nextLine();
			game.guessLetter(letter);
		}
    }
}
