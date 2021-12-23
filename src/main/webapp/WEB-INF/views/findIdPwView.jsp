<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="author" content="이자선">
    <title>아이디/비밀번호 찾기</title>

    <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/findIdPwView.css">
</head>
<body>
	
<div class="body_container">
    <header>
        <div class="point">
        </div>
        <div class="logo" onclick="location='/my/'">
            <strong>Movie</strong>
            <strong>Navigator</strong>
        </div>
    </header>

    <article class="findContainer">
        
        <section class="findIdForm">

            <form class="findId" method="POST" action="#">
                <div class="nform">
                    <div class="name">
                        <label for="user_name" class="namelabel">이름</label>
                        <input type="text" id="user_name" class="user_name" placeholder="이름">
                    </div>
    
                    <div class="number">
                        <label for="user_phone" class="phonelabel">전화번호</label>
                        <input type="tel" id="user_phone" class="user_phone" placeholder="전화번호">
                    </div>
                </div>
                <button class="id_btn" type="submit">확인</button>
                
            </form>
            <div class="resultIdContainer">
                <div class="resultId">아이디</div>
    
                <div class="userId"></div>
            </div>
        </section>
        
        <section class="findPwForm">

            <form class="findPw" method="POST" action="#">
                <div class="pwform">
                    <div class="id">
                        <label for="user_id" class="idlabel">아이디</label>
                        <input type="text" id="user_id" class="user_id" placeholder="아이디">
                    </div>
                    <div class="phone">
                        <label for="user_phone" class="phonelabel">전화번호</label>
                        <input type="tel" id="user_phone" class="user_phone" placeholder="전화번호">
                    </div>
                </div>
                <button class="pw_btn" type="submit">확인</button>
            </form>

            <div class="resultPwContainer">
                <div class="resultPw">비밀번호</div>
                <div class="userPw"></div>
            </div>
        </section>
    </article>
</div>
</body>
</html>