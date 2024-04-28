<%--
  Created by IntelliJ IDEA.
  User: BM
  Date: 4/21/2024
  Time: 11:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"  %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form:form action="process" modelAttribute="theCustomer">

    First Name: <form:input path="firstName"/><form:errors path="firstName" cssStyle="color: blueviolet"/><br>
    Last Name: <form:input path="lastName"/><form:errors path="lastName" cssStyle="color: blueviolet"/><br>
    Email: <form:input path="email"/><form:errors path="email" cssStyle="color: blueviolet"/><br>
    Age: <form:input path="age"/><form:errors path="age" cssStyle="color: blueviolet"/><br>
    Gender: <br>
    Male<form:radiobutton path="gender" value="male"/><br>
    Female<form:radiobutton path="gender" value="female"/><br>
    Country:
    <form:select path="country">
        <form:option value="egypt" label="egypt"/>
        <form:option value="mexico" label="mexico"/>
        <form:option value="france" label="france"/>
        <form:option value="japan" label="japan"/>
    </form:select><br>
    Course Code: <form:input path="code"/><form:errors path="code" cssStyle="color: blueviolet"/><br>
    Active: <form:checkbox path="active"/><br>
    <input type="submit" value="add"/>


</form:form>

</body>
</html>
