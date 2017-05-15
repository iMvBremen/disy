<%@ page language="java" contentType="text/html"%>

<%!
	public void jspInit() {
		log("jsp init");
	}

	public void jspDestroy() {
		log("jsp destroy");
	}
	
	private String getIpAddress(HttpServletRequest request) {
		/* Here we get the IP address from the request */
		// Check if the X_FORWARDED_FOR header is included to get IP 
		// of client in case client is connecting through proxy for instance
		String ipAddress = request.getHeader("X-FORWARDED-FOR");
		if (ipAddress == null) {
			  ipAddress = request.getRemoteAddr();
		}
		
		return ipAddress;
	}
%>

<html>
<head>
<title>MijnIp page</title>
<link href="mycss.css" rel="stylesheet" type="text/css"> 
</head>
<body>
	<h1>
		IP: <%=getIpAddress(request)%><br>
	</h1>
</body>
</html>

