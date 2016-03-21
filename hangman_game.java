// ---------------------------------
// © Claudia Feochari December 2015
//Code Written by: Claudia Feochari
// Date : December 24th, 2015
// Project Title : Hangman Game
// Project Description :
// This program was designed to mimic
// the popular game hangman, in which
// there are two players and the purpose
// is for one player to guess the word that
// the other player is thinking of.
// This is my first independent project.
// ---------------------------------

import java.util.Scanner;
public class hangman_game {
	public static Scanner keyboard = new Scanner(System.in);
	public static String name_1;
	public static String name_2;
	public static char guessed_letter;
	public static String guess;
	public static char [] array;
	public static String str;
	public static String category;
	public static int guess_length;
    public static int total_trials_allowed;
    public static int counter =0;
    public static int loop = 0;
	public static void main(String[] args) {
		main_game_strings();
        }
	public static void main_game_strings()
	{
		System.out.println("-----------------------------------------");
		System.out.println("            Lets play HANGMAN                 ");
		System.out.println("-----------------------------------------");
        System.out.println("Welcome to hangman, a fun game to pass the time");
        System.out.println("First of all, may i please have your name?. You will be player 1 ->");
        name_1 = keyboard.next();
        System.out.println("Well "+name_1+" welcome to hangman");
        System.out.println(name_1+" we need another player to play hangman.");
        System.out.println(name_1+" could you please find another player? What is this player's name -> ");
        name_2 = keyboard.next();
        System.out.println("Well howdy "+name_2+" !Welcome to hangman! "+name_1+" will start the game");
        System.out.println(name_2+" could I ask you to look away for a minute? "+name_1+" will enter a word and you will have to guess it?");
        System.out.println("Okay "+name_1+" enter a word and "+name_2+" will try to guess it ->");
        guess = keyboard.next();
        System.out.println(name_1+" Enter a Category");
        category = keyboard.next();
        
        for(int i = 0; i < 200;i++){
            for(int j = 0; j < 200;j++){
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println(name_2 +" now its your turn to guess");
        game();
        main_game();
        
	}
	
	public static void looped_over()
	{
		loop++;
		if(loop%2!=0)
		{
		System.out.println("Now it's "+name_1+" time to guess the word "+name_2+"has in mind");
		System.out.println(name_1+" could I ask you to look away for a minute? "+name_2+" will enter a word and you will have to guess it?");
        System.out.println("Okay "+name_2+" enter a word and "+name_1+" will try to guess it ->");
        guess = keyboard.next();
        System.out.println(name_2+" Enter a Category");
        category = keyboard.next();
		}
		else if(loop%2==0)
		{
		System.out.println("Now it's "+name_2+" time to guess the word "+name_1+"has in mind");
		System.out.println(name_2+" could I ask you to look away for a minute? "+name_1+" will enter a word and you will have to guess it?");
	    System.out.println("Okay "+name_1+" enter a word and "+name_2+" will try to guess it ->");
        guess = keyboard.next();
        System.out.println(name_1+" Enter a Category");
	    category = keyboard.next();
		}
        
        for(int i = 0; i < 200;i++){
            for(int j = 0; j < 200;j++){
                System.out.print(" ");
            }
            System.out.println("");
        }
        System.out.println(name_1 +" now its your turn to guess");
        game();
        main_game();
	}
	public static void game()
	{
		 
		 System.out.println("\n"+"Some information about the word"); 
		 guess_length = guess.length();
		 System.out.println("\t"+"The word has "+guess_length+" letters");
		 System.out.println("\t"+"A hint about the word is: "+category);
	     System.out.println(name_2+ " please enter a letter contained in the word");
	     guessed_letter = keyboard.next().charAt(0);
	     str = String.valueOf(guessed_letter);

	}
	
	public static void main_game()
	{
	total_trials_allowed = (int) (guess.length()*2.5);
    array = new char [guess.length()];
	for(int y=0;y<guess.length();y++)
    {
    	array[y]='_';
    }
	int u=0;
	while(u<guess.length())
    {
	if (guess.charAt(u)==guessed_letter)
    	{
    		System.out.println("The letter in position "+(u+1)+" of the secret word has the letter "+guessed_letter);
    		
    		for(int y=0;y<guess.length();y++)
    		{
    			if(guessed_letter==guess.charAt(y))
    			{
    				array[y]=guessed_letter;
    				
    			}
    			System.out.print(array[y]);
    		}
    		System.out.println();
    		System.out.println("Take your guess ->");
    		String guess_input = keyboard.next();
    		
    		if(guess_input.equals(guess))
    		{
    			System.out.println("Congrats, you got the word "+guess+" right");
    			System.out.println("Would you like to play again? Yes for yes, no for no ->");
				String input = keyboard.next();
				
				if(input.equals("no"))
				{
					System.out.println("That was a fun game! Please come again some other time for another round !:)");
					System.exit(0);
				}
				else if(input.equals("yes"))
				{
					System.out.println("Would you like to switch players?");
					String players = keyboard.next();
					if(players.equals("yes"))
					{
						main_game_strings();
					}
					else if (players.equals("no"))
					{
						looped_over();
					}
				}
    		}
    		else if (!guess_input.equals(guess))
    		{
    			System.out.println("Sorry, the word you entered is not the secret word");
    		}
    	}
    
	else
	{
			if(!guess.contains(str))
			{
				total_trials_allowed--;
				System.out.println("No such letter in the secret word exists. "+total_trials_allowed+" trials left");
				System.out.println("Take your guess ->");
	    		String guess_input = keyboard.next();
	    		if(guess_input.equals(guess))
	    		{
	    			System.out.println("Congrats, you got the word "+guess+" right");
	    			System.out.println("Would you like to play again? Yes for yes, no for no ->");
	    			String input = keyboard.next();
	    			if(input.equals("no"))
					{
						System.out.println("That was a fun game! Please come again some other time for another round !:)");
						System.exit(0);
					}
					else if(input.equals("yes"))
					{
						System.out.println("Would you like to switch players?");
						String players = keyboard.next();
						if(players.equals("yes"))
						{
							main_game_strings();
						}
						else if (players.equals("no"))
						{
							looped_over();
						}
					}
	    		}
				if(total_trials_allowed<=0)
				{
					System.out.println("Game over! The word I was thinking of was "+guess);
					System.out.println("Would you like to play again? Yes for yes, no for no ->");
					String input = keyboard.next();
					
					if(input.equals("no"))
					{
						System.out.println("That was a fun game! Please come again some other time for another round !:)");
						System.exit(0);
					}
					else if(input.equals("yes"))
					{
						System.out.println("Would you like to switch players?");
						String players = keyboard.next();
						if(players.equals("yes"))
						{
							main_game_strings();
						}
						else if (players.equals("no"))
						{
							looped_over();
						}
					}
				}
			}
	
			else
			{
				u++;
				continue;
			}
				
	
    }
	u=0;
	game();
	continue;
	
    	
    	}
	}
}

	
	



