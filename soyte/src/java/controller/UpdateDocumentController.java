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
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Document;
import model.Hospital;

/**
 *
 * @author quang
 */
public class UpdateDocumentController extends HttpServlet {

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
      List<Hospital> hlist = new HospitalDBContext().getAllHospital();
      request.setAttribute("hospital", hlist);
      int id = Integer.parseInt(request.getParameter("id"));
      HttpSession session = request.getSession();
      session.setAttribute("id", id);
      Document d = new DocumentDBContext().getDocumentById(id);
      request.setAttribute("document", d);
      request.getRequestDispatcher("view/edit-document.jsp").forward(request, response);
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
      String text = request.getParameter("text");
      String shid = request.getParameter("hospital");
      String sDate = request.getParameter("date");
      String error = "";

      if (title.length() == 0 || text.length() == 0 || shid.length() == 0 || sDate.length() == 0) {
         error = "Info is null!";
         request.setAttribute("er", error);
         request.getRequestDispatcher("view/create-document.jsp").forward(request, response);
      } else {
         Document d = new Document(title, text, Date.valueOf(sDate), Integer.parseInt(shid));
         HttpSession session = request.getSession();
         int id = (int) (session.getAttribute("id"));

         new DocumentDBContext().updateDocument(d, id);
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
