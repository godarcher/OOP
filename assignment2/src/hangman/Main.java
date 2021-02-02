package hangman;

public class Main {
	public static void main(String[] args) {
		WordReader file = new WordReader("assignment2/words.txt");
		System.out.println(file.getWord());
	}
}
