package hangman;

import java.util.Scanner;

public class Main {

	private static GallowsUI ui = new GallowsUI();
	public static void main(String[] args) {

		ui.initializeGame();
		ui.playGame();
		
	}
}
