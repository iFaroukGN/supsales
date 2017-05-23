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
@WebServlet(name = "UpdateServlet", urlPatterns = {"/auth/update"})
public class UpdateServlet extends HttpServlet {

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
        request.getRequestDispatcher("../"+SupSalesUtils.webfileRoot+"/UserUpdate.jsp").forward(request, response);
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
        String uID = request.getParameter("userId");
        String firstname  = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("pass");
        String phonenumber = request.getParameter("phonenumber");
        String postalnumber = request.getParameter("postalnumber");
        String email = request.getParameter("email");
        String username = request.getParameter("username");

        _aUser = new Users(Long.parseLong(uID),username, password, phonenumber, lastname, firstname, postalnumber, email);
        /*_aUser = new Users();
        _aUser.setID(Long.parseLong(uID));
        _aUser.setUserName(username);
        _aUser.setPassword(password);
        _aUser.setEmail(email);
        _aUser.setFirstName(firstname);
        _aUser.setLastName(lastname);
        _aUser.setPostalAddress(postalnumber);
        _aUser.setPhoneNumber(phonenumber);*/
        
        _aUserDAOBean = new UserDAOBean();
        Users u = _aUserDAOBean.update(_aUser);

        if (u != null) {
            request.setAttribute("msg", SupSalesUtils.MsgUpdateNoError+" "+ u.getUserName());
            //request.getRequestDispatcher(request.getContextPath() + "/MyAccount.jsp").forward(request, response);
            response.sendRedirect(request.getContextPath() + "/auth/account");
        } else {
            request.setAttribute("msg", SupSalesUtils.MsgUpdateError+" ");
            request.getRequestDispatcher(request.getContextPath() + "/MyAccount.jsp").forward(request, response);
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
