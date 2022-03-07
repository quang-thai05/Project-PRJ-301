/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dal.ProfileDBContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.UserDetail;

/**
 *
 * @author hoanganhPC
 */
@WebServlet(name = "Updateprofile", urlPatterns = {"/update"})
@MultipartConfig
public class Updateprofile extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Updateprofile</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Updateprofile at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        if(request.getSession().getAttribute("userdetail")!=null){
        ProfileDBContext d=new ProfileDBContext();
        UserDetail u=d.getDetailbyid(((UserDetail)request.getSession().getAttribute("userdetail")).getUser_id());//lấy id trên session để out ra userdetail
        if(u==null)
         response.sendRedirect("home");
        else{
            if(!mess.trim().equals("")){
                request.setAttribute("er", mess);
                mess="";
            }
        request.setAttribute("profile", u);
        request.getRequestDispatcher("profile.jsp").forward(request, response);}
        }
        else{
            // nếu cần thì có 1 biến  lấy string lỗi đưa vào trang home
            response.sendRedirect("home");
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
       String u =request.getParameter("name");
       String a =request.getParameter("address");
       String p =request.getParameter("phone");
       String d =request.getParameter("date");
       Part part=request.getPart("file");
       if(request.getSession().getAttribute("userdetail")!=null){
      if(!u.trim().equals("")&&!a.trim().equals("")&&!p.trim().equals("")&&!d.trim().equals("")&&checkDate(d)){
          String image =null;
          if(part!=null&&!part.getSubmittedFileName().trim().equals("")){// read file from user to project
              image=part.getSubmittedFileName();
              File f=new File(request.getServletContext().getRealPath("images")+ "\\"+image);
              if(!f.exists()){
                  f.createNewFile();
              FileOutputStream fos=new FileOutputStream(f);
              InputStream i=part.getInputStream();
              int t;
              while((t=i.read())>-1){
                  fos.write(t);
              }
              i.close();fos.close();
              }
          }
          if(image==null||image.trim().equals(""))
              image=((UserDetail)request.getSession().getAttribute("userdetail")).getImage();
          ProfileDBContext db=new ProfileDBContext();
          try{
          db.updateprofile(new UserDetail(((UserDetail)request.getSession().getAttribute("userdetail")).getUser_id(), 
                  u, Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").parse(d).toString()), a, p, image));
          }catch(ParseException e){
              Logger.getLogger(Updateprofile.class.getName()).log(Level.SEVERE, null, e);
              response.sendRedirect("home");
          }
      }
      else if(d!=null&&!d.trim().equals("")&&!checkDate(d)){
          mess="format incorrect!";
          response.sendRedirect("update");
      }
      else{
       mess="fill up informations!";
          response.sendRedirect("update");   
      }
       }
       else response.sendRedirect("home");
    }
    String mess ="";
private boolean checkDate(String date) {
        if (date.equals("") || date == null) {
            return false;
        }
        return Pattern.matches("^(0[1-9]|[1-9]|[1-2][0-9]|3[0-1])-(0[1-9]|1[0-2]|[1-9])-([\\d]{4})$", date);
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
