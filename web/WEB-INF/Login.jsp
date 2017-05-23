<%-- 
    Document   : Login
    Created on : 25 janv. 2017, 16:16:27
    Author     : Fairuz
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="product" scope="page" class="jva.supinfo.supsales.Beans.ProductBean"> </jsp:useBean>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
    <head>


        <meta charset="UTF-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"> 
        <!-- Mobile support -->
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <!-- Material Design fonts -->
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/css?family=Roboto:300,400,500,700">
        <link rel="stylesheet" type="text/css" href="//fonts.googleapis.com/icon?family=Material+Icons">

        <!-- Bootstrap -->
        <link rel="stylesheet" type="text/css" href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

        <!-- Bootstrap Material Design -->
        <link rel="stylesheet" type="text/css" href="${context}/assets/css/bootstrap-material-design.css">
        <link rel="stylesheet" type="text/css" href="${context}/assets/css/ripples.min.css">

        <title> SupSales </title>
    </head>
    <c:set var="context" value="${pageContext.request.contextPath}" />

    <div class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <a class="navbar-brand" href="${context}">SupSales</a>

            </div>
            <div class="navbar-collapse collapse navbar-responsive-collapse">

            </div>
        </div>
    </div>
    <div class=" container">
        <div class="row">

            <div class="col-lg-3"></div>
            <div class="col-lg-6">

                <div class="card-body ">
                    <div class="text"><br></div>
                    <div class="text"><br></div>
                    <div class="text"><br></div>

                    <div class="panel panel-primary">
                        <div class="panel-heading">
                            <div class="text"><br></div>
                            <div class="text"><br></div>
                            <h1 class="panel-title" class="text-uppercase text-info text-center">CONNEXION</h1>
                        </div>
                        <div class="panel-body">
                            <h2 class="text-danger"> ${empty msg ? "": msg}</h2>
                            <form action="login" method="POST">
                                <div class="form-group label-floating">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="material-icons">perm_identity</i></span>

                                        <input class="form-control" placeholder="Nom d'utilisateur" id="focusedInput1" type="text" name="username">
                                    </div>
                                </div>
                                <div class="form-group label-floating">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="material-icons">vpn_key</i></span>
                                        <input type="password" id="addon3a" class="form-control" name="pass" placeholder="Mot de passe"/>
                                        <span class="input-group-btn">
                                            <button type="button" class="btn btn-fab btn-fab-mini" onclick = "this.form.submit();">
                                                <i class="material-icons">send</i>
                                            </button>
                                        </span>
                                    </div>
                                </div>
                                <div class="col-sm-offset-2 col-sm-6">
                                    <a type="submit" class="btn btn-primary center-block" href="${context}/register">S'inscrire</a>
                                </div>
                            </form>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="col-lg-3"></div>
    </div>
</div>

<%@include file="Footer.jsp" %>