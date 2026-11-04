package com.example.hclTechTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class HclTechTestApplicationTests {

	private MockMvc mockMvc;

	@BeforeEach
	void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(new ShopController()).build();
	}

	@Test
	void productsAndUsersCanBeBrowsed() throws Exception {
		mockMvc.perform(get("/app/products"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value("Notebook"));
		mockMvc.perform(get("/app/users"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].name").value("Alex Morgan"));
	}

	@Test
	void productsCanBeAddedToAndRemovedFromCart() throws Exception {
		mockMvc.perform(post("/app/users/1/cart/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$[0].quantity").value(1));
		mockMvc.perform(delete("/app/users/1/cart/1"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$").isEmpty());
	}

}
