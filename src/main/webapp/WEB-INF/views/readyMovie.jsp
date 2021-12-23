<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>개봉 예정작</title>

    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/readyMovie.css">

</head>
<body>
<div class="body_container">

    <header>
        <div class="point"></div>
        <div class="logo" onclick="location='/my/'">
            <strong>Movie</strong>
            <strong>Navigator</strong>
        </div>
        <div class="title">
            개봉예정작
        </div>
    </header>

    <article class="readyMovieContainer">

        <section class="readyMovie">
            <div class="movieList">

            </div>
        </section>
    </article>
</div>
</body>
</html>