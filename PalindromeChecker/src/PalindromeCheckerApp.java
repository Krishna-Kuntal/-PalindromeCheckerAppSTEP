import java.util.*;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;

public class PalindromeCheckerApp {
    // Normalize input
    public static String cleanString(String input) {
        return input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // 1️⃣ Stack Method
    public static boolean stackPalindrome(String input) {
        String cleaned = cleanString(input);
        Stack<Character> stack = new Stack<>();

        for (char ch : cleaned.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : cleaned.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }

    // 2️⃣ Deque Method
    public static boolean dequePalindrome(String input) {
        String cleaned = cleanString(input);
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : cleaned.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (!deque.removeFirst().equals(deque.removeLast())) {
                return false;
            }
        }

        return true;
    }

    // 3️⃣ Two Pointer Method (Most Efficient)
    public static boolean twoPointerPalindrome(String input) {
        String cleaned = cleanString(input);
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
        System.out.println(" Palindrome Performance Analyzer ");
        System.out.println("=================================");

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // STACK PERFORMANCE
        long startStack = System.nanoTime();
        boolean stackResult = stackPalindrome(input);
        long endStack = System.nanoTime();
        long stackTime = endStack - startStack;

        // DEQUE PERFORMANCE
        long startDeque = System.nanoTime();
        boolean dequeResult = dequePalindrome(input);
        long endDeque = System.nanoTime();
        long dequeTime = endDeque - startDeque;

        // TWO POINTER PERFORMANCE
        long startTwo = System.nanoTime();
        boolean twoResult = twoPointerPalindrome(input);
        long endTwo = System.nanoTime();
        long twoTime = endTwo - startTwo;

        System.out.println("\nRESULTS:");
        System.out.println("---------------------------------");
        System.out.println("Stack Method      : " + stackResult + " | Time: " + stackTime + " ns");
        System.out.println("Deque Method      : " + dequeResult + " | Time: " + dequeTime + " ns");
        System.out.println("Two Pointer Method: " + twoResult + " | Time: " + twoTime + " ns");

        scanner.close();
    }
}