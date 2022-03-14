<%-- 
    Document   : login
    Created on : Feb 17, 2022, 7:11:24 PM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Login</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <style>
            body{
                height: 97vh;
                width: 98vw;
                display: flex;
                justify-content: center;
                align-items: center;
                background-color: #31b0d5;
            }
            .frame{
                border-radius: 10px;
                background-color: #ffffff;
                width: 550px;
                height: 400px;
                display: flex;
                flex-direction: column;
            }
            form{
                width: 40%;
                height: 55%;  
            }

            h2{
                width: 130px;
                margin-left: 20px;
            }
            table{
                margin-top: 45px;
            }
            tr td:nth-of-type(1){
                width: 20%;
            } 
            input{
                width: 300px;
                height: 30px;
            }
            td{
                padding-top: 15px;
            }
            button{
                text-decoration: none;
                color: black;
                display: flex;
                justify-content: center;
                align-items: center;
                height: 30px;
                width: 80px;
                background-color: rgb(66, 66, 247);
                margin-left: 120px;
            }
            button:hover{
                background-color: rgb(157, 157, 197);
            }
            button:nth-of-type(1){
                margin-right: 100px;
            }
            p{
                margin: 0;
                padding: 0;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            #id{
                display: none;
            }
            .login{
                background-color: rgb(66, 66, 247);
              width: 80px;  
              margin-left: 157px;
              margin-top: 12px;
            }
            .reg{
                width: 80px;
                text-decoration: none;
                margin-top: 10px;
                margin-left: 340px;
            }
            .reg button{
                margin: 0;
            }
        </style>
    </head>
    <body>
            <div class="frame" >
                  <form method="post" action="login">
                <table>
                    <tr >
                        <td><h2>Email</h2></td>
                        <td><input name="email" id="user" type="text"/></td>
                    </tr>  
                    <tr>
                        <td><h2>Password</h2></td>
                        <td><input id="pass" name="pass" type="password"/></td>
                    </tr>    
                </table>
                      <input class="login" type="submit" value="LOGIN">
                <p id="a" style="margin: 0;color: red;"><c:if test="${requestScope.er!=null}">${requestScope.er}</c:if></p>
                 <nav style="display: flex;width: 250px;padding-top: 20px;margin-left: 26%;"></nav>
                   </form>
                 <a class="reg" href="register"><button>REGISTER</button></a>
                <nav style="display: flex;width: 400px;padding-top: 20px;margin-left: 29%;">
                 <a href="forgot">Forgot password</a>
                <a href="change" style="margin-left: 70px;">change password</a></nav>
                <p style="color:red ;margin-top: 30px;margin-left: 15px;" id="h"></p>
            </div>
                 <script>
                     document.getElementsByClassName("login")[0].onclick =function (e){
                         if(document.getElementById("pass").value.trim()===""||document.getElementById("user").value.trim()===""){
                             e.preventDefault();
                        document.getElementById("h").innerHTML="fill up information";}
                     };
                 </script>
    </body>
</html>

