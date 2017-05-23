<%-- 
    Document   : Login
    Created on : 25 janv. 2017, 16:16:27
    Author     : Fairuz
--%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@include file="Header.jsp" %> 

<c:set var="context" value ="${pageContext.request.contextPath}"/>

<h2>${empty msg ? " ": msg}</h2>
<div class=" container">
    <div class="row">

        <div class="col-lg-2"></div>
        <div class="col-lg-8">

            <div class="card-body ">
                <div class="text"><br></div>
                <div class="text"><br></div>
                <div class="text"><br></div>

                <div class="panel panel-primary">
                    <div class="panel-heading">
                        <div class="text"><br></div>
                        <div class="text"><br></div>
                        <h1 class="panel-title" class="text-uppercase text-info text-center">${empty msg ? " S'ENREGISTRER ": msg}</h1>
                    </div>
                    <div class="panel-body">

                        <form action="register" method="POST">

                            <div class="form-group label-floating">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="material-icons">perm_identity</i></span>

                                    <input class="form-control" placeholder="Nom" id="focusedInput1" type="text" name="firstname">
                                </div>
                            </div>

                            <div class="form-group label-floating">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="material-icons">perm_identity</i></span>
                                    <input type="text" id="addon3a" placeholder="Prénom" name ="lastname" class="form-control">
                                </div>
                            </div>

                            <div class="form-group label-floating">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="material-icons">email</i></span>
                                    <input type="email" id="addon3a" placeholder="john@supsales.com" name ="email" class="form-control">
                                </div>
                            </div>


                            <div class="form-group label-floating">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="material-icons">contact_phone</i></span>
                                    <input type="text" id="addon3a" placeholder="0618195051" name ="phonenumber" class="form-control">
                                </div>
                            </div>


                            <div class="form-group label-floating">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="material-icons">location_on</i></span>
                                    <input type="text" id="addon3a" placeholder="Adresse postal" name ="postalnumber" class="form-control">
                                </div>
                            </div>

                            <div class="form-group label-floating">
                                <div class="input-group">
                                    <span class="input-group-addon"><i class="material-icons">account_circle</i></span>
                                    <input type="text" id="addon3a" placeholder="Nom d'utilisateur" name ="username" class="form-control">
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

                            <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>        
                            <div class="form-group">
                                <div class="col-md-10 col-md-offset-2">
                                    <span class="text-center"> <button type="reset" class="btn btn-lg"><i class="material-icons">cancel</i>  Cancel</button> </span>
                                </div>
                            </div>
                        </form>
                    </div>

                    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>        
                </div>
            </div>

        </div>
    </div>
</div>
<%@include file="Footer.jsp" %>     