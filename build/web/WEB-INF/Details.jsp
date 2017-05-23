<%-- 
    Document   : Details
    Created on : 1 févr. 2017, 19:02:55
    Author     : Fairuz
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Header.jsp"%>

<c:forEach items="${product.getListProductById(itemId)}" var="item" >

    <div class="jumbotron container">
        <div class="row">
            <div class="col-lg-2"></div>
            <div class="col-lg-8">
                <div class="card">

                    <div class="card-height-indicator"></div>
                    <div class="card-content">

                        <div class="card-image">
                            <img src="/uploadFiles/${item.getProductPicture()}" alt="Loading image...">
                            <h3 class="card-image-headline">${item.getProductName()}</h3>
                        </div>

                        <div class="card-body" >
                            <p class="text-primary">${item.getProductPrice()} <i class="material-icons">euro_symbol</i></p>

                            <div class="list-group-separator"></div>
                            <p >${item.getProdutDescription()}</p>
                        </div>
                        <footer class="card-footer">
                            <div class="list-group col-lg-7"></div>
                            <div class="list-group col-lg-5">
                                <div class="list-group-item">
                                    <div class="row-picture">
                                        <img class="circle" src="http://lorempixel.com/56/56/people/1" alt="icon">
                                    </div>
                                    <div class="row-content ">
                                        <h4 class="list-group-item-heading"> <span class="text-primary">Publier par :</span> ${item.getPublishedByUser().getUserName()}</h4>
                                        <div class="list-group-separator"></div>
                                    </div>
                                </div>
                            </div>
                        </footer>
                        <div><br></div>
                    </div>
                </div>
            </div>
            <div class="col-lg-2"></div>
        </c:forEach>
    </div>
</div>
<%@include file="Footer.jsp"%>   