package LogIn;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/logInPage")
public class LogInPage extends HttpServlet
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		response.setContentType("text/html");
		
		PrintWriter out=response.getWriter();
		
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		//int number=Integer.parseInt(num);
		String num=request.getParameter("contact");
		String Address=request.getParameter("address");
		
		

		try
		{
			com.mysql.cj.jdbc.Driver d= new com.mysql.cj.jdbc.Driver();
			
			DriverManager.registerDriver(d);
			
			Connection cnn=DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet","root","root");
			
			PreparedStatement stmt=cnn.prepareStatement("insert into employee values('0',?,?,?,?)");
			
			stmt.setString(1,name);
			stmt.setString(2,email);
			stmt.setString(3,num);
			stmt.setString(4,Address);
			
			
			int value=stmt.executeUpdate();
			
			if(value>0) 
			{
				out.println("<h1>Registration Success....</h1>");
			}
			else
			{
				out.println("<h1>Some Problem Here</h1>");
			}
			
		}
		catch(Exception ex)
		{
			out.println(ex);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
