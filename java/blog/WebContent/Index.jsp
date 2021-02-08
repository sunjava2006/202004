<%@ page language="java" contentType="text/html; charset=UTF-8"  import="com.thzhima.blog.bean.User, com.thzhima.blog.bean.Blog"
    pageEncoding="UTF-8"%>
   
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <style>
         html, body{
            height: 100%;
        }
        @font-face {
            font-family:mt;
            src: url(./css/mzd.ttf);
        }

        body{
            background-color: cadetblue;
        }
        #page{
            background-color: white;
            width: 1191px;
            height: 1400px;
            margin: auto;
        }
        #header{
            height: 138px;
            background-image: url(./img/banel_b.jpg);
            font-family: mt;
            font-size: 70px;
            line-height: 138px;
            color: aliceblue;
            padding-left: 100px;
        }
        #menubar{
            height: 38px;
            background: url(./img/bar_1px.jpg);
        }
        #menubar a{
            color: white;
            text-decoration: none;
        }
        #left{
            padding-left: 20px;
            line-height: 35px;
          
        }
        #left>img{
            /* vertical-align: middle; */
            position: relative;
            top: 7px;
            float: left;
        }
        #left>ul{
            list-style: none;
            float: left;
            margin: 0;
            margin: 0;
            padding: 0;
            text-indent: 0;
            color: white;

        }
        #left>ul>li{
            float: left;
            padding-left: 20px;
        }
        #right{
            float: right;
            line-height: 35px;
            padding-right: 30px;
        }
        #side{
            height: 1224px;
            width: 200px;
            background-color: rgb(111, 191, 245);
        }
        .title{
            background-color: rgb(78, 134, 238);
            color: white;
            text-align: center;
            height: 30px;
            line-height: 30px;
        }
    </style>
</head>
<body>
    <div id="page">
        <!-- ========================页头========================== -->
        <div id="header">
            软件外包服务平台学员博客
        </div>
        <div id="menubar">
          <div id="left">
              <img src="./img/dot.jpg" >
              
<c:choose>
    <c:when test="${sessionScope.userInfo==null }">
              <ul>
                  <li><a href="reg_proto.html">注册</a></li>
                  <li>|</li>
                  <li><a href="Login.jsp">登录</a></li>
              </ul>
    </c:when>
    <c:otherwise>
                 <ul>
                  <li>你好：${sessionScope.userInfo.regName}</li>
                  <li>|</li>
                  <li><a href="/logout">退出</a></li>
              </ul>
     </c:otherwise>
</c:choose>

          </div>
          <div id="right">
<c:if test="${sessionScope.userInfo!=null}">  
   <c:choose>
        
        <c:when test="${sessionScope.userInfo.blog!=null }">
              <a href="/showBlog?blogID=${sessionScope.userInfo.blog.blogID} ">我的博客</a>
         </c:when>
         <c:otherwise>
            
              <a href="/apply_blog.html">申请博客</a>
         </c:otherwise>
   </c:choose>
</c:if>       
          </div>
        </div>
        <!-- ========================主体======================== -->
        <div>
            <div id="side">
                <div class="title">博客分类</div>
                <ul>
                    <li><a href=""></a></li>
                    <li><a href=""></a></li>
                    <li><a href=""></a></li>
                    <li><a href=""></a></li>
                    <li><a href=""></a></li>
                </ul>
                <div class="title">博客排行</div>
                <ul>
                    <li><a href=""></a></li>
                    <li><a href=""></a></li>
                    <li><a href=""></a></li>
                    <li><a href=""></a></li>
                    <li><a href=""></a></li>
                </ul>

            </div>
        </div>


    </div>
    <div>
        总访问数：${applicationScope.accessCount}<br>
        总访问人数: ${peopleCount}<br>
        当前在线人数：${currentCount}<br>
        当前会员人数：${currentLogin }
    </div>
</body>
</html>