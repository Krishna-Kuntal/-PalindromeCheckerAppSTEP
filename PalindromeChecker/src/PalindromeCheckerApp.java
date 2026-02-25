import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class PalindromeCheckerApp {
    // Method to check palindrome after normalization
    public static boolean isPalindrome(String input) {

        // Step 1: Normalize string
        String cleaned = input
                .replaceAll("[^a-zA-Z0-9]", "")   // remove spaces & special chars
                .toLowerCase();                  // convert to lowercase

        // Step 2: Apply two-pointer logic
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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" Case-Insensitive Palindrome ");
        System.out.println("=================================");

        System.out.print("Enter a sentence: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Palindrome (Ignoring Case & Spaces)");
        } else {
            System.out.println("Not a Palindrome");
        }

        scanner.close();
    }
}