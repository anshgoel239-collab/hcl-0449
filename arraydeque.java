import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class arraydeque {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 5 elements:");

        for (int i = 0; i < 5; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("Stack: " + stack);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped element: " + stack.pop());

        System.out.println("Stack after pop: " + stack);

        System.out.println("Stack size: " + stack.size());

        System.out.println("Is stack empty? " + stack.isEmpty());

        sc.close();
    }
}