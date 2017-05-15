<%@ page language="java" contentType="text/html"%>
<%@ page import="java.util.Calendar,java.text.SimpleDateFormat" %>

<%!
	private static final String LAST_REQUEST_COOKIE_NAME = "REQ-COOKIE";

	public void jspInit() {
		log("jsp init");
	}

	public void jspDestroy() {
		log("jsp destroy");
	}
	
	private void handleResponse(HttpServletResponse response) {
		// Add a new cookie to the response (current session only)
      	final Cookie cookie = new Cookie(LAST_REQUEST_COOKIE_NAME, Calendar.getInstance().getTimeInMillis() + "");
      	response.addCookie(cookie);
	}
	
	private String getLastRequest(HttpServletRequest request) {
		// Define String with default text (in case no cookie is found)
      	String lastRequestString = "none";
      	if (request.getCookies() != null) {
    	  	// Check if our cookie is there and set the String if it is
	      	for (Cookie curCookie : request.getCookies()) {
	    	  	if (curCookie.getName().equals(LAST_REQUEST_COOKIE_NAME)) {
	    	  		final Calendar calendar = Calendar.getInstance();	    	  		
	    		  	// Set the current time of the Calendar
	    		  	calendar.setTimeInMillis(Long.parseLong(curCookie.getValue()));
	    		  	// Format the parsed time and store it in the string
	    		  	lastRequestString = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSSXXX").format(calendar.getTime());
	    		  
	    		  	break;
	    	  	}
	      	}
      	}
      	
      	return lastRequestString;
	}
%>

<%
	handleResponse(response);
%>

<html>
<head>
<title>Last request page</title>
<link href="mycss.css" rel="stylesheet" type="text/css"> 
</head>
<body>
	<h1>
		Last request: <%=getLastRequest(request)%><br>
	</h1>
</body>
</html>

