package iss.sa46team12.springclub.components;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.repositories.UserRepository;
import iss.sa46team12.springclub.services.UserService;

@Component
public class SchedulerComponent {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserService userService;
	
	//Cron expression : second, minute, hour, day of month, month, day(s) of week
	@Scheduled(cron = "0 0 0 * * *")
	public void updateAccountExpiry() {
		System.out.println("Time now is 11.34am");
	}
	
//	private void process() {
//
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd");  
//		   LocalDateTime now = LocalDateTime.now();
//			ArrayList <User> alluser = userService.getAllUserByDate(Date.valueOf(dtf.format(now)));
//		for(User user : alluser){
////			user.setActive(false);
//			System.out.println(user);
//		}
//	}
}
