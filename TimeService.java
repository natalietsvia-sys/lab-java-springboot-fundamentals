package project4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
class TimeService {

	LocalTime getCurrentTime() {
		return LocalTime.now();
	}

	LocalDate getCurrentDate() {
		return LocalDate.now();
	}

	DayOfWeek getCurrentDayOfWeek() {
		return LocalDate.now().getDayOfWeek();
	}
}
