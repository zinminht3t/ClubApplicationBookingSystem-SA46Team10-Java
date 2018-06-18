
package iss.sa46team12.springclub.repositories.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import iss.sa46team12.springclub.exceptions.SubscriptionNotFound;
import iss.sa46team12.springclub.initconfigs.Initializer;
import iss.sa46team12.springclub.initconfigs.WebAppConfig;
import iss.sa46team12.springclub.models.Bookings;
import iss.sa46team12.springclub.models.Facility;
import iss.sa46team12.springclub.models.Maintenance;
import iss.sa46team12.springclub.models.Subscription;
import iss.sa46team12.springclub.models.Timeslots;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.BookingsService;
import iss.sa46team12.springclub.services.FacilityService;
import iss.sa46team12.springclub.services.MaintenanceService;
import iss.sa46team12.springclub.services.SubscriptionService;
import iss.sa46team12.springclub.services.TimeslotService;
import iss.sa46team12.springclub.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(classes = Initializer.class),
		@ContextConfiguration(classes = WebAppConfig.class) })
@DatabaseSetup(TestRepository.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { TestRepository.DATASET })
@DirtiesContext
@Transactional
@Rollback(true)
public class TestRepository {
	protected static final String DATASET = "classpath:DatasetForJUnit.xml";
	// Note: There is no Delete operation as we do not delete anything from the database
	// We are using soft-delete i.e. Setting Active to False for most of the tables
	// In this JUnit Test, we test the critical service classes and the models (CRU)
	@Autowired
	private BookingsService bksvc;
	@Autowired
	private FacilityService facsvc;
	@Autowired
	private MaintenanceService maintsvc;
	@Autowired
	private SubscriptionService subsvc;
	@Autowired
	private TimeslotService timeslotsvc;
	@Autowired
	private UserService usersvc;

	// Test of Dataset in .xml File
	@Test
	public void UserServiceReadOperation() {
		User e = usersvc.findByEmail("non@est.edu");
		assertNotNull(e);
		assertEquals("Leigh Foreman", e.getFullname());
	}

	// Due to Constraint (Foreign Key), we expect JpaSystemException -
	// ConstraintViolationException
	@Test(expected = JpaSystemException.class)
	public void UserServiceCreateOperation() {
		User e = new User();
		e.setUserId(100);
		e.setFullname("test");
		e.setEmail("test@test");
		e.setNric("123456789");
		e.setDateofbirth(date());
		e.setAddress("test");
		e.setGender("male");
		e.setContactno("123456789");
		e.setRole("member");
		e.setActive(true);
		User u = usersvc.createUser(e);
		assertNotNull(u);

		User inserted = usersvc.findUserById(u.getUserId());
		assertEquals("test", inserted.getFullname());
		assertEquals("123456789", inserted.getNric());
	}

	@Test
	public void UserServiceUpdateOperation() {
		User e = usersvc.findByEmail("non@est.edu");
		assertNotNull(e);
		e.setAddress("testedataset");
		usersvc.editUser(e);

		User NEW = usersvc.findByEmail("non@est.edu");
		assertEquals("testedataset", NEW.getAddress());
	}

	// No real delete operation; We are using soft delete - tracking "active - true / false"
	@Test
	public void UserServiceDeleteOperation() {
		User e = usersvc.findByEmail("non@est.edu");
		e.setActive(false);
		usersvc.editUser(e);

		User NEW = usersvc.findByEmail("non@est.edu");
		assertEquals(false, NEW.isActive());
	}

	@Test
	public void SubscriptionServiceReadOperation() throws SubscriptionNotFound {
		Subscription s = subsvc.findActiveSubscription(1);
		assertNotNull(s);
		assertEquals(true, s.getActive());
	}
	
	@Test
	public void SubscriptionServiceCreateOperation() {
		Subscription sub = new Subscription();
		sub.setUserid(1);
		sub.setActive(true);
		sub.setExpirydate(date());
		sub.setJoindate(date());
		sub.setPackageid(1);
		Subscription s = subsvc.createSubscription(sub);
		assertNotNull(s);
		assertEquals(1, s.getPackageid());
		assertEquals(1, s.getUserid());
	}
	
	@Test
	public void SubscriptionServiceUpdateOperation() throws SubscriptionNotFound {
		Subscription s = subsvc.findActiveSubscription(1);
		s.setExpirydate(date());
		s.setActive(false);
		Subscription sub = subsvc.editSub(s);
		assertNotNull(sub);
		assertEquals(date(), sub.getExpirydate());
		assertEquals(false, sub.getActive());
	}

	@Test
	public void BookingsReadOperation() {
		Bookings bk = bksvc.findBooking(1);
		assertNotNull(bk);
	}
	
	@Test
	public void BookingsCreateOperation() {
		Bookings booking = new Bookings();
		booking.setTransactiontime(LocalDateTime.now());
		User user = usersvc.findUserById(1);
		booking.setUser(user);
		booking.setTotal(2);
		booking.setStatus("CONFIRMED");
		booking.setBookingid(1);
		bksvc.createBooking(booking);
		
		Bookings bk = bksvc.findBooking(1);
		assertNotNull(bk);
		assertEquals(2, bk.getTotal());
		assertEquals(user.getUserId(), bk.getUser().getUserId());
	}

	@Test
	public void FacilityReadOperation() {
		Facility f = facsvc.findFacilityById(1);
		assertNotNull(f);
	}

	@Test
	public void MaintenanceReadOperation() {
		Maintenance m = maintsvc.findMaintenance(1);
		assertNotNull(m);
	}

	@Test
	public void TimeslotReadOperation() {
		Timeslots ts = timeslotsvc.findTimeslotByName("09:00 - 10:00");
		assertNotNull(ts);
	}

	public Date date() {
		int day = Integer.parseInt("1");
		int month = Integer.parseInt("1");
		int year = Integer.parseInt("1990");

		Calendar cal = new GregorianCalendar(year, month - 1, day);
		Date date = cal.getTime();
		return date;
	}
}
