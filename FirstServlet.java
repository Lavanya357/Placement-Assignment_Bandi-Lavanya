package in.ineuron.controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

        // Set the content type and write the response
        response.setContentType("text/html");
        Enumeration<String> attributeNames=session.getAttributeNames();
        while(attributeNames.hasMoreElements())
        {
        	String attributeName=(String) attributeNames.nextElement();
        	Object attributeValue=session.getAttribute(attributeName);
        }
	}

}
