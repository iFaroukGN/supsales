
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>

<div class="jumbotron container">

    <div class="row">
        <div class="col-lg-2"></div>
        <div class="col-lg-8">
            <h2 class="text-primary">
                Listes des utilisateurs inscrit sur Supsales
            </h2><br><br><br><br>
            <div class="card">
                <div class="card-height-indicator"></div>
                <div class="card-content">

                    <div class="card-body" >
                        <c:forEach items="${user.getUsersList()}" var="u" >
                            <div class="list-group col-lg-4">
                                <div class="list-group-item">
                                    <div class="row-picture">
                                        <img class="circle" src="http://lorempixel.com/56/56/people/1" alt="icon">
                                    </div>
                                    <div class="row-content">
                                        <div class="action-secondary"><a href="${context}/a/deleteUser?toDelete=${u.getID()}"><i class="material-icons">delete</i></a></div>
                                        
                                        <h4 class="list-group-item-heading text-capitalize">${u.getUserName()}</h4>

                                        <p class="list-group-item-text">${u.getPhoneNumber()}</p>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                    </div>

                    <div><br></div>
                </div>
            </div>
        </div>
        <div class="col-lg-2"></div>
    </div> 

</div>
<%@include file="Footer.jsp" %>