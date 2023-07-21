<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>First Servlet</title>
</head>
<body>

<h1>Hello!</h1>

<form action="SimpleServlet" method="get">

<input type="text" name="nom" placeholder="Nom"/>
<br>
<input type="text" name="age" placeholder="Age"/>

<input type="submit" value="envoyer"/>

</form>


</body>
</html>