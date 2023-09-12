package RetrieveServlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;  
import java.sql.*;  
  
public class Search extends HttpServlet {  
		  
	public void doGet(HttpServletRequest request, HttpServletResponse response)  
		            throws ServletException, IOException {  
		  
	response.setContentType("text/html");  
	PrintWriter out = response.getWriter();  
		          
	String name =request.getParameter("pname");   
		          
	try{  
		final String url ="jdbc:mysql:///product";
		final String user ="root";
		final String password = "root123";
		 Class.forName("com.mysql.cj.jdbc.Driver"); 
		//establish a connection
		Connection con = DriverManager.getConnection(url,user,password);
		 Statement st = con.createStatement();
		String Query = "select * from product_details where name="+name;
				
		
		 ResultSet rs = st.executeQuery(Query);
		 
		 while(rs.next()) {
			 out.print("<html><body><center>"+"Id: "+ rs.getString(1) + "<br/> " + "Product-Name:"+rs.getNString(2)+
	                  "<br/> " + "Price: "+rs.getString(3)+"<br/> "+"Color: "+rs.getString(4)+"</center></body></html");
		 }
		 
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}