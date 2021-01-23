<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
  <head>
    <title>Title</title>
  </head>
  <body>
    <form:form method="post" modelAttribute="book">
      Title

      <form:input path="title"/> <br/>
      Rating

      <form:input path="rating"/> <br/>
      Descripion

      <form:input path="description"/><br/>
      Pages

      <form:input path="pages"/> <br/>
      Publisher

      <form:select path="publisher" items="${publishers}"
            itemValue="id" itemLabel="name"/>  <br/>
      <input type="submit" value="Zapisz"/>


      <form:errors path="*"/>
    </form:form>
  </body>
</html>