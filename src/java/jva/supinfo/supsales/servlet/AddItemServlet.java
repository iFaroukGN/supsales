/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jva.supinfo.supsales.DAOBean.ProductDAOBean;
import jva.supinfo.supsales.entities.Category;
import jva.supinfo.supsales.entities.Product;
import jva.supinfo.supsales.entities.Users;
import jva.supinfo.supsales.utils.SupSalesUtils;
import jva.supinfo.supsales.utils.UploadImg;

/**
 *
 * @author Fairuz
 */
@MultipartConfig
@WebServlet(name = "AddItemServlet", urlPatterns = {"/auth/addItem"}, initParams = {
    @WebInitParam(name = "chemin", value = "C:\\apache-tomcat-8.0.14\\webapps\\uploadFiles/")})
public class AddItemServlet extends HttpServlet {

    private Product _aProduct;
    private ProductDAOBean _productDaoBean;
    public static final String ATT_FICHIER = "fichier";
    public static final String ATT_FORM = "form";

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
        request.getRequestDispatcher("../" + SupSalesUtils.webfileRoot + "/AddItem.jsp").forward(request, response);
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

        /*
         * Lecture du paramètre 'chemin' passé à la servlet via la déclaration
         * dans le web.xml
         */
        String chemin = this.getServletConfig().getInitParameter("chemin");

        String prodName = request.getParameter("itemname");

        Double prodPrice = 0.0; // default value
        if (request.getParameter("itemprice") != null) {
              prodPrice = Double.parseDouble(request.getParameter("itemprice"));
        }
      
        String prodDescription = request.getParameter("itemdescription");
        // String prodPicture = request.getParameter("itempicture");
        String prodCategory = request.getParameter("itemcategory");
        Users prodUser = (Users) request.getSession().getAttribute("userObj");

        LocalDate todayDate = LocalDate.now();

        Date publishDate = java.sql.Date.valueOf(todayDate);

        Category category = new Category(prodCategory);
        String prodPicture = "no file";

        _aProduct = new Product(prodName, prodDescription, prodPrice, prodPicture, publishDate, category, category, prodUser);

        _productDaoBean = new ProductDAOBean();

        /* Préparation de l'objet formulaire */
        UploadImg form = new UploadImg(_aProduct);

        /* Traitement de la requête et récupération du bean en résultant */
        Product p = form.enregistrerFichier(request, chemin);

        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute(ATT_FORM, form);
        request.setAttribute(ATT_FICHIER, p);

        Product prod = _productDaoBean.add(_aProduct);

        if (prod
                != null) {
            request.setAttribute("msg", SupSalesUtils.MsgSuccesAdd);
            response.sendRedirect(request.getContextPath() + "/listItems");
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
