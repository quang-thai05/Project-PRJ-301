/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.HospitalDBContext;
import dal.UserDetailDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Hospital;
import model.UserDetail;

/**
 *
 * @author quang
 */
public class ChangeHospitalController extends HttpServlet {

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
      HospitalDBContext hosDB = new HospitalDBContext();
      List<Hospital> hospital = hosDB.getAllHospital();
      int id = Integer.parseInt(request.getParameter("id"));
      UserDetail ud = new UserDetailDBContext().getUserDetailByUserId(id);
      request.setAttribute("ud", ud);
      request.setAttribute("hospital", hospital);
      request.getRequestDispatcher("view/change-hospital.jsp").forward(request, response);
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
      int hospital_id = Integer.parseInt(request.getParameter("hospital"));
      int u_id = Integer.parseInt(request.getParameter("u_id"));
      UserDetailDBContext udDB = new UserDetailDBContext();
      udDB.changeHospital(hospital_id, u_id);
      response.sendRedirect("admindoc");
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
