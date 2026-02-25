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

        if (input.equalsIgnoreCase(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
    public static void advancedPalindrome() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversed = new StringBuilder(cleaned).reverse().toString();

        if (cleaned.equals(reversed)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not a Palindrome");
        }
    }
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        displayWelcome();

        while (true) {
            System.out.println("\n1. Hardcoded");
            System.out.println("2. User Input");
            System.out.println("3. Advanced");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    hardcodedPalindrome();
                    break;
                case 2:
                    userInputPalindrome();
                    break;
                case 3:
                    advancedPalindrome();
                    break;
                case 4:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}