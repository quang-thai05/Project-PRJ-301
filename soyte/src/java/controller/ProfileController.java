/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProfileDBContext;
import dal.UserDetailDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
public class ProfileController extends HttpServlet {

   /**
    * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
    * methods.
    *
    * @param request servlet request
    * @param response servlet response
    * @throws ServletException if a servlet-specific error occurs
    * @throws IOException if an I/O error occurs
    */
   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
           throws ServletException, IOException {
      response.setContentType("text/html;charset=UTF-8");

   }

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
      response.setContentType("text/html;charset=UTF-8");
      request.setCharacterEncoding("utf-8");
      HttpSession session = request.getSession();
      User u = (User) session.getAttribute("account");
      UserDetailDBContext udDAO = new UserDetailDBContext();
      UserDetail ud = udDAO.getUserDetailByUserId(u.getId());
      request.setAttribute("u", ud);
      request.getRequestDispatcher("view/profile.jsp").forward(request, response);
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
      response.setContentType("text/html;charset=UTF-8");
      request.setCharacterEncoding("utf-8");
      String name = request.getParameter("name");
      String address = request.getParameter("address");
      String phone = request.getParameter("phone");
      String date = request.getParameter("date");

      String msg = "";

      if (name.length() == 0 || address.length() == 0 || phone.length() == 0 || date.length() == 0) {
         msg = "Fill up data!";
         request.setAttribute("er", msg);
         request.getRequestDispatcher("view/profile.jsp").forward(request, response);
      } else {
         Date date2 = Date.valueOf(date);
         UserDetail ud = new UserDetail(name, date2, address, phone, "image.jpg", 0, 3);
         UserDetailDBContext udDAO = new UserDetailDBContext();
         HttpSession session = request.getSession();
         User u = (User) session.getAttribute("account");
         udDAO.updateUserDetail(ud, u.getId());
         msg = "Update successfully";
         session.setAttribute("userdetail", ud);
         session.setAttribute("er", msg);
//            request.getRequestDispatcher("view/profile.jsp").forward(request, response);
         response.sendRedirect("profile");
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
