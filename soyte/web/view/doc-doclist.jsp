<%-- 
    Document   : admindoctor
    Created on : Mar 12, 2022, 9:56:53 PM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!DOCTYPE html>
<html lang="en">
   <head>
      <title>Table 03</title>
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <link href='https://fonts.googleapis.com/css?family=Roboto:400,100,300,700' rel='stylesheet' type='text/css'>

      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

      <link rel="stylesheet" href="css/style1.css">

   </head>
   <body>
      <section class="ftco-section">
         <div class="container">
            <div class="row justify-content-center">
               <div class="col-md-6 text-center mb-5">
                  <h2 class="heading-section"><a href="home">Home</a></h2>
               </div>
            </div>
            <div class="row">
               <div class="col-md-12">
                  <h4 class="text-center mb-4">Document List</h4>
                  <div class="table-wrap">
                     <table class="table">
                        <thead class="thead-primary">
                           <tr>
                              <th>Title</th>
                              <th>Hospital</th>
                              <th>Date</th>
                              <th>Detail</th>
                           </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${requestScope.document}" var="l">
                              <tr>
                                 <th scope="row" class="scope" >${l.doc_name}</th>
                                 <td>${l.hospital_name}</td>
                                 <td>${l.date}</td>
                                 <td><a href="view-document?id=${l.id}" class="btn btn-primary">View detail</a></td>
                              </tr>
                           </c:forEach>
                        </tbody>
                     </table>
                  </div>
               </div>
            </div>
         </div>
      </section>

      <script src="js/jquery.min.js"></script>
      <script src="js/popper.js"></script>
      <script src="js/bootstrap.min.js"></script>
      <script src="js/main.js"></script>

   </body>
</html>

