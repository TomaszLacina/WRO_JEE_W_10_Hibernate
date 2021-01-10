<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form:form method="post" modelAttribute="book">
      <form:input path="title"/>
      <form:input path="rating"/>
      <form:input path="description"/>

      <form:select path="publisher" items="${publishers}"
            itemValue="id" itemLabel="name"/>
      <input type="submit" value="Zapisz"/>
    </form:form>
  </body>
</html>