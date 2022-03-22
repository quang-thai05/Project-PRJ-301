<%-- 
    Document   : Profile
    Created on : Mar 7, 2022, 11:22:18 AM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>Document</title>
      <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
   </head>
   <body>
      <section class="py-5 my-5">
         <div class="container">
            <div class="bg-white shadow rounded-lg d-block d-sm-flex">
               <div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
                  <form action="update-document" method="post" id="form">
                     <div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
                        <h3 class="mb-4">Update document</h3>
                        <p id="a" style="margin: 0;color: red;"><c:if test="${requestScope.er!=null}">${requestScope.er}</c:if></p>
                           <div class="row">
                              <div class="col-md-12">
                                 <div class="form-group">
                                    <label>Document Title</label>
                                    <input type="text" class="form-control" name="name" value="${requestScope.document.doc_name}" readonly="">
                              </div>
                           </div>
                           <div class="col-md-12">
                              <div class="form-group">
                                 <label>Body</label>
                                 <textarea class="form-control" rows="4" form="form" name="text" value="${requestScope.document.doc_text}" readonly="">${requestScope.document.doc_text}</textarea>
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label>Date</label>
                                 <input type="date" class="form-control" name="date" value="${requestScope.document.date}" readonly="">
                              </div>
                           </div>
                        </div>
                        <div>
                           <a href="home">HOME</a>
                        </div>
                     </div>
                  </form>
               </div>
            </div>
         </div>
      </section>


      <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
      <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
      <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
   </body>
</html>