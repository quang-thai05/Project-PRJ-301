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
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;

/**
 *
 * @author quang
 */
public class ActiveController extends HttpServlet {

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
      String error = "Your account hasn't active yet, please enter OTP in email to active!";
      request.setAttribute("er", error);
      request.getRequestDispatcher("view/active.jsp").forward(request, response);
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
      String OTP = request.getParameter("otp");
      String error = "";

      UserDBContext userDB = new UserDBContext();
      User user = userDB.getUserByEmail(email);
      if (user != null) {
         if (OTP.equals(user.getOTP())) {
            userDB.active(user.getId());
            error = "Active successful!";
            request.setAttribute("er", error);
            request.getRequestDispatcher("view/active.jsp").forward(request, response);
         } else {
            error = "OTP is wrong!";
            request.setAttribute("er", error);
            request.getRequestDispatcher("view/active.jsp").forward(request, response);
         }
      } else {
         error = "User not found!";
         request.setAttribute("er", error);
         request.getRequestDispatcher("view/active.jsp").forward(request, response);
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
