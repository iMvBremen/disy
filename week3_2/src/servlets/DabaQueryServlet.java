package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.QueryBean;

/*
 * Uses DB of week3_1
 */

@SuppressWarnings("serial")
public class DabaQueryServlet extends HttpServlet
{

   public void init() throws ServletException
   {
      super.init();
      log("servlet init");
   }
   
   public void destroy()
   {
      log("servlet destroy");
      super.destroy();
   }
   
   public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException
   {
	   String query = request.getParameter("query");
	   
	   final QueryBean qb = new QueryBean();
	   qb.setQuery(query);
	   
	   request.setAttribute("querybean", qb);
	   
	  RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/ToonQueryResult.jsp");
	  dispatcher.forward(request, response);
  }
}

