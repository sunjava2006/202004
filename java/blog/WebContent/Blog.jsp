<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
      @font-face {
            font-family:mt;
            src: url(./css/mzd.ttf);
        }
        #page{
            width: 1191px;
            height: 1400px;
            margin: auto;
        }
        #head{
            height: 138px;
            background-image: url(./img/banel_b.jpg);
            font-family: mt;
             font-size: 70px;
            line-height: 138px;
            color: aliceblue;
            padding-left: 100px;
        }
        #menu_bar{
            height: 38px;
            background-image: url(./img/bar_1px.jpg);
            line-height: 35px;
            padding: 0 20px;
        }
        #menu_bar a,#menu_bar a:visited{
            color: white;
            text-decoration: none;
        }
        
        #side{
            width: 200px;
            height: 1224px;
            background-color: cadetblue;
            float: left;
            display:flex;
            justify-content:center;
        }
        iframe{
            width: 990px;
            height: 1224px;
            float: left;
            border-right: solid gray 1px;
           
        }
    </style>
</head>
<body>
    <div id="page">
        <div id="head">
            ${blogInfo.blogName}
        </div>
        <div id="menu_bar">
        <c:if test="${param.blogID==userInfo.blog.blogID}">
            <a href="/publish.html">发表文章</a>
        </c:if>

           
        </div>
        <div id="main">
            <div id="side">
            
            <img src="/upload/${blogInfo.photo}" width="180" height="180">
            
            </div>
            <iframe src="/articleList?page=1&size=10&blogID=${userInfo.blog.blogID}" frameborder="0"></iframe>
        </div>


    </div>
</body>
</html>