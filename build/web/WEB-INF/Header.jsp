<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="product" scope="page" class="jva.supinfo.supsales.Beans.ProductBean"> </jsp:useBean>
<jsp:useBean id="user" scope="page" class="jva.supinfo.supsales.Beans.UserBean"> </jsp:useBean>
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
    <body>
        <div class="navbar navbar-default">
            <div class="container-fluid">
                <div class="navbar-header">

                    <a class="navbar-brand" href="${context}/"><i class="material-icons">home</i>  SupSales</a>
                    <a class="navbar-brand" href="${context}/">  </a>
                    <a class="navbar-brand" href="${context}/">  </a>
                    <a class="navbar-brand" href="${context}/">  </a>
                    <a class="navbar-brand" href="${context}/">  </a>
                    <a class="navbar-brand" href="${context}/">  </a>
                    <a class="navbar-brand" href="${context}/auth/addItem" type="submit" ><i class="material-icons">add_circle_outline</i>  AJOUTER ARTICLE</a>
                    <a class="navbar-brand" href="${context}/listItems" type="submit" ><i class="material-icons">view_list</i>  AFFICHER ARTICLE</a>

                </div>

                <div class="navbar-collapse collapse navbar-responsive-collapse">
                    <form action="listItems" method="POST" class="navbar-form navbar-left">
                        <div class="form-group">
                            <input type="text" class="form-control col-md-12" placeholder="Search" name="search">
                            <input type="submit" class="form-control col-md-8 btn-fab btn-fab-mini">
                        </div>
                    </form>
                    <ul class="nav navbar-nav navbar-right">
                        <a class="navbar-brand" href="${context}/auth/account" type="submit" ><i class="material-icons">account_circle</i>  MON PROFIL</a>
                        <a class="navbar-brand" href="${context}/register" type="submit" ><i class="material-icons">add_box</i>  S'INSCRIRE</a>
                        <li class="active"><a href="${context}/login">${empty sessionScope.username ? "SE CONNECCTER":"SE DECONNECTER"}</a></li>
                    </ul>
                </div>
            </div>
        </div>
