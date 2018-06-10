package iss.sa46team12.springclub.services;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation;

@Service
public class LoginServiceImpl implements LoginService {
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

	@Override
	public String showloginpg() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String handleloginrequest() {
		// TODO Auto-generated method stub
		@RequestParam
		return null;
	}

	@Override
	public String checkuserrole() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
