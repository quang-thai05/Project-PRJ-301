<%-- 
    Document   : login
    Created on : Feb 17, 2022, 7:11:24 PM
    Author     : hoanganhPC
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
                background-image:linear-gradient(
140deg, #EADEDB 0%, #BC70A4 50%, #BFD641 75%);
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
        <form method="post" action="login">
            <div class="frame" >
                <table>
                    <tr >
                        <td><h2>User name:</h2></td>
                        <td><input name="email" id="user" type="text"/></td>
                    </tr>  
                    <tr>
                        <td><h2>Password:</h2></td>
                        <td><input id="pass" name="pass" type="password"/></td>
                    </tr>
                </table>
                <p id="a" style="margin: 0;color: red;"><c:if test="${requestScope.er!=null}">${requestScope.er}</c:if></p>
                <nav style="display: flex;width: 250px;padding-top: 20px;margin-left: 26%;">
                    <input type="submit" value="LOGIN">
                    <button>REGISTER</button>
                    
                </nav>
                <nav style="display: flex;width: 400px;padding-top: 20px;margin-left: 26%;">
                <a href="redeem.jsp">Forgot password</a>
                <a href="#" style="margin-left: 60px;">change password</a></nav>
            </div>
            </form>
    </body>
</html>

