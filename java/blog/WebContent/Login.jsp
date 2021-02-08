<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

	
	<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
</head>
    <style>
        html, body{
            height: 100%;
            background-color: gainsboro;
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #page{
            width: 600px;
            height: 400px;
            background-color: rgb(103, 186, 241);
        }
        table{
            width: 500px;
            margin: auto;
        }
        .red{
           color:red;
        }
    </style>
<body>
    <div id="page">
        <h1>用户登录</h1>
        <form action="/login" method="POST">
            <table>
                <tr>
                    <td rowspan="3">
                        <img src="./img/logon.jpg" alt="">
                    </td>
                    <td>用户名</td>
                    <td><input type="text" name="userName" id="userName"></td>
                    <td></td>
                </tr>
                <tr>
                    
                    <td>密码</td>
                    <td><input type="password" name="pwd" id="pwd" value="123456"></td>
                    <td></td>
                </tr>
                <tr>
                   
                    <td>验证码</td>
                    <td><input type="text" name="code" id="code"></td>
                    <td>
                        <img src="/Code" alt="验证码">
    
                    </td>
                </tr>
                <tr>
                   
                    <td colspan="2">
                           <%--
                                 Object o = request.getAttribute("msg");
                                 if(o!=null){
                                	 out.print(o);
                                 }
                           --%>
                           
                           <%--=request.getAttribute("msg")==null?"": request.getAttribute("msg")--%>
                           
                         <span class="red"> ${msg}</span> 
                    </td>
                    <td colspan="2">
                    
                        10天免登录<input type="checkbox" name="autoLogin">
                    
                        <input type="submit" value="登录"></input>
                    </td>
                </tr>
            </table>
        </form>
       

    </div>
</body>
</html>


	   
	
