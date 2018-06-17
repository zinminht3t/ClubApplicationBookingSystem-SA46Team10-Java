package iss.sa46team12.springclub.initconfigs;

import javax.servlet.http.HttpSession;

public class SecurityConfigurations {

	public static Boolean CheckUserAuth(HttpSession session) {

		if (session.getAttribute("Role") != "member") {
			return false;
		}
		return true;
	}

	public static Boolean CheckAdminAuth(HttpSession session) {

		if (session.getAttribute("Role") != "admin") {
			return false;
		}
		return true;
	}
}
