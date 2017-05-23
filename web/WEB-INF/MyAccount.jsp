<%-- 
    Document   : MyAccount
    Created on : 2 févr. 2017, 01:03:59
    Author     : Fairuz
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
<c:set value="${sessionScope.userObj.getID()}" var="uID"></c:set>

    <div class="jumbotron container">
        <div class="row">
        <c:forEach items="${user.getUserBy(uID)}" var="u" >

            <div class="col-lg-8">
                <div class="card">

                    <div class="card-height-indicator"></div>
                    <div class="card-content">

                        <div class="card-image">
                            <img src="http://lorempixel.com/500/500/people/1/" alt="Loading image...">
                            <h3 class="card-image-headline text-primary text-capitalize">${u.getUserName()}</h3>
                        </div>

                        <div class="card-body" >
                            <p>
                                <span class="text-primary text-uppercase"> Mes articles : </span>
                            </p>
                            <c:forEach items="${u.getUserSalesAds()}" var="uItem" >
                                <div class="list-group">
                                    <div class="list-group-item">
                                        <div class="row-action-primary">
                                            <i class="material-icons">label</i>
                                        </div>
                                        <div class="row-content">
                                            <div class="action-secondary"><a href="${context}/delete?toDelete=${uItem.getId()}"><i class="material-icons">delete</i></a></div>
                                            <span class="list-group-item-heading text-primary">${uItem.getProductName()} <a href="${context}/auth/updateItem?toUpdate=${uItem.getId()}"><i class="material-icons">edit</i></a></span>
                                            <p class="list-group-item-text">${uItem.getProductPrice()} <i class="material-icons">euro_symbol</i></p>
                                        </div>
                                    </div>
                                    <div class="list-group-separator"></div>
                                </div>
                            </c:forEach>

                            <footer class="card-footer">

                            </footer>
                            <div><br></div>
                        </div>
                    </div>
                </div>

            </div>
            <div class="col-lg-4">
                <div class="panel panel-default">
                    <div class="panel-body">
                        <p>Nom d'utilisateur : <span class="text-primary text-capitalize">${u.getUserName()}</span></p>
                        <div class="list-group-separator"></div>
                        <p>Nom : <span class="text-primary text-capitalize">${u.getFirstName()}</span></p>
                        <div class="list-group-separator"></div>
                        <p>Prenom : <span class="text-primary text-capitalize">${u.getLastName()}</span></p>
                        <div class="list-group-separator"></div>
                        <p>Numero de telphone : <span class="text-primary">${u.getPhoneNumber()}</span></p>
                        <div class="list-group-separator"></div>
                        <p>Adresse postale : <span class="text-primary">${u.getPostalAddress()}</span></p>
                        <div class="list-group-separator"></div>
                        <p>Adresse e-mail : <span class="text-primary">${u.getEmail()}</span></p>
                    </div>
                    <div class="panel-footer"><a href="${context}/auth/update" class="btn btn-raised btn-lg">Modifier le Profil</a></div>
                </div>
            </div>
        </c:forEach>
        </div>
    </div>
    <%@include file="Footer.jsp" %>
