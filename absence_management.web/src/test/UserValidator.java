package test;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
 
public class UserValidator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        doPost(req, res);
    }
 
    public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {    	
    	RequestDispatcher rd;
    	
    	String code = req.getParameter("code");
    	
    	//Login normal (username + password)
        if (code == null || code.equals("")) {
        	String name = req.getParameter("name");
            String password = req.getParameter("password");
         
            CustomPrincipal user = validateLogin(name, password);
             
            if (user == null) {
                rd = req.getRequestDispatcher("/loginError.jsp");
            } else {
                HttpSession session = req.getSession();
                session.setAttribute("user", user);
                rd = req.getRequestDispatcher("/showEmployees.do");
            }
        } else {
        	//Login cu Facebook
        	String token = null;
            try {
                String g = "https://graph.facebook.com/oauth/access_token?client_id=714528398641253&redirect_uri=" + URLEncoder.encode("http://localhost:8080/absence_management.web/userValidator", "UTF-8") + "&client_secret=4ce1637f1617d716a8347eae3524c8b3&code=" + code;
                URL u = new URL(g);
                URLConnection c = u.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
                String inputLine;
                StringBuffer b = new StringBuffer();
                while ((inputLine = in.readLine()) != null)
                    b.append(inputLine + "\n");            
                in.close();
                token = b.toString();
                if (token.startsWith("{"))
                    throw new Exception("error on requesting token: " + token + " with code: " + code);
            } catch (Exception e) {
                    // an error occurred, handle this
            }

            String graph = null;
            try {
                String g = "https://graph.facebook.com/me?" + token;
                URL u = new URL(g);
                URLConnection c = u.openConnection();
                BufferedReader in = new BufferedReader(new InputStreamReader(c.getInputStream()));
                String inputLine;
                StringBuffer b = new StringBuffer();
                while ((inputLine = in.readLine()) != null)
                    b.append(inputLine + "\n");            
                in.close();
                graph = b.toString();
            } catch (Exception e) {
                    // an error occurred, handle this
            }

            String facebookId = "";
            String firstName = "";
            String middleNames = "";
            String lastName = "";
            String email = "";
            String gender = "";
            
            try {
                JSONObject json = new JSONObject(graph);
                facebookId = json.getString("id");
                firstName = json.getString("first_name");
                if (json.has("middle_name"))
                   middleNames = json.getString("middle_name");
                else
                    middleNames = null;
                if (middleNames != null && middleNames.equals(""))
                    middleNames = null;
                lastName = json.getString("last_name");
                email = json.getString("email");
                if (json.has("gender")) {
                    String g = json.getString("gender");
                    if (g.equalsIgnoreCase("female"))
                        gender = "female";
                    else if (g.equalsIgnoreCase("male"))
                        gender = "male";
                    else
                        gender = "unknown";
                } else {
                    gender = "unknown";
                }
            } catch (JSONException e) {
                // an error occurred, handle this
            }   
        	
        	System.out.println("Facebook ID: " + facebookId);
        	System.out.println("First name: " + firstName);
        	System.out.println("Middle name: " + middleNames);
        	System.out.println("Last name: " + lastName);
        	System.out.println("E-mail: " + email);
        	System.out.println("Gender: " + gender);        	
        	String hash = MD5Util.md5Hex(email);
        	req.setAttribute("hash", hash);
        	rd = req.getRequestDispatcher("/showEmployees.do");
        }    	
         
        rd.forward(req, res);
    }
 
    private CustomPrincipal validateLogin(String name, String password) {
        if (name.equals("user") && password.equals("password")) {
        	return new CustomPrincipal(name);
        }
        
        return null;
    }
}