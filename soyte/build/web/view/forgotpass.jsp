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
                background-image: linear-gradient(#9999ff,#9999ff,#66ccff);
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .d{
                border-radius: 10px;
                background-color: whitesmoke;
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
                <form method="post" action="forgot" class="d">
                <div style="display: flex;">
                    <h2 style="margin-top: 70px;">Your email</h2><input type="text" name="email" placeholder="enter your email" style="margin-top: 70px;border-radius: 8px;"/>   
                </div>
                <div style="display: flex;">
                    <input type="checkbox" name="confirm" value="1" style="width: 18px;margin-top: 30px;margin-left: 150px;"/>
                    <p style="margin-top: 30px;">Are you sure you want to reset your password?</p>
                </div>
                <input type="submit" value="submit" name="submit" style="margin-left: 80px;width: 70%;"/>
                <p id="a" style="margin: 0;color: red;"><c:if test="${requestScope.er!=null}">${requestScope.er}</c:if></p>
                <div style="display: flex;margin-top: 30px;">
                    <a style="margin-left: 170px;margin-right: 50px;" href="login">return login</a>
                <a href="register">return register</a>         
                </div>
                <p style="color:red;margin-top: 30px;" id="h"></p>
            </form>
                 <script>
                     document.getElementsByName("submit")[0].onclick =function (e){
                         if(document.getElementsByName("email")[0].value.trim()===""||document.getElementsByName("1")[0].checked===false){
                             e.preventDefault();
                        document.getElementById("h").innerHTML="fill up information and confirm";}
                     };
                 </script>
    </body>
</html>

