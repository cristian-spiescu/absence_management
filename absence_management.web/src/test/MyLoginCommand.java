package test;

import java.security.Principal;
import java.util.List;

import javax.servlet.ServletConfig;

import flex.messaging.security.LoginCommand;
import flex.messaging.security.LoginCommandExt;

public class MyLoginCommand implements LoginCommand{

	@Override
	public void start(ServletConfig config) {
		// TODO Auto-generated method stub
		System.out.println("start");
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		System.out.println("stop");
	}

	@Override
	public Principal doAuthentication(String username, Object credentials) {
		// TODO Auto-generated method stub
		System.out.println("doAuthentication");
		if(username.equals("tomcat") &&credentials.equals("tomcat"))
			return new CustomPrincipal(username);
		else
			return null;
	}

	@Override
	public boolean doAuthorization(Principal principal, List roles) {
		// TODO Auto-generated method stub
		System.out.println("doAuthorization");
		return true;
	}

	@Override
	public boolean logout(Principal principal) {
		// TODO Auto-generated method stub
		return true;
	}
	
	 class CustomPrincipal implements Principal 
	    { 
	        private String username; 
	        public CustomPrincipal(String username) { 
	            this.username = username; 
	        }
	        
	        public String getName() { 
	            return username; 
	        } 
	    } 
}
