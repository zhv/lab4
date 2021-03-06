<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="path" value="${pageContext.request.contextPath}"></c:set>

<html>

<head>
	<script type="text/javascript" src="${path}/js/addreview.js"></script>
	<link rel="stylesheet" href="/css/test.css"/>
</head>

<body>
	<h1>View Book</h1>
	<form action="${path}/book/${book.bookId}/addreview" method="POST">
		<div> <b>Book:</b>
			Name: ${book.bookName} Rating: ${book.bookRating} <br>
			ISBN: ${book.isbn} <br>
			Year: ${book.year} <br>
			Description: ${book.description} <br>
			</div>
		<br>
		<br>
		<div> <b>Genre:</b>
			<br/>
			<c:forEach items="${book.genres}" var="genre"> ${genre.genreName}
				<br>
				<br> </c:forEach>
		</div>
		<br>
		<br>
		<div> <b>Author:</b>
			<br/>
			<c:forEach items="${book.authors}" var="author"> First Name ${author.firstName} Last Name ${author.lastName}" Middle Name ${author.middleName}
				<br>
				<br> </c:forEach>
		</div>
		<br>
		<br>
		<div> <b>Publisher:</b>
			<br/>
			<c:forEach items="${book.publishers}" var="publisher"> ${publisher.publisherName}
				<br>
				<br> </c:forEach>
		</div>
		<br>
		<br>
		<div> <b>Book Reviews:</b>
			<br>
			<c:forEach items="${reviews}" var="review">
                <c:choose>
                    <c:when test="${user.username == review.user.username}">
                       <c:set var="rev" scope="session" value="Yes" />

                           <c:forEach var="entry" items="${review.bookReview}">
                                <textarea id="textReview" rows="5" cols="200" style="width: 400px" name="textReview">${entry.key}</textarea>
                                <br><br>
                                <input type="number" name="rating" size="1" min="1" max="5" value="${entry.value}"/>
                                <br><br>
                           </c:forEach>

                    </c:when>
                    <c:otherwise>
                        <c:forEach var="entry" items="${review.bookReview}">

                            Review By User: ${review.user.username} <br> ${entry.key} <br> Rating: ${entry.value}
                            <br>
                            <br>

                        </c:forEach>
                   </c:otherwise>
                </c:choose>
				<br><br> </c:forEach>
			<br> </div>
		<br>
		<br>

		<div id="bookReview">
			<br>
			<br>
		</div>

        <c:if test="${empty rev}">
            <div id="but">
                <input type="button" value="Add new Review" onclick="addBookFormReview()"/>
                <br>
                <br>
            </div>
        </c:if>


		<input type="submit" align="center" value="Save"/>

	</form>

	<p><a href="${path}/">Start Page</a></p>

    <p><a href="${path}/console">H2 Console</a></p>

</body>

</html>