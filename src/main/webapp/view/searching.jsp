<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>
    <head>
        <link rel="stylesheet" href="/css/test.css"/>
    </head>
    <body>
    <h1>Searching Book</h1>

        <form action="${path}/searching" method="POST">
            <div id="bookItems">
                <div>
                    <b>Book:</b><br/>
                    Name <input type="text" name="bookName"/>
                    ISBN <input type="text" name="isbn"/>
                    Year <input type="text" name="year"/>
                </div>
            </div>

            <br>

            <div id="genreItems">
                <div>
                    <b>Genre:</b><br/>
                        Genre Name <input type="text" name="genreName"/>
                        <br><br>
                </div>
            </div>

            <br><br>

            <div id="authorItems">
                <div>
                    <b>Author:</b><br/>
                        First Name <input type="text" name="firstName"/>
                        Last Name <input type="text" name="lastName"/>
                        Middle Name <input type="text" name="middleName"/>
                        <br><br>
                </div>
            </div>

            <br><br>

            <div id="publisherItems">
                <div>
                    <b>Publisher:</b><br/>
                        Publisher Name <input type="text" name="publisherName"/>
                        <br><br>
                </div>
            </div>

            <br><br>

            <div>
                <input type="submit" align="center" value="Searching"/>
            </div>
        </form>

        <br><br>

        <p><a href="${path}/">Start Page</a></p>

        <p><a href="${path}/console">H2 Console</a></p>

    </body>
</html>