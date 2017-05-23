<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="Header.jsp" %>
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
                        <h1 class="panel-title" class="text-uppercase text-info text-center">${empty msg ? " AJOUTER UN ARTCILE ": msg}</h1>
                    </div>
                    <div class="panel-body">
                        <c:forEach items="${product.getListProductById(toUpdate)}" var="item" >

                            <form action="updateItem" method="POST" enctype="multipart/form-data">

                                <div class="form-group label-floating">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="material-icons">local_offer</i></span>
                                        <input class="form-control" placeholder="Libelle de l'article" id="focusedInput1" type="text" name="itemname" value="<c:out value="${item.getProductName()}"/>">
                                        <input class="form-control" placeholder="Libelle de l'article" id="focusedInput1" type="hidden" name="prodId" value="<c:out value="${item.getId()}"/>">
                                    </div>
                                </div>

                                <div class="form-group label-floating">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="material-icons">monetization_on</i></span>
                                        <input type="text" id="addon3a" placeholder="Prix de l'article" name ="itemprice" class="form-control" value="<c:out value="${item.getProductPrice()}"/>">
                                    </div>
                                </div>

                                <div class="input-group">
                                    <span class="input-group-addon"><i class="material-icons">assignment</i></span>
                                    <select id="select111" class="form-control" name="itemcategory">
                                        <option><c:out value="${item.getProductCategory().getCategoryName()}"/></option>
                                        <option>Multimedia</option>
                                        <option>Emplois</option>
                                        <option>Immobilier</option>
                                        <option>Services</option>
                                        <option>Vehicules</option>
                                        <option>Equipement professionnel</option>
                                    </select>
                                </div>

                                <div class="form-group">
                                    <input type="file" id="inputFile4" multiple="" name="itempicture" value="<c:out value="${item.getProductPicture()}"/>">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="material-icons">insert_photo</i></span>
                                        <input type="text" readonly="" class="form-control" placeholder="<c:out value="${item.getProductPicture()}"/>" value="<c:out value="${fichier.nom}"/>">
                                        <span class="input-group-btn input-group-sm">
                                            <button type="button" class="btn btn-fab btn-fab-mini">
                                                <i class="material-icons">attach_file</i>
                                            </button>
                                        </span>
                                    </div>
                                </div>

                                <div class="form-group label-floating">
                                    <div class="input-group">
                                        <span class="input-group-addon"><i class="material-icons">description</i></span>
                                        <textarea type="text" id="addon3a" rows="3" class="form-control" name="itemdescription" placeholder="Description de l'article" ><c:out value="${item.getProdutDescription()}"/></textarea>
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
                        </c:forEach>

                    </div>

                    <p class="${empty form.erreurs ? 'succes' : 'erreur'}">${form.resultat}</p>        
                </div>
            </div>

        </div>
    </div>
</div>
<div class="col-lg-2"></div>
<%@include file="Footer.jsp" %>
