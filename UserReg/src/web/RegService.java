package web;

import java.awt.PageAttributes.MediaType;
import java.sql.DriverManager;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

 
@Path("/register")
public class RegService
{
@POST
@Path("/doregister")
public String registerUserInfo(@FormParam("FirstName") String FirstName,@FormParam("LastName") String LastName,@FormParam("Email") String Email,
        @FormParam("username") String username, @FormParam("password") String password, @FormParam("confirmpassword") String confirmpassword){

String response = "Successfully added user details, FirstName: "+
FirstName+" and LastName: "+LastName+" and Email: "+Email+" and username: "+username+" and password: "+password+" and confirmpassword: "+confirmpassword;
return response;
}
private int registerUser(String FirstName,String LastName,String Email,String username,String password,String confirmpassword) {
	
if(FirstName.equals(null)||FirstName==""||LastName.equals(null)||LastName==""||Email.equals(null)||Email==""||username.equals(null)||username==""||password.equals(null)||password==""||confirmpassword.equals(null)||confirmpassword=="")
{
	System.out.println( "ALL fields are mandatory");
}
else{
	

try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/userdb", "subbu", "subbu123");
 
            PreparedStatement ps = (PreparedStatement) con
                    .prepareStatement("insert into Employee values(?,?,?,?,?,?)");
 
            ps.setString(1, FirstName);
            ps.setString(2, LastName);
            ps.setString(3, Email);
            ps.setString(4, username);
            ps.setString(5, password);
            ps.setString(6, confirmpassword);
            
            int i = ps.executeUpdate();
            if (i > 0)
               System.out.print("You are successfully registered...");
          
        } catch (Exception e2) {
            System.out.println("please check the details");
            
        }

	}
return 0;
}
}