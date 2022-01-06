<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>영화 장르별 보기</title>

    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/genreView.css">

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
            영화 장르별 보기
        </div>
    </header>

    <artilce class="genreContainer">
        <section class="genre_indexContainer">
            
            <div class="genre_index">
                <p id="genre-btn" class="action">#액션</p>
                <p id="genre-btn" class="comedy">#코미디</p>
                <p id="genre-btn" class="melo">#멜로</p>
                <p id="genre-btn" class="drama">#드라마</p>
                <p id="genre-btn" class="history">#사극</p>
                <p id="genre-btn" class="mystery">#미스터리</p>
                <p id="genre-btn" class="fantasy">#판타지</p>
                <p id="genre-btn" class="sf">#SF</p>
                <p id="genre-btn" class="crime">#범죄</p>
                <p id="genre-btn" class="horror">#공포</p>
            </div>
        </section>

        <section class="resultContainer">
            
            <div class="movieResult">

            </div>
        </section>
    </artilce>
</div>
<script type="module" src="${pageContext.request.contextPath}/resources/js/genreView.js"></script>
</body>
</html>