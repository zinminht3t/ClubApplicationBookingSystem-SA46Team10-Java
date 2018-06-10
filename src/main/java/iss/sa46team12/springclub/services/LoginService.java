package iss.sa46team12.springclub.services;

import org.springframework.stereotype.Service;

@Service
public class LoginService {
	
	public boolean validateuser(String user, String password) {
		// if method to see if user role is active
		return user.equalsIgnoreCase("frm db") && password.equals("frm db too");
	}
	
	public String checkuserrole(int id) {
//		if("some method to check ID .admin") {
//			return "member";
//		}
//		else
		return "admin";
	}
	
}
