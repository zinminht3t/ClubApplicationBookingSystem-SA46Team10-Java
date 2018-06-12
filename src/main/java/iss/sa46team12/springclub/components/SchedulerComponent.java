package iss.sa46team12.springclub.components;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.sql.Date;

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
	
	//Cron expression : second, minute, hour, day of month, month, day(s) of week
	@Scheduled(cron = "0 0 0 * * *")
	public void updateAccountExpiry() {
		process();
	}
	
	private void process() {
		
//		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date dateWithoutTime = new Date();
		
//		try {
//			dateWithoutTime = sdf.parse(sdf.format(new Date()));
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(sdf.format(dateWithoutTime));
//		
		 LocalDate localDate = LocalDate.now();
//        System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));
		
//		String timeStamp = new SimpleDateFormat("yyyyMMdd").format(Calendar.getInstance());
//		   LocalDateTime now = LocalDateTime.now();
//
//	        ArrayList<Subscription> alls = subscriptionService.findall();
//	        for(Subscription sub : alls) {
//
//	        	
//		        Calendar dateWithoutTimec = Calendar.getInstance();
//		        dateWithoutTimec.setTime(dateWithoutTime);
//		        SimpleDateFormat aaaa = new SimpleDateFormat("dd/MM/yyyy");
//		        aaaa.format(dateWithoutTimec.getTime());
//
//		        Calendar dateWithoutTimeca = Calendar.getInstance();
//		        dateWithoutTimeca.setTime(sub.getExpirydate());
//		        SimpleDateFormat aaaaa = new SimpleDateFormat("dd/MM/yyyy");
//		        aaaaa.format(dateWithoutTimeca.getTime());
//		        
//	        	System.out.println(aaaa);
//	        	System.out.println(aaaaa);
//		        
//		        if(aaaa == aaaaa) {
//
//					sub.setActive(false);
//					int id = sub.getUserid();
//					User u = userService.findUserById(id);
//					u.setActive(false);
//					System.out.println(sub.getSubid());
//					userService.editUser(u);
//					
//					System.out.println("WHY CANNOT");
//					
//		        }
//	        }
	        
	       // Calendar c = new Calendar("dd/MM/yyyy");
	        //c.setTime(date);
	        

			ArrayList <Subscription> allsub = subscriptionService.findUserByDate(Date.valueOf(localDate));
//			System.out.println(Date.valueOf(localDate).toString());
		for(Subscription sub : allsub){
	        Calendar dateWithoutTimec = Calendar.getInstance();
	        dateWithoutTimec.setTime(Date.valueOf(localDate));
	        SimpleDateFormat aaaa = new SimpleDateFormat("dd/MM/yyyy");
	        aaaa.format(dateWithoutTimec.getTime());

	        Calendar dateWithoutTimeca = Calendar.getInstance();
	        dateWithoutTimeca.setTime(sub.getExpirydate());
	        SimpleDateFormat aaaaa = new SimpleDateFormat("dd/MM/yyyy");
	        aaaaa.format(dateWithoutTimeca.getTime());
			System.out.println(aaaa);
			System.out.println(aaaaa);
			if(aaaa.equals(aaaaa)) {
//				sub.setActive(false);
//				int id = sub.getUserid();
//				User u = userService.findUserById(id);
//				u.setActive(false);
				
				sub.setActive(false);
				int id = sub.getUserid();
				User u = userService.findUserById(id);
				u.setActive(false);
				System.out.println(sub.getSubid());
				userService.editUser(u);
				
				System.out.println("WHY CANNOT");
			}		
			System.out.println(sub.getSubid());
		}
//		LocalDateTime now = LocalDateTime.now();
//		System.out.println(now.toString());

	}
}
