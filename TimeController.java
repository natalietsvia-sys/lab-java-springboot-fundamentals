package project4;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class TimeController {

	private final TimeService timeService;

	TimeController(TimeService timeService) {
		this.timeService = timeService;
	}

	@GetMapping("/time")
	LocalTime getTime() {
		return timeService.getCurrentTime();
	}

	@GetMapping("/date")
	LocalDate getDate() {
		return timeService.getCurrentDate();
	}

	@GetMapping("/day")
	DayOfWeek getDayOfWeek() {
		return timeService.getCurrentDayOfWeek();
	}

	@GetMapping("/all")
	TimeInformation getAllTimeInformation() {
		return new TimeInformation(
				timeService.getCurrentTime(),
				timeService.getCurrentDate(),
				timeService.getCurrentDayOfWeek());
	}

	record TimeInformation(LocalTime time, LocalDate date, DayOfWeek dayOfWeek) {
	}
}
