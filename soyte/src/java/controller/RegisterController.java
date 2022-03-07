/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.SendMail;
import dal.UserDBContext;
import dal.UserDetailDBContext;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.User;
import model.UserDetail;

/**
 *
 * @author quangthai
 */

public class RegisterController extends HttpServlet {

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
        request.getRequestDispatcher("view/register.jsp").forward(request, response);
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
        String type = request.getParameter("type");
        String email = request.getParameter("email");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String error = "";
        UserDBContext uDAO = new UserDBContext();
        UserDetailDBContext udDAO = new UserDetailDBContext();
        User u = uDAO.getUserByEmail(email);
        SendMail sm = new SendMail();

        if (u != null) {
            error = "This email has been use, please enter again!";
            request.setAttribute("er", error);
            request.getRequestDispatcher("view/register.jsp").forward(request, response);
        } else {
            if (!pass.equals(repass)) {
                error = "Confirm password fail, please enter again!";
                request.setAttribute("er", error);
                request.getRequestDispatcher("view/register.jsp").forward(request, response);
            } else {
                User user = new User();
                user.setEmail(email);
                user.setPassword(pass);
                if (type.equals("admin") || type.equals("doctor")) {
                    user.setActive(false);
                    if (type.equals("admin")) {
                        user.setRole_id(1);
                    } else {
                        user.setRole_id(2);
                    }
                    user.setOTP(uDAO.generateOTP());
                    sm.sentEmail(email, "Nghe An health service department", "Your OTP is: " + user.getOTP());
                } else {
                    user.setActive(true);
                    user.setRole_id(3);
                }
                uDAO.createUser(user);
                udDAO.createUserDetail(new UserDetail());
            }
            request.setAttribute("email", email);
            if(type.equals("patient")){
                request.getRequestDispatcher("view/login.jsp").forward(request, response);
            }else{
                request.getRequestDispatcher("view/active.jsp").forward(request, response);
            }
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
