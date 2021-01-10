<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form:form method="post" modelAttribute="person">
      <form:input path="login"/>
      <form:password path="password"/>
      <form:input path="email"/>

      <input type="submit" value="Tomasz Łacina"/>
    </form:form>
  </body>
</html>