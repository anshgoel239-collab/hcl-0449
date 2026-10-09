import java.util.LinkedList;

public class Linked {
	public static void main(String[] args) {
		LinkedList<String> fruits = new LinkedList<>();

		fruits.add("Apple");
		fruits.add("Banana");
		fruits.addFirst("Mango");
		fruits.addLast("Orange");
		fruits.add(2, "Grapes");
		System.out.println("After adding: " + fruits);

		System.out.println("First: " + fruits.getFirst());
		System.out.println("Last: " + fruits.getLast());
		System.out.println("Element at index 2: " + fruits.get(2));

		fruits.set(1, "Pear");
		System.out.println("Contains Banana? " + fruits.contains("Banana"));
		System.out.println("Index of Orange: " + fruits.indexOf("Orange"));
		System.out.println("After updating: " + fruits);

		fruits.remove("Grapes");
		fruits.removeFirst();
		fruits.removeLast();
		System.out.println("After removing: " + fruits);

		fruits.offer("Kiwi");
		fruits.offerFirst("Lemon");
		System.out.println("Queue-style additions: " + fruits);
		System.out.println("Peek at first: " + fruits.peek());
		System.out.println("Poll first: " + fruits.poll());
		System.out.println("After poll: " + fruits);

		System.out.print("Items: ");
		for (String fruit : fruits) {
			System.out.print(fruit + " ");
		}
		System.out.println();

		System.out.println("Size: " + fruits.size());
		System.out.println("Is empty? " + fruits.isEmpty());
		fruits.clear();
		System.out.println("After clear, is empty? " + fruits.isEmpty());
	}
}
