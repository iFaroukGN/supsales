<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : Index
    Created on : 26 janv. 2017, 12:27:10
    Author     : Fairuz
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="WEB-INF/Header.jsp" %>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<div class="col-lg-1"></div>
<div class="jumbotron container  panel-body">
    <h1>SupSales</h1>
    <div class="row">
        <p class="col-lg-8">
            Supsale est un site de vente d'annonces d'occasion comme Amazon. Chaque utilisateur peut publier une annonce pour vendre un objet. Les visiteurs peuvent répertorier des annonces et rechercher 
            un article par moteur de recherche. Pour placer un objet, vous devez disposer d'un compte utilisateur. Pour ajouter une annonce, il est possible de la classer dans une des catégories de vente. 
            (Véhicules, Emploi, Immobilier, Vacances, Multimédia, Équipement professionnel, Maison, Loisirs, Services, Autre).
        </p>
        <div class="col-lg-4">
            <div class="panel panel-default">
                <div class="panel-heading"><p class="text-primary"> <c:out value="${product.getListProduct().size()}" /> Articles en ventes sur SupSales</p></div>
                <div class="panel-body">
                    <p class="text-primary"><c:out value="${user.getUsersList().size()}" /> Utilisateurs inscrits sur SupSales</p>
                </div>
            </div>
        </div>
    </div>
</div>

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
                            <p><i class="material-icons">date_range</i> ${item.getPublishedDate()}</p>
                        </div>

                        <footer class="card-footer">
                            <a href="${context}/detail?itemId=${item.getId()}" class="btn btn-flat btn-warning" >Details</a>
                        </footer>

                    </div>
                </div>
            </div>
        </c:forEach>

    </div>
</div>
<%@include file="WEB-INF/Footer.jsp" %>
