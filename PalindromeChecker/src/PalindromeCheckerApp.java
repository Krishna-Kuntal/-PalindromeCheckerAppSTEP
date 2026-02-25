import java.util.Scanner;

public class PalindromeCheckerApp {

    public static void displayWelcome() {
        System.out.println("=================================");
        System.out.println(" PALINDROME CHECKER APPLICATION ");
        System.out.println(" Version 1.0 ");
        System.out.println("=================================");
    }

    public static void hardcodedPalindrome() {
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }

    // UC3: User Input
    public static void userInputPalindrome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a word: ");
        String input = scanner.nextLine();
        String reversed = new StringBuilder(input).reverse().toString();

        if (input.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }

    public static void main(String[] args) {
        displayWelcome();
        hardcodedPalindrome();
        userInputPalindrome();
    }
}