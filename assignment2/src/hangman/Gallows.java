package hangman;

import java.util.ArrayList;

public class Gallows {
    
    private String word; 
    private String dots = "";
    private int chances = 10;
    private ArrayList<Character> guessedLetters;

    public Gallows(String str){

        this.word = str;

        initializeDots();        
        
        guessedLetters = new ArrayList<>();
    }

    public Gallows(){

        WordReader file = new WordReader("words.txt");

        this.word = file.getWord();

        initializeDots();

        guessedLetters = new ArrayList<>();

    }

    public String getWord(){
        return this.word;
    }

    public void guessLetter(char letter){
        if(guessedLetters.contains(letter))
            System.out.println("You have already guessed this letter...");
        else 
        {
            guessedLetters.add(letter);
            if(word.indexOf(letter) != -1) //letter is found
            {
                addLetter(letter);
                System.out.println((letter + " is in the word"));
            }
            else
            {
                chances--; //decrease
                System.out.println(letter + " is not in the word");
            }
        }
    }

    public void printmistakes()
    {
        System.out.println("Remaining mistakes: " + this.chances);
    }

    public void printGuesses(){
        System.out.print("Guessed letters: [" );
        for(Character letter : guessedLetters)
            System.out.print(letter);
        System.out.print("] \n");
    }

    public void printDots(){
        System.out.println("Word: " + this.dots);
    }

    private void addLetter(char letter){
        
        ArrayList<Integer> indexes = new ArrayList<>();

        int index = this.word.indexOf(letter);

        while(index >= 0){
            indexes.add(index);
            this.word = this.word.substring(0,index) + "." + this.word.substring(index+1);
            index = this.word.indexOf(letter);
        }

        for(Integer currentIndex : indexes){
            this.dots = this.dots.substring(0,currentIndex) + letter + this.dots.substring(currentIndex + 1);
        }
    }

    public boolean checkEnd(){
        if(chances <= 0)
        {
            System.out.println("You are out of chances");
            return true;   
        }
        else if (this.dots.indexOf(".") < 0)
        {
            System.out.println("You have guessed the word, congratulations!");
            return true;
        }
        return false;
    }

    private void initializeDots(){

        for ( int i = 0; i < this.word.length(); i++)
            this.dots += ".";
    }

}
