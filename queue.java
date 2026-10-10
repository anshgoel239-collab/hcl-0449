import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class queue {
    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 5 elements:");

        for (int i = 0; i < 5; i++) {
            q.add(sc.nextInt());
        }

        System.out.println("Queue: " + q);

        System.out.println("Front element: " + q.peek());

        System.out.println("Removed element: " + q.poll());

        System.out.println("Queue after removal: " + q);

        System.out.println("Queue size: " + q.size());

        System.out.println("Is queue empty? " + q.isEmpty());

        sc.close();
    }
}