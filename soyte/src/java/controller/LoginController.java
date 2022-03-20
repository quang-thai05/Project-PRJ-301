/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.UserDBContext;
import dal.UserDetailDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import model.UserDetail;

/**
 *
 * @author quang
 */
public class LoginController extends HttpServlet {

   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
   /**
    * Handles the HTTP <code>GET</code> method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      HttpSession session = request.getSession();
      User u = (User) session.getAttribute("account");
      if (u != null) {
         response.sendRedirect("home");
      } else {
         request.getRequestDispatcher("view/login1.jsp").forward(request, response);
      }
   }

   /**
    * Handles the HTTP <code>POST</code> method.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   @Override
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      String email = request.getParameter("email");
      String pass = request.getParameter("pass");
      String error = "";
      int count = 0;
      UserDBContext userDB = new UserDBContext();
      UserDetailDBContext udDB = new UserDetailDBContext();
      List<User> userList = userDB.getUsers();

      for (User u : userList) {
         if (u.getEmail().equals(email)) {
            if (u.getPassword().equals(pass)) {
               if (u.isActive()) {
                  UserDetail ud = udDB.getUserDetailByUserId(u.getId());
                  HttpSession session = request.getSession();
                  session.setAttribute("account", u);
                  session.setAttribute("userdetail", ud);
                  response.sendRedirect("home");
               } else {
                  error = "Account isn't active, please active!";
                  request.setAttribute("er", error);
                  request.getRequestDispatcher("view/active.jsp").forward(request, response);
               }
            } else {
               error = "Wrong password!";
               request.setAttribute("er", error);
               request.getRequestDispatcher("view/login1.jsp").forward(request, response);
            }
            count++;
         }
      }
      
      if (count == 0) {
         error = "User not found!";
         request.setAttribute("er", error);
         request.getRequestDispatcher("view/login1.jsp").forward(request, response);
      }
   }

   /**
    * Returns a short description of the servlet.
    *
    * @return a String containing servlet description
    */
   @Override
   public String getServletInfo() {
      return "Short description";
   }// </editor-fold>

}
