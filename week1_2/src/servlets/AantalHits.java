package servlets;

//AantalBezoekers.java

import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
public class AantalHits extends HttpServlet
{
	private static final String pathname = "aantal.txt";
	private File file;
   private int aantal = 0;
   
   public void init() throws ServletException
   {
      super.init();
      
      log("servlet init");
      // Get the initial value of aantal from web.xml file
      String s = getInitParameter("aantal");
      try
      {
          aantal = Integer.parseInt(s);
      }
      catch (Exception e)
      {         
      }
      
      // Check if the File for given pathname exists
      file = new File(pathname);
      log(file.getAbsolutePath());
      if (!file.exists()) {
    	  // File does not exists, so create it
    	  try {
    		  boolean success = file.createNewFile();
    		  log("success " + success);
    	  } catch (IOException e) {
    		  // TODO Auto-generated catch block
    		  e.printStackTrace();
    	  }
      } else {
    	  try {
    		  // File exists, so get the first int value
        	  final Scanner scanner = new Scanner(file);
        	  if (scanner.hasNextInt()) {
        		  aantal = scanner.nextInt();
        	  } else {
        		  log("no integer found");
        	  }
        	  scanner.close();
          } catch (FileNotFoundException e2) {
        	  // TODO Auto-generated catch block
        	  e2.printStackTrace();
          }
      }     
   }
   
   public void destroy()
   {
      log("servlet destroy");
      super.destroy();
   }
   
   public void doGet(HttpServletRequest request,HttpServletResponse response)
                                         throws ServletException, IOException
   {
      response.setContentType("text/html");
      PrintWriter out = response.getWriter();

      String s1 =
    	  	"<html>\n" +
    	  	"   <head>\n" +
    	  	"       <title>\n" +
    	  	"          Aantal hits page\n" +
    	  	"       </title>\n" +
    	  	"   </head>\n" +
    	  	"   <body bgcolor=\"#8AAFED\">\n" +
    	  	"      <center>\n" +
    	  	"         <h1>\n";

      String s2 = "";
      synchronized(this)
      {
    	  // Open the file and write the new aantal value to it
		  final FileWriter fileWriter = new FileWriter(file, false);
		  fileWriter.write(++aantal + "");
		  fileWriter.close();
          s2 =
            "            Aantal hits: " + aantal + "\n";
      }
      String s3 =
    	    "         </h1>\n" +
            "      </center>\n" +
            "   </body>\n" +
            "</html>\n";
      out.print(s1+s2+s3);
   }
}

