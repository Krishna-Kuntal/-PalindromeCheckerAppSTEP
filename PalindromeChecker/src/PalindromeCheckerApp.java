import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Stack;

// 1️⃣ Strategy Interface
interface PalindromeStrategy {
    boolean check(String input);
}

// 2️⃣ Concrete Strategy 1: Stack Implementation
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
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
}

// 3️⃣ Concrete Strategy 2: Deque Implementation
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String input) {

        String cleaned = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
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
}

// 4️⃣ Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    // Inject strategy at runtime
    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String input) {
        return strategy.check(input);
    }
}

// 5️⃣ Main Application
public class PalindromeCheckerApp {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        PalindromeContext context = new PalindromeContext();

        System.out.println("=================================");
        System.out.println(" Strategy Pattern Palindrome ");
        System.out.println("=================================");

        System.out.println("Choose Algorithm:");
        System.out.println("1. Stack Strategy");
        System.out.println("2. Deque Strategy");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        // Runtime strategy selection
        if (choice == 1) {
            context.setStrategy(new StackStrategy());
        } else if (choice == 2) {
            context.setStrategy(new DequeStrategy());
        } else {
            System.out.println("Invalid choice.");
            scanner.close();
            return;
        }

        boolean result = context.executeStrategy(input);

        if (result) {
            System.out.println("Palindrome (Strategy Applied)");
        } else {
            System.out.println("Not a Palindrome");
        }

        scanner.close();
    }
}