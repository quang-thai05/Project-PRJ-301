<%-- 
    Document   : Changepass
    Created on : Feb 25, 2022, 7:16:16 AM
    Author     : quang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change Password</title>
    </head>
    <body>
        <style>
            html,body{
                height: 100vh;
                width: 100vw;
                overflow: hidden;
            }
            form{
                display: flex;
                justify-content: center;
                align-items: center;
                width: 100%;
                height: 100%;
                background-image: url("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQcOBo_3RO7-VcS9ikjEldkdEJRN5wMC2xa9g&usqp=CAU");
                background-repeat: no-repeat;
                background-size: 100%;
            }
            table{
                background-color: white;
                width: 500px;
                border-radius: 10px;
                padding-left: 25px;
                
            }
            input{
                height: 30px;
                width: 250px;
                margin-top: 20px;
                border-radius: 5px;
            }
            </style>
            <form action="change" method="post"> 
            <table>
                <tr>
                    <td>email:</td>
                    <td><input name="email" type="text" placeholder="enter your email"/></td>
                </tr>
             <tr>
                    <td>old password:</td>
                    <td><input name="oldpass" type="password" placeholder="old password"/></td>
                </tr>
                <tr>
                    <td>new password:</td>
                    <td><input name="newpass" type="password" placeholder="new password"/></td>
                </tr>
                <tr>
                    <td>confirm password:</td>
                    <td><input name="renewpass" type="password" placeholder="confirm password"/></td>
                </tr>
                <tr>
                    <td></td>
                    <td><button style="width:90px;background-color: #66ffff;height: 30px;margin-top: 10px;border-radius: 5px;" class="save">save</button></td>
                </tr>
                <tr>
                    <td></td>
                    <td style="color: red;"><c:if test="${er!=null}">${er}</c:if><c:if test="${er==null}"><p id="h"></p></c:if></td><!-- nếu thông tin không đúng out ra lỗi(sử lý bên servlet)-->
                </tr>
            </table>
        </form>
                
    </body>
    <script>
        document.getElementsByClassName("save")[0].onclick =function (e){
            if(document.getElementsByName("oldpass")[0].value.trim()===""||document.getElementsByName("newpass")[0].value.trim()===""||
               document.getElementsByName("renewpass")[0].value.trim()===""||document.getElementsByName("email")[0].value.trim()===""){
           e.preventDefault();
           
           document.getElementById("h").innerHTML="fill up informations";
            }
        };
    </script>
</html>
