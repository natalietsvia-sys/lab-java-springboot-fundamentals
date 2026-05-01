package project4;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Service;

@Service
class WeatherService {

	private static final List<String> CONDITIONS = List.of("Sunny", "Rainy", "Cloudy", "Windy");

	int getCurrentTemperature() {
		return ThreadLocalRandom.current().nextInt(-10, 41);
	}

	String getWeatherCondition() {
		int conditionIndex = ThreadLocalRandom.current().nextInt(CONDITIONS.size());
		return CONDITIONS.get(conditionIndex);
	}

	int getWindSpeed() {
		return ThreadLocalRandom.current().nextInt(0, 101);
	}
}
