package iss.sa46team12.springclub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import iss.sa46team12.springclub.models.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    
//	@Query("SELECT u FROM Users u WHERE u.email=:email AND u.password=:pwd")
//	User findUserbyEmailPwd(@Param("email") String user, @Param("pwd") String pwd);
}
