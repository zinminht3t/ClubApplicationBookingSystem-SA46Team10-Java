package iss.sa46team12.springclub.components;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import iss.sa46team12.springclub.models.Subscription;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.repositories.SubscriptionRepository;
import iss.sa46team12.springclub.repositories.UserRepository;
import iss.sa46team12.springclub.services.SubscriptionService;
import iss.sa46team12.springclub.services.UserService;

@Component
public class SchedulerComponent {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@Autowired
	SubscriptionRepository subscriptionRepository;

	@Autowired
	SubscriptionService subscriptionService;

	// Cron expression : second, minute, hour, day of month, month, day(s) of week
	// eg. 22:00 hrs = "0 0 22 * * *", 1.30am = "0 30 1 * * *"
	@Scheduled(cron = "0 0 0 * * *")
	public void updateAccountExpiry() {
		process();
	}

	private void process() {

		LocalDate localDate = LocalDate.now();

		ArrayList<Subscription> allsub = subscriptionService.findUserByDate(Date.valueOf(localDate));
		for (Subscription sub : allsub) {
			Calendar dateWithoutTime1 = Calendar.getInstance();
			dateWithoutTime1.setTime(Date.valueOf(localDate));
			SimpleDateFormat date1 = new SimpleDateFormat("dd/MM/yyyy");
			date1.format(dateWithoutTime1.getTime());

			Calendar dateWithoutTime2 = Calendar.getInstance();
			dateWithoutTime2.setTime(sub.getExpirydate());
			SimpleDateFormat date2 = new SimpleDateFormat("dd/MM/yyyy");
			date2.format(dateWithoutTime2.getTime());

			if (date1.equals(date2)) {
				sub.setActive(false);
				int id = sub.getUserid();
				User u = userService.findUserById(id);
				u.setActive(false);
				userService.editUser(u);
				subscriptionService.editSub(sub);

			}
		}

	}
}