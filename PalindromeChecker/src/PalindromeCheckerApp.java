public class PalindromeCheckerApp {
    public static void displayWelcome() {
        System.out.println("=================================");
        System.out.println(" PALINDROME CHECKER APPLICATION ");
        System.out.println(" Version 1.0 ");
        System.out.println("=================================");
    }

    // UC2: Hardcoded Palindrome
    public static void hardcodedPalindrome() {
        String word = "madam";
        String reversed = new StringBuilder(word).reverse().toString();

        if (word.equals(reversed)) {
            System.out.println(word + " is a Palindrome");
        } else {
            System.out.println(word + " is NOT a Palindrome");
        }
    }

    public static void main(String[] args) {
        displayWelcome();
        hardcodedPalindrome();
    }
}
