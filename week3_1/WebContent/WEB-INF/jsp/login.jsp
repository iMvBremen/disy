<%@ page language="java" contentType="text/html"%>

<%! 
	public void jspInit()
	{
	    log("doTelop init");
	}   
%>

<html>
   <head>
      <title>calculate form page</title>
      <link href="mycss.css" rel="stylesheet" type="text/css"> 
   </head>
   <body>
         Login form page
         <hr>
         <br>
         <br>
        <form method="get" action="login">
            <table class = "center">
               <tr>
                  <td align="right">
                     name:
                  </td>
                  <td>
                     <input name="name" value=""  size="15">
                  </td>
               </tr>
               <tr>
                  <td align="right">
                     password:
                  </td>
                  <td>
                     <input name="password" value="" size="15">
                  </td>
               </tr>
               <tr>
                  <td colspan = "2" align= "right">
                      <input type="submit" value=" login ">
                  </td>
               </tr>   
            </table>
         </form>
   </body>
</html>