package iss.sa46team12.springclub.services;

public interface LoginService {
	public String showloginpg();
	public String handleloginrequest();
	public boolean validateuser(String user, String password);
	public String checkuserrole();	

}
