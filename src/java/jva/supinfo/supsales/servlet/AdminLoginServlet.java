/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jva.supinfo.supsales.entities.Users;
import jva.supinfo.supsales.utils.SupSalesUtils;

/**
 *
 * @author Fairuz
 */
@WebServlet(name = "AdminLoginServlet", urlPatterns = {"/admin"})
public class AdminLoginServlet extends HttpServlet {
 
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
         
        request.getRequestDispatcher(SupSalesUtils.webfileRoot + "/admin/Login.jsp").forward(request, response);
        
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

        String username = request.getParameter("username");
        String password = request.getParameter("pass");

        Users login = new Users(username, password);
        Users u = new Users("admin", "admin");

        System.out.println(" username: " + username + " password: " + password);
        
            if (u.equals(login)) {
                request.setAttribute("msg", SupSalesUtils.MsgLoginWithNoError);
                request.getSession().setAttribute(SupSalesUtils.adminUserNameInSession, u.getUserName());
                request.getSession().setAttribute(SupSalesUtils.adminPassInSession, u.getPassword());
                request.getSession().setAttribute("userObj",new Users(u.getID(),u.getUserName(),u.getPassword(),u.getPhoneNumber(),u.getLastName(),u.getFirstName(),u.getPostalAddress(),u.getEmail()));
                System.out.println(" name in session: " + request.getSession().getAttribute(SupSalesUtils.userNameInSession));
                response.sendRedirect(request.getContextPath() + "/a/adminIndex");
                //request.getRequestDispatcher(SupSalesUtils.webfileRoot+"/Index.jsp").forward(request, response);
                return;
            } else if (!(u.equals(login))) {
                request.setAttribute("msg", SupSalesUtils.MsgLoginWithError);
                doGet(request, response);
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
