<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="./bower_components/jquery/dist/jquery.js"></script>
    <style>
        html,body{
            height: 100%;
            /* background-color: cornflowerblue; */
            display: flex;
            justify-content: center;
            align-items: center;
        }
        #page{
            width: 800px;
            /* background-color: aliceblue; */
            height: 600px;
            
        }
        .red{
            color: red;
        }
        table{
            width: 100%;
            border: solid rgba(4, 75, 122, 0.712) 2px;
            border-collapse: collapse;
            height: 500px;
        }
        td{
            border: solid rgba(4, 75, 122, 0.712) 1px; 
            padding-left: 20px;
            padding-right: 20px;
        }
        tr>td:first-child{
            text-align: right;
            width: 120px;

        }
        .foot{
           display: flex;
           justify-content: center;
        }
        .foot button{
            margin: 20px;
        }
    </style>
</head>
<body>
    <div id="page">
        <form action="/regist" method="POST">
            <table>
                <tr>
                    <th colspan="2" style="height: 38px; background-image: url(./img/bar_1px.jpg);">
                        用户基本信息（<span class="red">*</span>为必填)
                    </th>
                    
                </tr>
                <tr>
                    <td><span class="red">*</span>用户名</td>
                    <td><input type="text" name = "userName" id="userName"></td>
                </tr>
                <tr>
                    <td><span class="red" >*</span>密码</td>
                    <td><input type="password" name = "pwd" id="pwd"></td>
                </tr>
                <tr>
                    <td><span class="red">*</span>确认密码</td>
                    <td><input type="password" id="repeat"></td>
                </tr>
                <tr>
                    <td><span class="red">*</span>email</td>
                    <td><input type="text" name="email" id = "email"></td>
                </tr>
                <tr>
                    <td><span class="red">*</span>密码找回问题</td>
                    <td><input type="text" name="question" id="question"></td>
                </tr>
                <tr>
                    <td><span class="red">*</span>密码找回答案</td>
                    <td><input type="text" name="answer" id="answer"></td>
                </tr>
                <tr>
                    <td><span class="red">*</span>验证码</td>
                    <td><input type="text" name="code" id="code">
                    
                    <%
                        int ran = (int)(Math.random()*10000);
                    	String code = String.valueOf(ran);
                    	session.setAttribute("code", code); // 服务端保存验证码
                    	out.print(code);// 在页面上输出
                    %>
                    <span class="red">
                     <%
                        Object o = request.getAttribute("msg");
                        if(o!=null){
                        	out.print(o);
                        }
                        
                    %>
                    </span>
                   
                    </td>
                </tr>
            </table>
        </form>
        <div class="foot">
            <button onclick="location='reg_proto.html'">上一步</button>
            <button id="nextBtn">下一步</button>
        </div>
    </div>

    <script>
        $(document).ready(function(){
            $("#nextBtn").click(function(){
                document.forms[0].submit();
            });
        });

    </script>
</body>
</html>