<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Index
    Created on : 26 janv. 2017, 12:27:10
    Author     : Fairuz
--%>

<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
<div class="jumbotron container">


    <c:forEach items="${product.getListProduct()}" var="item" >

        <div class="row">

            <div class="col-lg-4">
                <div class="card">

                    <div class="card-height-indicator"></div>

                    <div class="card-content">

                        <div class="card-image">
                            <img src="/uploadFiles/${item.getProductPicture()}" alt="Loading image...">
                            <h3 class="card-image-headline">${item.getProductName()}</h3>
                        </div>

                        <div class="card-body" >
                            <p class="text-primary">${item.getProductPrice()} <i class="material-icons">euro_symbol</i></p>
                            <p> <i class="material-icons">date_range</i> ${item.getPublishedDate()}</p>
                        </div>

                        <footer class="card-footer">
                            <a href="${context}/detail?itemId=${item.getId()}" class="btn btn-flat btn-warning" >Learn More</a>
                        </footer>

                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>
<%@include file="Footer.jsp" %>