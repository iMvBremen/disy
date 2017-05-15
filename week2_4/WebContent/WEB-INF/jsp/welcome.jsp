<%@ page language="java" contentType="text/html"%>

<%! 
	public void jspInit()
	{
	    log("doTelop init");
	}   
%>

<html>
<head>
<title>Login result page</title>
<link href="mycss.css" rel="stylesheet" type="text/css">
</head>
<body>
	Welcome!
	<br>
	<hr>
	Name: ${user["name"]}<br>
	Password (plain text is safe, no worries): ${user["password"]}<br>
	Last login: ${user["formattedLastLogin"]}
	<br>
	<hr>
	<a href="login"> logout </a>
</body>
</html>