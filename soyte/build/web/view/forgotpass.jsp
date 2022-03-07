<%-- 
    Document   : login
    Created on : Feb 17, 2022, 7:11:24 PM
    Author     : quangthai
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
                background-color: #0071d1;
                display: flex;
                justify-content: center;
                align-items: center;
            }
            .frame{
                border-radius: 10px;
                background-color: #ffffff;
                width: 100%;
                height: 100%;
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
                width: 90%;
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
        </style>
    </head>
    <body>
            <div class="frame" >
                  <form method="post" action="forgot">
                <table>
                    <tr >
                        <td><h2>Email</h2></td>
                        <td><input name="email" id="user" type="text"/></td>
                    </tr>  
                    <tr >
                        <td><input name="confirm" type="checkbox" value="1"/></td>
                        <td><h4>Are you sure you want to reset your password?</h4></td>
                    </tr>  
                </table>
                <input type="submit" value="FORGOT">
                <p id="a" style="margin: 0;color: red;"><c:if test="${requestScope.er!=null}">${requestScope.er}</c:if></p>
                 <nav style="display: flex;width: 250px;padding-top: 20px;margin-left: 26%;"></nav>
                   </form>
                 <a href="register"><button>REGISTER</button></a>
                <nav style="display: flex;width: 400px;padding-top: 20px;margin-left: 26%;">
                 <a href="/forgot">Forgot password</a>
                <a href="/change" style="margin-left: 60px;">change password</a></nav>
            </div>
    </body>
</html>

