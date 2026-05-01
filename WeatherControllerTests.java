package project4;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(WeatherController.class)
class WeatherControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@MockitoBean
	private WeatherService weatherService;

	@Test
	void temperatureReturnsCurrentTemperature() throws Exception {
		when(weatherService.getCurrentTemperature()).thenReturn(22);

		mockMvc.perform(get("/weather/temperature"))
				.andExpect(status().isOk())
				.andExpect(content().string("22"));
	}

	@Test
	void conditionReturnsCurrentCondition() throws Exception {
		when(weatherService.getWeatherCondition()).thenReturn("Sunny");

		mockMvc.perform(get("/weather/condition"))
				.andExpect(status().isOk())
				.andExpect(content().string("Sunny"));
	}

	@Test
	void windReturnsCurrentWindSpeed() throws Exception {
		when(weatherService.getWindSpeed()).thenReturn(18);

		mockMvc.perform(get("/weather/wind"))
				.andExpect(status().isOk())
				.andExpect(content().string("18"));
	}

	@Test
	void allReturnsCompleteWeatherInformation() throws Exception {
		when(weatherService.getCurrentTemperature()).thenReturn(9);
		when(weatherService.getWeatherCondition()).thenReturn("Cloudy");
		when(weatherService.getWindSpeed()).thenReturn(41);

		mockMvc.perform(get("/weather/all"))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.temperature").value(9))
				.andExpect(jsonPath("$.condition").value("Cloudy"))
				.andExpect(jsonPath("$.windSpeed").value(41));
	}
}
