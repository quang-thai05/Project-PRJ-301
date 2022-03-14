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
                background-image: url("data:image/jpeg;base64,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");
                display: flex;
                background-repeat: no-repeat;
                background-size: 100%;
                justify-content: center;
                align-items: center;
            }
            .frame{
                border-radius: 10px;
                background-color: #ffffff;
                width: 650px;
                height: 500px;
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
                width: 350px;
                height: 35px;
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
                background-color:rgb(157, 157, 197);
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
            h2{
                margin-top: 10px;
                padding-top: 5px;
            }
            .re{
                margin-top: 30px;
                margin-left: 160px;
                border-radius: 10px;
                background-image: linear-gradient(#ffff66,#66ffff );
            }
        </style>
    </head>
    <body>
            <div class="frame" >
                  <form method="post" action="register">
                <table>
                    <tr>
                        <td><h2>Email</h2></td>
                        <td><input name="email" id="user" type="text" placeholder="enter your email"/></td>
                    </tr>  
                    <tr>
                        <td><h2>Password</h2></td>
                        <td><input id="pass" name="pass" type="password" placeholder="password"/></td>
                    </tr>
                    <tr>
                        <td><h2 style="width:200px;">Re-enter Password </h2></td>
                        <td><input id="repass" name="repass" type="password" placeholder="confirm password"/></td>
                    </tr>
                </table>
                        <td><input class="re" type="submit" value="REGIGSTER">
                <p id="a" style="margin: 0;color: red;"><c:if test="${requestScope.er!=null}">${requestScope.er}</c:if></p>
                 <nav style="display: flex;width: 250px;padding-top: 20px;margin-left: 26%;"></nav>
                 <p style="color: red;margin-left: 210px;width: 200px;" id="h"></p>
                   </form>
                 
            </div>
                 
                 <script>
                      document.getElementsByClassName("re")[0].onclick =function (e){
                         if(document.getElementById("pass").value.trim()===""||document.getElementById("user").value.trim()===""
                                 ||document.getElementById("repass").value.trim()===""){
                             e.preventDefault();
                        document.getElementById("h").innerHTML="fill up informations";}
                     };
                 </script>
    </body>
</html>

