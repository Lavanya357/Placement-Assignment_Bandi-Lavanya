package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ServletDbController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Connection connection=null;
	static
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("Driver loaded successfully");
		}
		catch(ClassNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void init() 
	{
		String url=getInitParameter("url");
		String username=getInitParameter("username");
		String password=getInitParameter("password");
		System.out.println(url);
		System.out.println(username);
		System.out.println(password);
		
		try
		{
			connection=DriverManager.getConnection(url, username, password);
			if(connection!=null)
			{
				System.out.println("connection established successfully");
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		out.println("<h1>Request type is :" +request.getMethod()+"</h1");
		Statement statement=null;
		try {
			statement = connection.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			ResultSet resultSet=statement.executeQuery("select sid, sname, sage, saddress from student");
			System.out.println();
			out.println("<html><head><title>Student Table</title></head><body>");
            out.println("<table border='1'>");
            out.println("<tr><th>sid</th><th>sname</th><th>sage</th><th>saddr</th></tr>");
			
			System.out.println("SID\tSNAME\tSAGE\tSADDRESS");
			while(resultSet.next())
			{
				Integer sid=resultSet.getInt(1);
				String sname=resultSet.getString(2);
				Integer sage=resultSet.getInt(3);
				String saddr=resultSet.getString(4);
				out.println("<tr><td>" + sid + "</td><td>" + sname + "</td><td>" + sage + "</td><td>" +saddr+ "</td></tr>");
				
				System.out.println(sid+"\t"+sname+"\t"+sage+"\t"+saddr);
			}
			out.println("</table>");
            out.println("</body></html>");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			if(connection!=null)
			{
				try
				{
					connection.close();
					System.out.println("connection closed");
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
			}
		}
	}
}


