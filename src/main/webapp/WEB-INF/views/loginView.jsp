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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/loginView.css">
</head>
<body>
	<div class="body_container">

    <header>
        <div class="pointContainer">
        <div class="point"></div>
        </div>
        <div class="logoContainer">
            <div class="logo" onclick="location='/my/'">
                <strong>Movie</strong>
                <strong>Navigator</strong>
            </div>
        </div>
        
    </header>

    <article class="loginFormContainer">
        
        <section class="loginForm">
            <form method="POST" action="#" class="login">
                <div class="id">
                    <label for="user_id" class="idlabel">아이디 </label>
                    <input type="text" placeholder="아이디" id="user_id" class="user_id">
                </div>
                
                <div class="password">
                    <label for="user_pwd" class="pwlabel">비밀번호</label>
                    <input type="password" placeholder="비밀번호" id="user_pwd" class="user_pwd">
                </div>
                
                <input type ="submit" value="로그인" class="ok_btn">
            </form>
        </section>

        <section class="linkForm">
            <div class="memberJoinLink">
                <a href="user/register">회원가입</a>
            </div>
            <div class="idpwFindLink">
                <a href="user/findIdPw">아이디/비밀번호 찾기</a>
            </div>
        </section>
    
    </article>
    
</div>
</body>
</html>