<%-- 
    Document   : admindoctor
    Created on : Mar 12, 2022, 9:56:53 PM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                  <h4 class="text-center mb-4">Doctor List</h4>
                  <div class="table-wrap">
                     <table class="table">
                        <thead class="thead-primary">
                           <tr>
                              <th>Name</th>
                              <th>Date of birth</th>
                              <th>Address</th>
                              <th>Phone</th>
                              <th>Update</th>
                           </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${requestScope.list2}" var="l2">
                              <tr>
                                 <th scope="row" class="scope" >${l2.user_name}</th>
                                 <td>${l2.date_of_birth}</td>
                                 <td>${l2.address}</td>
                                 <td>${l2.phone}</td>
                                 <td><a href="uptopatient?id=${l2.user_id}" class="btn btn-primary">To patient</a>&nbsp;<a href="change-hospital?id=${l2.user_id}" class="btn btn-primary">Change hospital</a></td>
                              </tr>
                           </c:forEach>
                        </tbody>
                     </table>
                  </div>
               </div>
            </div>

            <div class="row">
               <div class="col-md-12">
                  <h4 class="text-center mb-4">Patient List</h4>
                  <div class="table-wrap">
                     <table class="table">
                        <thead class="thead-primary">
                           <tr>
                              <th>Name</th>
                              <th>Date of birth</th>
                              <th>Address</th>
                              <th>Phone</th>
                              <th>Update to doctor</th>
                           </tr>
                        </thead>
                        <tbody>
                           <c:forEach items="${requestScope.list3}" var="l3">
                              <tr>
                                 <th scope="row" class="scope" >${l3.user_name}</th>
                                 <td>${l3.date_of_birth}</td>
                                 <td>${l3.address}</td>
                                 <td>${l3.phone}</td>
                                 <td>
                                    <a href="uptodoc?id=${l3.user_id}" class="btn btn-primary">Update</a>
                                 </td>
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

