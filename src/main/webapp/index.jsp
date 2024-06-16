<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "TPO 5" %></h1>
<br/>
<a href="hello-servlet">Hello Servlet</a>
<a href="request-servlet">Hello Servlet</a>
<a href="search-servlet">Hello Servlet</a>
<form method="GET" action ="http://localhost:8080/servlets_war/hello-servlet">
  Rodzaj<input type="text" size="50" name="filter"><br>
  <input type="submit" value="Szukaj">
</form>
</body>
</html>