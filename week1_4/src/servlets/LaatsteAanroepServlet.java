package servlets;

//EersteServlet.java

import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class LaatsteAanroepServlet extends HttpServlet
{
	private static final String LAST_REQUEST_COOKIE_NAME = "REQ-COOKIE";
	
   public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException
   {
      response.setContentType("text/html");
      
      // Create a new (NOT singleton) Calendar object for getting current time and parsing time
      final Calendar calendar = Calendar.getInstance();
      
      // Add a new cookie to the response (current session only)
      final Cookie cookie = new Cookie(LAST_REQUEST_COOKIE_NAME, calendar.getTimeInMillis() + "");
      response.addCookie(cookie);
      
      // Define String with default text (in case no cookie is found)
      String lastRequestString = "none";
      if (request.getCookies() != null) {
    	  // Check if our cookie is there and set the String if it is
	      for (Cookie curCookie : request.getCookies()) {
	    	  if (curCookie.getName().equals(LAST_REQUEST_COOKIE_NAME)) {
	    		  // Set the current time of the Calendar
	    		  calendar.setTimeInMillis(Long.parseLong(curCookie.getValue()));
	    		  // Format the parsed time and store it in the string
	    		  lastRequestString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSXXX").format(calendar.getTime());
	    		  
	    		  break;
	    	  }
	      }
      }
      
      PrintWriter out = response.getWriter();
      String s =
      "<!doctype html public \"-//w3c//dtd html 4.0 Transitional//EN\">\n" +
      "<html>\n" +
      "   <head>\n" +
      "       <title>\n" +
      "          Laatste Aanroep Servlet page\n" +
      "       </title>\n" +
      "   </head>\n" +
      "   <body bgcolor=\"#8AAFED\">\n" +
      "      <center>\n" +
      "         <h1>\n" +
      "            Last request: " + lastRequestString + "\n" +
      "         </h1>\n" +
      "      </center>\n" +
      "   </body>\n" +
      "</html>\n";

      out.print(s); 
   }
}
