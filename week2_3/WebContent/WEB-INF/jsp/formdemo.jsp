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
         calculate form page
         <hr>
         <br>
     	 ${calc['xvalid'] ? '' : 'X not valid<br>' }
       	 ${calc['yvalid'] ? '' : 'Y not valid' }
         <br>
        <form method="get" action="calculate">
            <table class = "center">
               <tr>
                  <td align="right">
                     x:
                  </td>
                  <td>
                     <input name="xvalue" value="${calc['xvalue']}"  size="15">
                  </td>
               </tr>
               <tr>
                  <td align="right">
                     y:
                  </td>
                  <td>
                     <input name="yvalue" value="${calc['yvalue']}" size="15">
                  </td>
               </tr>
               <tr>
                  <td colspan = "2" align= "right">
                      <input type="submit" value=" tel op ">
                  </td>
               </tr>   
            </table>
         </form>
   </body>
</html>