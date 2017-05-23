/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jva.supinfo.supsales.Beans;

import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import jva.supinfo.supsales.entities.Product;

/**
 * REST Web Service
 *
 * @author Fairuz
 */
@Path("/supsales")
public class ApiResource {

    private ProductBean _ProductBean;
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ApiResource
     */
    public ApiResource() {
    }

    /**
     * Retrieves representation of an instance of
     * jva.supinfo.supsales.Beans.ApiResource
     *
     * @return an instance of java.util.List
     */
    @GET
    @Path("/getItemByName/{param}")
    @Produces("application/json")
    public List<Product> getJson(@PathParam("param") String itemname) {
        _ProductBean = new ProductBean();
        return _ProductBean.getProductByName(itemname);
    }
    
    @GET
    @Path("/getItemByCategory/{param}")
    @Produces("application/json")
    public List<Product> getCategoryJson(@PathParam("param") String itemCategory) {
        _ProductBean = new ProductBean();
        return _ProductBean.getProductByCategory(itemCategory);
    }

    /**
     * PUT method for updating or creating an instance of ApiResource
     *
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/json")
    public void putJson(List content) {
    }
}
