package iss.sa46team12.springclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	// @Query("SELECT u FROM Users u WHERE u.email=:email AND u.password=:pwd")
	// User findUserbyEmailPwd(@Param("email") String user, @Param("pwd") String
	// pwd);

	// @Query("SELECT DISTINCT e2.name FROM User u, Employee e1, Employee e2 WHERE
	// u.employeeId = e1.employeeId AND e1.managerId = e2.employeeId AND
	// u.userId=:uid")
	// ArrayList<String> findManagerNameByUID(@Param("uid") String uid);

	@Query("SELECT u FROM User u WHERE u.email=:un AND u.password=:pwd")
	User findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);

	@Query("SELECT u FROM User u WHERE u.email=:un")
	User findUserByName(@Param("un") String uname);

	@Query("SELECT Count(u) from User u where gender = 'male'")
	int countMaleUsers();

	@Query("SELECT Count(u) from User u where gender = 'female'")
	int countFemaleUsers();

	// @Query("SELECT s FROM Subscription s where s.expirydate=:date")
	// ArrayList <User> findUserByDate(@Param("date") Date date);
}
