package test;

import java.security.Principal;
import java.util.List;

import javax.servlet.ServletConfig;

import flex.messaging.FlexContext;
import flex.messaging.security.LoginCommand;

public class MyLoginCommand implements LoginCommand{

	@Override
	public void start(ServletConfig config) {
		System.out.println("start");
	}

	@Override
	public void stop() {
		System.out.println("stop");
	}

	@Override
	public Principal doAuthentication(String username, Object credentials) {
		System.out.println("doAuthentication");
		if(username.equals("tomcat") &&credentials.equals("tomcat")) {
			FlexContext.setUserPrincipal(new CustomPrincipal(username));
			System.out.println(FlexContext.getUserPrincipal().getName());
			return new CustomPrincipal(username);			
		}
		else
			return null;
	}

	@Override
	public boolean doAuthorization(Principal principal, List roles) {
		System.out.println("doAuthorization");
		return true;
	}

	@Override
	public boolean logout(Principal principal) {
		return true;
	}
	
	 class CustomPrincipal implements Principal { 
	        private String username;
	        
	        public CustomPrincipal(String username) { 
	            this.username = username; 
	        }
	        
	        public String getName() { 
	            return username; 
	        } 
	    } 
}
