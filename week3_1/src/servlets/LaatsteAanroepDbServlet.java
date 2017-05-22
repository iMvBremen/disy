package servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.UserBean;
@SuppressWarnings("serial")
public class LaatsteAanroepDbServlet extends HttpServlet
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
	  String name = request.getParameter("name");
	  String password = request.getParameter("password");
	  String url = "";
	  
	  // Create a new UserBean for given name and password
	  final UserBean ub = new UserBean();
	  ub.setName(name);
	  ub.setPassword(password);
	  ub.query();
	  
	  // Check if the UserBean is in the List of existing users
	  log(ub.getName() + " " + ub.getPassword() + " exists: "+ub.exists());
	  url = "WEB-INF/jsp/welcome.jsp";
	  ub.incrLogins();
	  if (ub.exists()) {		  
		  // Add the UserBean as an attribute so it can be used in welcome.jsp
		  request.setAttribute("user", new UserBean(ub));
		  
		  ub.updateLastLogin();
		  ub.update();
	  } else if (ub.isValid()) {
		  ub.updateLastLogin();
		  // Add the UserBean as an attribute so it can be used in welcome.jsp
		  request.setAttribute("user", ub);
		  log("add: "+ub.add());
	  } else {
		  url = "WEB-INF/jsp/login.jsp";
	  }
 
	  RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	  dispatcher.forward(request, response);
  }
}

