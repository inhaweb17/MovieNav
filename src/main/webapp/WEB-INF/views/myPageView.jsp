<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>내 페이지</title>

    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/myPageView.css">
</head>
<body>
 <div class="body_container">

        <header>
            <div class="headercontainer">
                <div class="point">
                </div>
                <div class="logo">
                    <strong>Movie</strong>
                    <strong>Navigator</strong>
                </div>
            </div>

        </header>

        <article class="mypageContainer">
            <div class="contentContainer">
                <div class="menulist">
                    <button type="button" class="myinfo_btn" alt="나의 정보로 가는 버튼">
                        MY INFO
                    </button> 
                    <button type="button" class="myreview_btn" alt="내가 쓴 리뷰를 보는 페이지로 가는 버튼">
                        내가 쓴 리뷰
                    </button>
                    <button class="likemovie_btn" type="button" alt="내가 좋아요 한 영화를 보는 페이지로 가는 버튼">
                        좋아요 한 영화
                    </button>
                    <button class="changepw_btn" type="button" alt="비밀번호 바꾸기 페이지로 가는 버튼 ">
                        비밀번호 바꾸기 
                    </button>
                </div>

                <section class="myinfoContainer">
                    <div class="myinfo">
                        <div class="myinfotitle">나의 정보</div>
                        <form action="#" method="post" class="myinfoForm">
                            <div class="user_nameContainer">
                                <label for="user_name">이름</label>
                                <p class="user_name userinfo" id="user_name"></p>
                            </div>
                            
                            <div class="user_idContainer">
                                <label for="user_id">아이디</label>
                                <p class="user_id userinfo" id="user_id"></p>
                            </div>

                            <div class="user_emailContainer">
                                <label for="user_email">이메일</label>
                                <p class="user_email userinfo" id="user_email"></p>
                            </div> 

                            <div class="user_numberContainer">
                                <label for="user_number">전화번호</label>
                                <p class="user_number userinfo" id="user_number"></p>
                            </div>

                            <div class="user_dateContainer">
                                <label for="user_date">생년월일</label>
                                <p class="user_date userinfo" id="user_date"></p>
                            </div>

                            <button class="changeMYINFO" type="button">정보 수정하기</button>
                        </form>
                    </div>
                </section>

                <section class="myreviewContainer">
                    <div class="reviewContent">
                        <div class="reviewtitle" alt="내가 쓴 리뷰리스트">내가 쓴 리뷰 모아보기</div>
                    </div>
                </section>

                <section class="likemoiveContainer">
                    <div class="likeContent">
                        <div class="liketitle" alt="내가 좋아요한 영화들">내가 좋아요한 영화들</div>
                    </div>
                </section>
            </div>

        </article>

        <!--
            <script src="myPageView.js" // gochangepwview>
        -->
    </div>
</body>
</html>