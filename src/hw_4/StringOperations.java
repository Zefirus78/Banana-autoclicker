package hw_4;

import java.util.Random;
import java.util.Scanner;

public class StringOperations {

        public int findSymbolOccurrence(String str, char ch){
            int count = 0;
            for(int i=0; i<str.length(); i++){
                if(str.charAt(i) == ch){
                    count++;
                }
            }
            return count;
        }

        public int findWordPosition(String source, String target){
            int pos = source.indexOf(target);
            return pos;
        }

        public char[] stringReverse(String source){
            char[] chars = source.toCharArray();
            char temp;
            for(int i=0; i<chars.length/2; i++){
                temp = chars[i];
                chars[i] = chars[chars.length-1-i];
                chars[chars.length-1-i] = temp;
            }
            return chars;
        }

        public boolean isPalindrome(String str){
            int left = 0, right = str.length()-1;
            while(left < right){
                if(str.charAt(left) != str.charAt(right)){
                    return false;
                }
                left++;
                right--;
            }
            return true;
        }

        public void wordGame(){
            String[] words = {"apple", "orange", "lemon", "banana",
                    "apricot", "avocado" , "broccoli", "carrot",
                    "cherry", "garlic", "grape", "melon", "leak",
                    "kiwi", "mango", "mushroom", "nut", "olive",
                    "pea", "peanut", "pear", "pepper", "pineapple",
                    "pumpkin", "potato"
            };
            String guess;
            Random random = new Random();
            Scanner sc = new Scanner(System.in);
            String guessedWord = words[random.nextInt(words.length)];
            System.out.println(guessedWord);
            do {
                System.out.println("Guess the word: ");
                guess = sc.nextLine();
                if(guess.equals(guessedWord)){
                    System.out.println("Congratulations! You guessed the word!");
                }
                else {
                    StringBuilder attempt = new StringBuilder();
                    int length = Math.min(guess.length(), guessedWord.length());
                    for(int i=0; i<=15; i++){
                        if (i < length && guess.charAt(i) == guessedWord.charAt(i)){
                            attempt.append(guessedWord.charAt(i));
                        }
                        else {
                            attempt.append('#');
                        }
                    }
                    System.out.println(attempt);
                }
            }
            while(!guessedWord.equals(guess));
        }
    }
