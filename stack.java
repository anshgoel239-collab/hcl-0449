import java.util.Stack;

public class stack {
	public static void main(String[] args) {
		Stack<String> books = new Stack<>();

		books.push("Math");
		books.push("Science");
		books.push("History");
		System.out.println("Stack after push: " + books);

		System.out.println("Top item: " + books.peek());
		System.out.println("Position of Science from the top: " + books.search("Science"));
		System.out.println("Contains Math: " + books.contains("Math"));
		System.out.println("Number of items: " + books.size());

		System.out.println("Removed item: " + books.pop());
		System.out.println("Stack after pop: " + books);

		System.out.print("Items from bottom to top: ");
		for (String book : books) {
			System.out.print(book + " ");
		}
		System.out.println();

		System.out.println("Is the stack empty: " + books.empty());
		books.clear();
		System.out.println("Stack after clear: " + books);
		System.out.println("Is the stack empty: " + books.empty());
	}
}
