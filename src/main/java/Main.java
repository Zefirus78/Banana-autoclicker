import hw_4.StringOperations;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        StringOperations s = new StringOperations();
        int res =  s.findSymbolOccurrence("convenience", 'n');
        System.out.println(res);
        int wordPos = s.findWordPosition("Apple", "plant");
        System.out.println(wordPos);
        String w = s.stringReverse("invitation");
        System.out.println(w);
        boolean palindrome = s.isPalindrome("apollo");
        System.out.println(palindrome);
        s.wordGame();


        }
    }