package iss.sa46team12.springclub.repositories.test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.github.springtestdbunit.annotation.DatabaseOperation;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DatabaseTearDown;

import iss.sa46team12.springclub.initconfigs.Initializer;
import iss.sa46team12.springclub.initconfigs.WebAppConfig;
import iss.sa46team12.springclub.models.User;
import iss.sa46team12.springclub.services.SubscriptionService;
import iss.sa46team12.springclub.services.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy({ @ContextConfiguration(classes = Initializer.class),
		@ContextConfiguration(classes = WebAppConfig.class) })
@DatabaseSetup(TestRepository.DATASET)
@DatabaseTearDown(type = DatabaseOperation.DELETE_ALL, value = { TestRepository.DATASET })
@DirtiesContext

public class TestRepository {
	protected static final String DATASET = "DatasetForJUnit.xml";
	
	@Autowired
	private UserService usersvc;
	
	// Test of Dataset in .xml File
	@Test
	public void readOperation() {
	  User e = usersvc.findByEmail("non@est.edu");
	  assertNotNull(e);
	  assertEquals("Leigh Foreman", e.getFullname());
	  
	}
	
	// Due to Constraint (Foreign Key), we expect JpaSystemException - ConstraintViolationException
	@Test(expected = JpaSystemException.class)
	public void createOperation() {
		User e = new User();
		e.setUserId(100);
		e.setFullname("test");
		e.setEmail("test@test");
		e.setNric("123456789");
		e.setDateofbirth(DateOfBirth());
		e.setAddress("test");
		e.setGender("male");
		e.setContactno("123456789");
		e.setRole("member");
		e.setActive(true);
		usersvc.createUser(e);

		User NEW = usersvc.findByEmail("test@test");
		int id = NEW.getUserId();
		assertNotNull(id);
		
		User inserted = usersvc.findUserById(id);
		assertEquals("test", inserted.getFullname());
		assertEquals("123456789", inserted.getNric());
	}
	
	@Test
	public void updateOperation() {
		User e = usersvc.findByEmail("non@est.edu");
		assertNotNull(e);
		e.setAddress("testupdatedataset");
		usersvc.editUser(e);
		
		User NEW = usersvc.findByEmail("non@est.edu");
		assertEquals("testupdatedataset", NEW.getAddress());
	}
	
	// No real delete operation; We are using soft delete - tracking "active - true / false"
	@Test
	public void deleteOperation() {
		User e = usersvc.findByEmail("non@est.edu");
		e.setActive(false);
		usersvc.editUser(e);
		
		User NEW = usersvc.findByEmail("non@est.edu");
		assertEquals(false, NEW.isActive());
	}
	
	public Date DateOfBirth() {
		int day = Integer.parseInt("1");
		int month = Integer.parseInt("1");
		int year = Integer.parseInt("1990");

		Calendar cal = new GregorianCalendar(year, month - 1, day);
		Date date = cal.getTime();
		
		return date;
	}

}
