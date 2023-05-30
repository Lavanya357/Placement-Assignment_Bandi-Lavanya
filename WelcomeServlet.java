package in.ineuron.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/WelcomeServlet")
public class WelcomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = getInitParameter("name");
        
        // Set the content type of the response
        response.setContentType("text/html");
        
        // Create a PrintWriter to write the response content
        PrintWriter out = response.getWriter();
        
        // Write the welcome message to the response
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Welcome</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Welcome, " + name + "!</h1>");
        out.println("</body>");
        out.println("</html>");
    }
}


