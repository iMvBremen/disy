package servlets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.UserBean;
@SuppressWarnings("serial")
public class LoginServlet extends HttpServlet
{
	private static final File FILE = new File("users.txt");
	private List<UserBean> userBeanList;
	
   public void init() throws ServletException
   {
      super.init();
      
      // Create a new file with some demo users if it doesn't exist yet
      if (!FILE.exists()) {
    	  try {
    		  FILE.createNewFile();
    		  final PrintStream printStream = new PrintStream(FILE);
    		  printStream.println("naam wachtwoord 0");
    		  printStream.println("klaas vis123 41231");
    		  printStream.println("vogel legov 41231");
    		  printStream.close();
    	  } catch (IOException e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      }
      
      // Create a new List that will contain all UserBeans from the textfile
      userBeanList = new ArrayList<UserBean>();
      
      try {
    	  // Scan each line from the file
    	  final Scanner scanner = new Scanner(FILE);
    	  while (scanner.hasNextLine()) {
    		  // Split current line on each space
        	  final String[] values = scanner.nextLine().split(" ");
        	  // Check if the String array is the length we expect
        	  if (values.length == 3) {
        		  // Create a new UserBean, set the data and add it to the List
        		  final UserBean userBean = new UserBean();
        		  userBean.setName(values[0]);
        		  userBean.setPassword(values[1]);
        		  userBean.setLastLogin(Long.parseLong(values[2]));
        		  
        		  userBeanList.add(userBean);
        	  }
          }
          scanner.close();
      } catch (FileNotFoundException e) {
    	  e.printStackTrace();
      }
      
      log("servlet init");
   }
   
   public void destroy()
   {
	  try {
		  // Write all data of the UserBeans to the file
 		  final PrintStream printStream = new PrintStream(FILE);
 		  for (UserBean userBean : userBeanList) {
 			  printStream.println(userBean.getName() + " " + userBean.getPassword() + " " + userBean.getLastLogin());
 		  }
 		  printStream.close();
 	  } catch (IOException e) {
 		  // TODO Auto-generated catch block
 		  e.printStackTrace();
 	  }
	   
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
	  
	  // Check if the UserBean is in the List of existing users
	  if (userBeanList.contains(ub)) {
		  // Update ub lastLogin with UserBean from the List and 
		  // set new lastLogin value
		  for (UserBean userBean : userBeanList) { 
			  if (userBean.equals(ub)) {
				  ub.setLastLogin(userBean.getLastLogin());
				  userBean.updateLastLogin();
				  
				  break;
			  }
		  }
		  
		  // Add the UserBean as an attribute so it can be used in welcome.jsp
		  request.setAttribute("user", ub);
		  url = "WEB-INF/jsp/welcome.jsp";
	  } else {
		  url = "WEB-INF/jsp/login.jsp";
	  }
 
	  RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	  dispatcher.forward(request, response);
  }
}

