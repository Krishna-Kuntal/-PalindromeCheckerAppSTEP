import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;

// Service Class
class PalindromeChecker {

    // Public method exposed to client
    public boolean checkPalindrome(String input) {

        // Normalize string
        String cleaned = input
                .replaceAll("[^a-zA-Z0-9]", "")
                .toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }

        // Compare original with stack pop
        for (char ch : cleaned.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}
public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" OOPS Palindrome Checker ");
        System.out.println("=================================");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Create object of service class
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Palindrome (Using OOPS Service)");
        } else {
            System.out.println("Not a Palindrome");
        }

        scanner.close();
    }
}