package servlets;

//EersteServlet.java

import java.io.PrintWriter;
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class MijnIpServlet extends HttpServlet
{
   public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException
   {
      response.setContentType("text/html");
      
      /* Here we get the IP address from the request */
      // Check if the X_FORWARDED_FOR header is included to get IP 
      // of client in case client is connecting through proxy for instance
      String ipAddress = request.getHeader("X-FORWARDED-FOR");
      if (ipAddress == null) {
    	  ipAddress = request.getRemoteAddr();
      }
      
      PrintWriter out = response.getWriter();
      String s =
      "<!doctype html public \"-//w3c//dtd html 4.0 Transitional//EN\">\n" +
      "<html>\n" +
      "   <head>\n" +
      "       <title>\n" +
      "          MijnIp page\n" +
      "       </title>\n" +
      "   </head>\n" +
      "   <body bgcolor=\"#8AAFED\">\n" +
      "      <center>\n" +
      "         <h1>\n" +
      "            IP: " + ipAddress + "\n" +
      "         </h1>\n" +
      "      </center>\n" +
      "   </body>\n" +
      "</html>\n";

      out.print(s); 
   }
}
