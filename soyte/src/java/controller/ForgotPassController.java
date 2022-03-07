/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.SendMail;
import dal.UserDBContext;
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
public class ForgotPassController extends HttpServlet {

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
        request.getRequestDispatcher("view/forgotpass.jsp").forward(request, response);
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
        String confirm = request.getParameter("confirm");
        UserDBContext uDAO = new UserDBContext();
        User u = uDAO.getUserByEmail(email);
        SendMail sm = new SendMail();
        String error = "";
        if (confirm != null) {
            if (u != null) {
                String newpass = uDAO.generateRandomPassword();
                uDAO.changePass(newpass, u.getId());
                sm.sentEmail(email, "Nghe An health service department", "Your new password is: " + newpass);
                error = "Your password has been reset, to to email to get your new password!";
                request.setAttribute("er", error);
                request.getRequestDispatcher("view/forgotpass.jsp").forward(request, response);
            } else {
                error = "User not found!";
                request.setAttribute("er", error);
                request.getRequestDispatcher("view/forgotpass.jsp").forward(request, response);
            }
        } else {
            error = "You have to confirm before reset password!";
            request.setAttribute("er", error);
            request.getRequestDispatcher("view/forgotpass.jsp").forward(request, response);
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
