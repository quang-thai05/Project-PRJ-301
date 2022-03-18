<%-- 
    Document   : Profile
    Created on : Mar 7, 2022, 11:22:18 AM
    Author     : quang
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
   <head>
      <meta charset="UTF-8">
      <title>Change hospital</title>
      <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
      <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
      <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
      <link rel="stylesheet" type="text/css" href="css/style.css">
   </head>
   <body>
      <section class="py-5 my-5">
         <div class="container">
            <div class="bg-white shadow rounded-lg d-block d-sm-flex">
               <div class="profile-tab-nav border-right">
                  <div class="p-4">
                     <div class="img-circle text-center mb-3">
                        <img src="images/img/user2.jpg" alt="Image" class="shadow">
                     </div>
                     <h4 class="text-center">${requestScope.ud.user_name}</h4>
                  </div>
               </div>
               <div class="tab-content p-4 p-md-5" id="v-pills-tabContent">
                  <form action="change-hospital" method="post">
                     <div class="tab-pane fade show active" id="account" role="tabpanel" aria-labelledby="account-tab">
                        <h3 class="mb-4">Account Information</h3>
                        <p id="a" style="margin: 0;color: red;">
                           <c:if test="${requestScope.er != null}">${requestScope.er}</c:if>
                        </p>
                           <div class="row">
                              <div class="col-md-6">
                                 <div class="form-group">
                                    <label>User Name</label>
                                    <input type="text" class="form-control" value="${requestScope.ud.user_name}" name="name" readonly="">
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label>Address</label>
                                 <input type="text" class="form-control" value="${requestScope.ud.address}" name="address" readonly="">
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label>Phone</label>
                                 <input type="text" class="form-control" value="${requestScope.ud.phone}" name="phone" readonly="">
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label>BirthDay</label>
                                 <input type="date" class="form-control" value="${requestScope.ud.date_of_birth}" name="date" readonly="">
                              </div>
                           </div>
                           <input type="hidden" value="${requestScope.ud.user_id}" name="u_id">
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label>Recent Hospital</label>   
                                 <input type="text" class="form-control" value="${requestScope.honame}" name="address" readonly="">
                              </div>
                           </div>
                           <div class="col-md-6">
                              <div class="form-group">
                                 <label>New Hospital</label><br>
                                 <select name="hospital">
                                    <c:forEach items="${requestScope.hospital}" var="h">
                                       <option value="${h.id}">${h.name}</option>
                                    </c:forEach>
                                 </select>
                              </div>
                           </div>
                        </div>
                        <div>
                           <input type="submit" value="UPDATE">
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