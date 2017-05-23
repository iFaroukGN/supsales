/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jva.supinfo.supsales.DAOBean.UserDAOBean;
import jva.supinfo.supsales.entities.Users;
import jva.supinfo.supsales.utils.SupSalesUtils;

/**
 *
 * @author Fairuz
 */
@WebServlet(name = "RegisterServlet", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private UserDAOBean _aUserDAOBean;
    private Users _aUser;

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
        request.getRequestDispatcher(SupSalesUtils.webfileRoot+"/Register.jsp").forward(request, response);
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
        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String dob = request.getParameter("dob");
        String password = request.getParameter("pass");
        String phonenumber = request.getParameter("phonenumber");
        String postalnumber = request.getParameter("postalnumber");
        String email = request.getParameter("email");
        String username = request.getParameter("username");

        _aUser = new Users(username, password, phonenumber, lastname, firstname, postalnumber, email);

        _aUserDAOBean = new UserDAOBean();
        Users u = _aUserDAOBean.add(_aUser);

        if (u != null) {
            request.setAttribute("msg", SupSalesUtils.MsgRegisterNoError+" "+ u.getUserName());
            response.sendRedirect(request.getContextPath() + "/login");
            System.out.println("add success: "+u.getUserName());
        } else {
            request.setAttribute("msg", SupSalesUtils.MsgRegisterError+" ");
            request.getRequestDispatcher(request.getContextPath() + "/register").forward(request, response);
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
