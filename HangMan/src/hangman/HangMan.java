/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman;

import java.util.*;


public class HangMan {
 public static void main (String[]args){
        Scanner Keyboard = new Scanner (System.in);
        Random rand =new Random();
        System.out.println("H A N G M A N");
        String word = "cat";
        System.out.println(word);
        List <Character> playerGuesses =new ArrayList <>();
        int wrongCount = 0 ;
        //sameLetter = 0 ;
        while(true){

            printHangMan(wrongCount);
            if (wrongCount >=3 ){
                System.out.println("You lose!");
                break;
            }
            printWordState(word, playerGuesses);

            if(!getPlayerGuess(Keyboard, playerGuesses, word)){
                wrongCount++;
            }
            if (printWordState(word, playerGuesses)){
                System.out.println("You win!");
                break;
            }
            System.out.println("Please enter your guess for the word: ");
            if (Keyboard.nextLine().equals(word)){
                System.out.println("You win!");
                break;
            }else{
                System.out.println("");
            }


        }

    }

    private static void printHangMan(int wrongCount) {
        System.out.println("+---+");
        System.out.println("   |");
        if(wrongCount >= 1){
            System.out.println("O");
        } if(wrongCount >= 2){
            System.out.println("|");
        } System.out.println("   |");
        if(wrongCount >= 3){
            System.out.println("|");
        }
        System.out.println("   |");
        if(wrongCount >= 4){
            System.out.print("|");
        }
        System.out.println("   |");

        System.out.println("  ===");
        System.out.println("  ");
    }

    private static boolean  getPlayerGuess(Scanner Keyboard, List<Character> playerGuesses, String word) {
        System.out.println("Guess a letter.");
        String letterGuess = Keyboard.nextLine();
        playerGuesses.add(letterGuess.charAt(0));
        return word.contains(letterGuess);
    }

    private static boolean printWordState(String word, List<Character> playerGuesses) {
        System.out.println("Missed letters:");
        int correctCount =0 ;
        for (int i = 0; i < word.length(); i++) {
            if (playerGuesses.contains(word.charAt(i))){
                System.out.print(word.charAt(i));
                correctCount++;
            }else{
                System.out.print("-");
            }
        }
        System.out.println();
        return (word.length() == correctCount);

    }
    
}
