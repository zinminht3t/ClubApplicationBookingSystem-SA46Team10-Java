package iss.sa46team12.springclub.repositories;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
//	@Query("SELECT u FROM Users u WHERE u.email=:email AND u.password=:pwd")
//	User findUserbyEmailPwd(@Param("email") String user, @Param("pwd") String pwd);
	
//	@Query("SELECT DISTINCT e2.name FROM User u, Employee e1, Employee e2 WHERE u.employeeId = e1.employeeId AND e1.managerId = e2.employeeId AND u.userId=:uid")
//	ArrayList<String> findManagerNameByUID(@Param("uid") String uid);
    
	@Query("SELECT u FROM User u WHERE u.email=:un AND u.password=:pwd")
	User findUserByNamePwd(@Param("un") String uname, @Param("pwd") String pwd);
}
