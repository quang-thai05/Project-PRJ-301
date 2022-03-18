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
import javax.servlet.http.HttpSession;
import model.User;
import model.UserDetail;

/**
 *
 * @author quang
 */
public class ChangePasswordController extends HttpServlet {

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
      request.getRequestDispatcher("view/changepass.jsp").forward(request, response);
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
      String pass = request.getParameter("oldpass");
      String newpass = request.getParameter("newpass");
      String renewpass = request.getParameter("renewpass");
      String error = "";

      UserDBContext uDAO = new UserDBContext();
      UserDetailDBContext udDAO = new UserDetailDBContext();
      User u = uDAO.getUserByEmail(email);

      if (u != null) {
         if (pass.equals(u.getPassword())) {
            if (newpass.equals(renewpass)) {
               uDAO.changePass(newpass, u.getId());
               UserDetail ud = udDAO.getUserDetailByUserId(u.getId());
               HttpSession session = request.getSession();
               session.setAttribute("account", u);
               session.setAttribute("userdetail", ud);
               response.sendRedirect("home");
            } else {
               error = "Confirm password is wrong!";
               request.setAttribute("er", error);
               request.getRequestDispatcher("view/changepass.jsp").forward(request, response);
            }
         } else {
            error = "Current password is wrong!";
            request.setAttribute("er", error);
            request.getRequestDispatcher("view/changepass.jsp").forward(request, response);
         }
      } else {
         error = "Email not found!";
         request.setAttribute("er", error);
         request.getRequestDispatcher("view/changepass.jsp").forward(request, response);
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
