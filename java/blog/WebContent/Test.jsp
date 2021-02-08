<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="/Error.jsp"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  
   
   ${param.userName }
   <c:out value="${param.userName }" default="xxxxxxx"></c:out>
</body>
</html>