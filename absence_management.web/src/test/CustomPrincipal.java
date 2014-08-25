package test;

import java.security.Principal;

public class CustomPrincipal implements Principal { 
    private String username;
    
    public CustomPrincipal(String username) { 
        this.username = username; 
    }
    
    public String getName() { 
        return username; 
    } 
} 