<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
    <head>
        <script type="text/javascript" src="${path}/js/edituser.js"></script>
        <link rel="stylesheet" href="/css/test.css"/>
    </head>
    <body>
        <h1>Edit Your Profile</h1>

        <form:form action="${path}/user/edituserprofile" modelAttribute="user" method="POST">

            First Name:  <form:input path="firstName" value="${user.firstName}"/><br><br>

            Last Name:  <form:input path="lastName" value="${user.lastName}"/><br><br>

            Middle Name:  <form:input path="middleName"  value="${user.middleName}"/><br><br>

            Email: <form:input path="email"  value="${user.email}"/><br><br>
            <form:errors path="email"/><br><br>

            Phone Number: <form:input path="phoneNumber"  value="${user.phoneNumber}"/><br><br>
            <form:errors path="phoneNumber"/><br><br>

            User Name: <form:input path="username"  value="${user.username}"/><br><br>
            <form:errors path="username"/><br><br>

            <br>

            <c:if test="${not empty error}">
                ${error}
            </c:if>

            <div id="passwordItems">

            </div>

            <br>

            <div id="but">

                <input type="button" value="Change Password" onclick="addUserChangePasswordForm()"/>

            </div>

            <br>
            <br>

            <input type="submit" value="Edit"/>

        </form:form>

        <p><a href="${path}/">Start Page</a></p>

        <p><a href="${path}/console">H2 Console</a></p>

    </body>
</html>