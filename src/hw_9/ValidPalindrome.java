package hw_9;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String cleaned = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        int left = 0;
        int right = cleaned.length() - 1;
        while (left < right) {
            if (cleaned.charAt(left) != cleaned.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
//    public boolean isPalindrome(String s) {
//        String formattedInput = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
//        return IntStream.range(0, formattedInput.length() / 2)
//                .allMatch(i -> formattedInput.charAt(i) == formattedInput.charAt(formattedInput.length() - 1 - i));
//    }
}
