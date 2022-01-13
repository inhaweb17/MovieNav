<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
   <meta charset="utf-8">
   <meta name="author" content="이자선">
   <meta http-equiv="X-UA-Compatible" content="IE=edge">
   <meta name="viewport" content="width=device-width, initial-scale=1.0">
   <title>MNavigator</title>

   <link
      href="https://fonts.googleapis.com/css2?family=Noto+Sans+KR:wght@400;500;700&display=swap"
      rel="stylesheet"
    />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/font.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/home.css">
    
</head>

<body>
   <div class="body_container">
        <header>
            <section class="searchbox">
                <form action="#" method="GET">
                    <input class="search" id="search" type="search" placeholder="검색">
                    <label for="search">
                        <button type="submit" class="search_btn" alt="검색버튼">
                            <i class="ic-search"></i>
                        </button>
                        
                    </label> 
                </form>
            </section>

            <section class="userbox">
               <div class="logout">
                  <button class="log in loginbtn" type="button" onclick="location='login'">
                       login
                   </button>
                   <button class="user in btn" type="button" onclick="location='register'">
                       회원가입 
                   </button>
                   <button class="mypage" type="button" onclick="location='mypage/myinfo'">
                       mypage
                   </button>
               </div>
               
               <div class="login">
                  <div class="logoutbtn">
                     logout
                  </div>
                  <div class="mypagebtn">
                     mypage
                  </div>
               </div>
                
            </section>

        </header>

        <article class="movie-rank">
            <section class="movieList">
            <!--<i class="ic-left_btn_new"></i>-->
                <button class="left_btn">
                    &laquo;
                </button>

                <div class="movies1">
                    <div class="p0"></div>
                    <div class="p1"></div>
                </div>

                <div class="logo">
                    <strong>
                        Movie
                    </strong>
                    <strong>
                        Navigator
                    </strong>
                </div>

                <div class="movies2">
                    <div class="p2"></div>
                    <div class="p3"></div>
                </div>
   <!--<i class="ic-right_btn_new"></i>-->
                <button class="right_btn"> 
                    &raquo;
                </button>
            </section>
        </article>

        <article class="category">

            <section class="categorybox">

                <div class="readymovie">
                    <i class="ic-now_movie"></i>
                    <div class="readymovie-link">
                        <a href="readyMovie" alt="개봉예정작">#개봉예정작</a>
                    </div>
                </div>
				<a href="filmdetail/filmDetailView" alt="영화상세보기">#영화상세보기</a>
                <div class="genremovie">
                    <i class="ic-genre_movie"></i>
                    <div class="genremovie-link">
                        <a href="genreView" alt="장르별 보기">#장르별보기</a>
                    </div>
                </div>

            </section>
            
        </article>

        <article class="review-list">
            <section class="reviewbox">
                <div class="reviewtitle">
                    #실시간리뷰
                </div>
                <div class="reviews">
                    <div>
                        <i class="ic-watcher"></i>
                    <div class="r0"></div>
                    </div>
                    <div>
                        <i class="ic-watcher"></i>
                    <div class="r1"></div>
                    </div>
                    <div>
                        <i class="ic-watcher"></i>
                    <div class="r2"></div>
                    </div>
                    
                </div>
            </section>
        </article>

        <footer>
            

        </footer>
    </div>
</body>
   
   <script>
   let poster = '${poster}';
   let le = poster.length;
   poster = poster.slice(1,(le-1));
   
   </script>
   <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/showRanking.js"></script>
</html>