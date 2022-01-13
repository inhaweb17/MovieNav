<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="author" content="이자선">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>로그인 화면</title>

    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/movieDetailView.css">
</head>
<body>
	<div class="body_container">
	
		<header>
			<div class="logoContainer">
				<div class="logo" onclick="location='/my/'">
					<strong>Movie</strong>
					<strong>Navigator</strong>
				</div>
			</div>
		</header>
		
		
		<article class="container">
        <section class="movieContainer">
                <!--poster이미지 들어갈 곳 -->
            <div class="mposter"> </div>
                <!--영화 상세 정보들어갈 곳-->
            <div class="movieInfoContainer"></div>
            <div class="gradeInfo">
                <div class="grade"> <!--해당 영화 평점 표기할 곳-->
                    
                </div>
                <div class="like"> <!--영화 추천 수 표기 할 곳-->
                    
                </div>
            </div>

            <div class="starGrade">
                <div class="stars"> <!--별 5개 모양이 표기 될 곳-->

                </div>
                <div class="point"> <!--별에 따라서 점수가 기록 될 곳-->
                    0
                </div>
                    <!--해당 버튼 클릭시 별점저장-->
                <button type="button" class="submitGrade">별점 주기</button>
                <button type="button" class="submitLike">추천 하기</button>
            </div>
        </section>
    
        <section class="reviewContainer">
            <div class="reviewInput">
                <form action="" method="" class="reivew">
                    <label for="reviewText">리뷰 작성하기</label>
                    <input type="text" id="reviewText" name="reviewText">
                    <input type="submit" class="reviewBtn" value="입력">
                </form>
                <div class="sort_container">
                    <label for="sort">리뷰정렬</label>
                    <select id="sort">
                        <option>추천순</option>
                        <option>최신순</option>
                    </select>
                </div>
            </div>
                <div class="reviewList">
                    <div class="review">리뷰내용 예제</div>
                    <div class="reivew">리뷰</div>
                </div>
        </section>

    </article>
	</div>
	<script type="module" src="${pageContext.request.contextPath}/resources/js/movieDetailView.js"></script>
</body>
</html>