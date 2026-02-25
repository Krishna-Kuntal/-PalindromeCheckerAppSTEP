import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {

    public static void displayWelcome() {
        System.out.println("=================================");
        System.out.println(" PALINDROME CHECKER APPLICATION ");
        System.out.println(" Version 1.0 ");
        System.out.println("=================================");
    }
    // UC7: Deque Based Optimized Palindrome
    public static void dequePalindromeChecker() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Remove spaces & convert to lowercase
        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        Deque<Character> deque = new ArrayDeque<>();

        // Insert characters into deque
        for (char ch : cleaned.toCharArray()) {
            deque.addLast(ch);
        }

        boolean isPalindrome = true;

        // Compare front and rear
        while (deque.size() > 1) {
            char front = deque.removeFirst();
            char rear = deque.removeLast();

            if (front != rear) {
                isPalindrome = false;
                break;
            }
        }

        if (isPalindrome) {
            System.out.println("Palindrome (Using Deque)");
        } else {
            System.out.println("Not a Palindrome");
        }
    }

    public static void main(String[] args) {

        displayWelcome();
        dequePalindromeChecker();
    }

}