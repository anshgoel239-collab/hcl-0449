import java.util.PriorityQueue;
import java.util.Scanner;

public class priority{
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 5 elements:");

        for (int i = 0; i < 5; i++) {
            pq.add(sc.nextInt());
        }

        System.out.println("Priority Queue: " + pq);

        System.out.println("Highest Priority Element: " + pq.peek());

        System.out.println("Removed Element: " + pq.poll());

        System.out.println("Priority Queue after removal: " + pq);

        System.out.println("Queue Size: " + pq.size());

        System.out.println("Is Queue Empty? " + pq.isEmpty());

        sc.close();
    }
}