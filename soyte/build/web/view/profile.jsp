<%-- 
    Document   : Profile
    Created on : Mar 7, 2022, 11:22:18 AM
    Author     : hoanganhPC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Profile</title>
    </head>
    <body>
        <style>
            html,body{
                width: 98vw;
                height: 98vh;
                background-color: #6699ff;
                overflow-y: hidden;
            }
            img{
                border-radius: 60%;
                width: 250px;
                height: 250px;
                margin-bottom: 20px;
            }
        </style>
        <% // if(request.getAttribute("profile")==null) response.sendRedirect("profile.jsp");%>
            <div style="display: flex;margin-top: 50px;margin-left: 50px;">
                <div>
                    <img src="images/${u.image}"/>
                   <br/> <a href="update" style="margin-left: 90px;background-color: #ffff00;text-decoration: none;padding: 10px 15px;">update</a>
                </div>
            <div style="margin-left: 20px;">
                <h1>${u.user_name}</h1>
                <h1>${u.date_of_birth}</h1>
                <h1>${u.address}</h1>
                <h1>${u.phone}</h1>
            </div>  
        </div>
    </body>
</html>
