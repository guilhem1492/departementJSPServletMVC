<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>index</title>
</head>
<body>

<!-- ShowDept -->
<form action="ShowDept" method="get">
<h2>Chercher un département</h2>

<input type="text" name="num" placeholder="Numéro de département"/>

<input type="submit" value="envoyer"/>

</form>

<!-- AddDept -->
<form action="AddDept" method="post">
<h2>Ajouter un département</h2>

<input type="text" name="addNum" placeholder="Numéro de département"/>
<input type="text" name="addName" placeholder="Nom du département"/>

<input type="submit" value="envoyer"/>

</form>

<form action="RemoveDept" method="post">
<h2>Supprimer un département</h2>

<input type="text" name="removeNum" placeholder="Numéro de département"/>

<input type="submit" value="envoyer"/>

</form>

</body>
</html>