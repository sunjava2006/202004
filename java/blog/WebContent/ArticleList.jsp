<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>   
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<style>
.article{width:100%; margin-top:5px ; border-top:#06C solid 1px; border-right:white solid 3px;border-left:white solid 3px;}
.title{ font-size:14px; font-weight:bold; background:#9CF; border-bottom:#06c dotted 1px;}
.abs{ font-size:12px;}
.abs a{ font-size:12px; color:red; text-decoration:none}
.info{ text-align:right}
</style>

</head>

<body>
    <div style="border:#069 solid 1px; margin:0px 5px 5px 5px; width:98%; height:100%">
       <label style=" display:block; width:100%;  height:30px; line-height:30px; vertical-align:middle; text-align:left; font-size:14px; background:#069; color:white; "><font style="margin-left:10px;">最新文章</font></label>
        <!-- ------------------------------------------------------------------------->
       <c:forEach items="${list}" var="item">
        <table class="article">
            <tr>
                 <td class="title">${item.title }                 </td>
            </tr>
            <tr>
                 <td class="abs">
                                 <c:out value="${fn:substring(item.content, 0, 20)}"></c:out>
                 <a>阅读全文</a>
                 </td>
            </tr>
            <tr>
                 <td class="info">
                     2015-09-09 13:45 作者：王小光 【评论：${item.reviews.size() }】【阅读：20】               
                 </td>
            </tr>
        </table>
       
       </c:forEach>
       
        

        
    </div>
</body>
</html>
