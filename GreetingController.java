package week4;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class GreetingControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void helloReturnsHelloWorld() throws Exception {
		mockMvc.perform(get("/hello"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello World!"));
	}

	@Test
	void helloNameReturnsPersonalizedGreeting() throws Exception {
		mockMvc.perform(get("/hello/Ada"))
				.andExpect(status().isOk())
				.andExpect(content().string("Hello Ada!"));
	}

	@Test
	void addReturnsSum() throws Exception {
		mockMvc.perform(get("/add/7/5"))
				.andExpect(status().isOk())
				.andExpect(content().string("12"));
	}

	@Test
	void multiplyReturnsProduct() throws Exception {
		mockMvc.perform(get("/multiply/7/5"))
				.andExpect(status().isOk())
				.andExpect(content().string("35"));
	}
}
