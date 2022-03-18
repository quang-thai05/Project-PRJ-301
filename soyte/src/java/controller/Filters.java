/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.User;
import model.UserDetail;

/**
 *
 * @author quang
 */
public class Filters implements Filter {

   @Override
   public void init(FilterConfig filterConfig) throws ServletException {
   }

   @Override
   public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
      HttpServletRequest httpRequest = (HttpServletRequest) request;
      HttpServletResponse httpResponse = (HttpServletResponse) response;

      HttpSession session = httpRequest.getSession();

      UserDetail u = (UserDetail) session.getAttribute("userdetail");

      if (u == null) {
         httpResponse.sendRedirect("login");
      } else {
         if (u.getRole_id() != 1) {
            httpResponse.sendRedirect("denied.jsp");
         } else if (u.getRole_id() == 1) {
            chain.doFilter(request, response);
         }
      }
   }

   @Override
   public void destroy() {
   }
}
