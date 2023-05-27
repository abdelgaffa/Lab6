import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Task05Revised {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("white", "red", "dad", "yellow", "12321");
        System.out.println("The amount of words with 5 letters is = " + countWordsWithLength(words, 5));

        List<String> palindromes = words.stream().filter(Task05Revised::isPalindrome).collect(Collectors.toList());
        for (String palindrome : palindromes) {
            System.out.println(palindrome + " = true");
        }
        System.out.println("-------------------");
        System.out.println("The amount of palindromes = " + palindromes.size());

        List<String> wordsStartingWithW = words.stream().filter(s -> s.startsWith("w")).collect(Collectors.toList());
        System.out.println("Words start with 'w' :");
        wordsStartingWithW.forEach(System.out::println);
    }

    public static int countWordsWithLength(List<String> words, int length) {
        return (int) words.stream().filter(s -> s.length() == length).count();
    }

    public static boolean isPalindrome(String s) {
        int n = s.length();
        for (int i = 0; i < n/2; i++)
            if (s.charAt(i) != s.charAt(n - i - 1)) return false;
        return true;
    }
}
