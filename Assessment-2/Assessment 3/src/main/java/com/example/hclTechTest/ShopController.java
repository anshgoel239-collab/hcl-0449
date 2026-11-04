package com.example.hclTechTest;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/app")
public class ShopController {

	private final List<Product> products = List.of(
			new Product(1, "Notebook", "A ruled notebook", 4.99),
			new Product(2, "Pen", "A blue ink pen", 1.49),
			new Product(3, "Backpack", "A simple everyday backpack", 29.99));

	private final List<ShopUser> users = List.of(
			new ShopUser(1, "Alex Morgan", "alex@example.com"),
			new ShopUser(2, "Jordan Lee", "jordan@example.com"));

	private final Map<Long, Map<Long, Integer>> carts = new ConcurrentHashMap<>();

	@GetMapping("/products")
	public List<Product> getProducts() {
		return products;
	}

	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable long productId) {
		return findProduct(productId);
	}

	@GetMapping("/users")
	public List<ShopUser> getUsers() {
		return users;
	}

	@GetMapping("/users/{userId}")
	public ShopUser getUser(@PathVariable long userId) {
		return findUser(userId);
	}

	@GetMapping("/users/{userId}/cart")
	public List<CartItem> getCart(@PathVariable long userId) {
		findUser(userId);
		return carts.getOrDefault(userId, Map.of()).entrySet().stream()
				.map(entry -> new CartItem(findProduct(entry.getKey()), entry.getValue()))
				.toList();
	}

	@PostMapping("/users/{userId}/cart/{productId}")
	public List<CartItem> addToCart(@PathVariable long userId, @PathVariable long productId) {
		findUser(userId);
		findProduct(productId);
		carts.computeIfAbsent(userId, ignored -> new ConcurrentHashMap<>())
				.merge(productId, 1, Integer::sum);
		return getCart(userId);
	}

	@DeleteMapping("/users/{userId}/cart/{productId}")
	public List<CartItem> removeFromCart(@PathVariable long userId, @PathVariable long productId) {
		findUser(userId);
		findProduct(productId);
		Map<Long, Integer> cart = carts.get(userId);
		if (cart != null) {
			cart.remove(productId);
		}
		return getCart(userId);
	}

	private Product findProduct(long productId) {
		return products.stream()
				.filter(product -> product.id() == productId)
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found"));
	}

	private ShopUser findUser(long userId) {
		return users.stream()
				.filter(user -> user.id() == userId)
				.findFirst()
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
	}
}
