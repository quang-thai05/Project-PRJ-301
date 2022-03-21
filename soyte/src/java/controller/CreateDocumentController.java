/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.DocumentDBContext;
import dal.HospitalDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Document;
import model.Hospital;

/**
 *
 * @author quang
 */
public class CreateDocumentController extends HttpServlet {

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
      HospitalDBContext hosDB = new HospitalDBContext();
      ArrayList<Hospital> list = hosDB.getAllHospital();
      request.setAttribute("hospital", list);
      request.getRequestDispatcher("view/create-document.jsp").forward(request, response);
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
      String title = request.getParameter("name");
      String body = request.getParameter("text");
      String h_id = request.getParameter("hospital");
      String sDate = request.getParameter("date");
      String error = "";

      if (title.length() == 0 || body.length() == 0 || h_id.length() == 0 || sDate.length() == 0) {
         error = "Info is null!";
         request.setAttribute("er", error);
         request.getRequestDispatcher("view/create-document.jsp").forward(request, response);
      } else {
         int id = Integer.parseInt(h_id);
         Date date = Date.valueOf(sDate);
         Document d = new Document(title, body, date, id);
         DocumentDBContext docDB = new DocumentDBContext();
         docDB.createDocument(d);
         response.sendRedirect("list-document");
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
