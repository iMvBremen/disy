<%@ page language="java" contentType="text/html" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%! 
	public void jspInit()
	{
	    log("toonquery init");
	}   
%>

<html>
   <head>
      <title>toonqueryresult page</title>
      <link href="mycss.css" rel="stylesheet" type="text/css">
   </head>
   <body>
   		<form method="get" action="dabaquery">
            <table class = "center">
               <tr>
                  <td align="right">
                     Query:
                  </td>
                  <td>
                     <input type="text" name="query" value="${querybean.query}">
                  </td>
               </tr>
               <tr>
                  <td colspan = "2" align= "right">
                      <input type="submit" value=" query ">
                  </td>
               </tr>   
            </table>
         </form>
   
      toon_query_result page
      <hr>
         ${querybean.query}
      <hr>
      <br>
		<table class="center">
              <tr class="trcolor1">
              <c:forEach var="item" items= "${querybean.labels}">
                  <th> ${item} </th>
              </c:forEach>	
              </tr>  
            <c:forEach var="item" items= "${querybean.resultTable}">
    		    <tr class="trcolor2">
                <c:forEach var="item2" items = "${item}">
                    <td> ${item2}  </td>
                </c:forEach>
                </tr>
            </c:forEach>
		</table>
      <br>
      <hr>
   </body>
</html>