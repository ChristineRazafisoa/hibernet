<%-- 
    Document   : listeSalle
    Created on : 23 févr. 2024, 12:37:13
    Author     : Bota
--%>

<%@page import="java.util.List"%>
<%@page import="manager.SalleManager"%>
<%@page import="bean.Salle"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/css/bootstrap.min.css" rel="stylesheet">
        <link href="https://cdn.datatables.net/v/bs5/jq-3.7.0/dt-2.0.1/datatables.min.css" rel="stylesheet">

        <script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/5.3.0/js/bootstrap.bundle.min.js"></script>
        <script src="https://cdn.datatables.net/v/bs5/jq-3.7.0/dt-2.0.1/datatables.min.js"></script>
       <link rel="stylesheet" href="css/bootstrap.min.css">
        <script src="js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.11.5/css/jquery.dataTables.min.css">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/5.3.0/css/bootstrap.min.css">
          <meta charset="utf-8">
    <meta name="viewport" content="width=device-width,initial-scale=1.0">
    <title>GESTION DE SALLES</title>

    <!-- Montserrat Font -->
    <link href="https://fonts.googleapis.com/css2?family=Montserrat:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Material Icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons+Outlined" rel="stylesheet">

    <!-- Custom CSS -->
    <link rel="stylesheet" href="styles.css">
    
    <style>
        .sidebar-list {
    color: white;
}

.sidebar-list-item a {
    color: white;
    text-decoration: none; /* Optional: Removes underline from links */
}

/* Optional: Style active or hovered links differently */
.sidebar-list-item a:hover,
.sidebar-list-item a:focus,
.sidebar-list-item a:active {
    color: white; /* Change to desired hover color */
}

 .main-containerx {
        background-image: url('image/sary.jpg'); /* Remplacez 'chemin/vers/votre/image.jpg' par le chemin de votre image */
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
    }

    </style>
    </head>
    <body>
        
              <c:if test="${not empty success ? true : false}">
            <div class="toast-container position-fixed top-0 end-0 p-3" style="z-index: 11">
                  <div id="liveToast" class="toast bg-success" role="alert" aria-live="assertive" aria-atomic="true">
                      <div class="toast-header">
                       <strong class="me-auto text-success">Reussi</strong>
                       <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                 </div>
                  <div class="toast-body text-light">
                      Avec Succes
                  </div>
              </div>
             </div>
        </c:if>
        
         <c:if test="${not empty edit ? true : false}">
            <div class="toast-container position-fixed top-0 end-0 p-3" style="z-index: 11">
                  <div id="liveToastEdit" class="toast bg-success" role="alert" aria-live="assertive" aria-atomic="true">
                      <div class="toast-header">
                       <strong class="me-auto text-success">Modification</strong>
                       <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                 </div>
                  <div class="toast-body text-light">
                      Avec Succes
                  </div>
              </div>
             </div>
        </c:if>
        
         <c:if test="${not empty delete ? true : false}">
            <div class="toast-container position-fixed top-0 end-0 p-3" style="z-index: 11">
                  <div id="liveToastEdit" class="toast bg-success" role="alert" aria-live="assertive" aria-atomic="true">
                      <div class="toast-header">
                       <strong class="me-auto text-success">Supprimer</strong>
                       <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                 </div>
                  <div class="toast-body text-light">
                      Avec Succes
                  </div>
              </div>
             </div>
        </c:if>

        
        <c:if test="${not empty error ? true : false}">
            <div class="toast-container position-fixed top-0 end-0 p-3" style="z-index: 11">
                  <div id="liveToastError" class="toast bg-danger" role="alert" aria-live="assertive" aria-atomic="true">
                      <div class="toast-header">
                       <strong class="me-auto text-danger">ECHEC</strong>
                       <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                 </div>
                  <div class="toast-body text-light">
                      Verifie bien les données peut-être que le code prof existe déjà
                  </div>
              </div>
             </div>
        </c:if>
        
          <div class="grid-container">

      <!-- Header -->
      <header class="header">
        GESTION DE SALLES
      </header>
      <!-- End Header -->

 <!-- Sidebar -->
 <aside id="sidebar" style="background-color: #cc3c43;">
  <div class="sidebar-title">
    <div class="sidebar-brand">
        
    </div>
    <span class="material-icons-outlined" onclick="closeSidebar()">close</span>
  </div>

     <ul class="sidebar-list">
    <li class="sidebar-list-item">
        <a href="http://localhost:8080/GestionSalle/dashboard">
            <span class="material-icons-outlined">dashboard</span> Accueil
        </a>
    </li>
    <li class="sidebar-list-item">
        <a href="prof">
            <span class="material-icons-outlined">man</span> Professeur
        </a>
    </li>
    <li class="sidebar-list-item">
        <a href="salle">
            <span class="material-icons-outlined">home</span> Salle
        </a>
    </li>
    <li class="sidebar-list-item">
        <a href="occuper">
            <span class="material-icons-outlined">man</span> Occupation
        </a>
    </li>
    <li class="sidebar-list-item">
        <a href="#">
            <span class="material-icons-outlined">settings</span> Parametre
        </a>
    </li>
</ul>

</aside>
<!-- End Sidebar -->

 <main class="main-container mt-3" id="main-container" style="background-color: white;">
     <div  class="container mt-2">
         
        
              <h5 style="text-align: center;color: black">LISTE DE SALLES</h5>

            <button type="button" class="btn btn-primary my-2" data-bs-toggle="modal" data-bs-target="#ajouterSalle" data-bs-whatever="@getbootstrap">Ajout un nouveau</button>
   

            <table border="1" class="table table-striped mt-8" id="myTable1" >
            <thead>
                <tr>
                    <th  style="text-align: center;">CODE SALLE</th>
                    <th  style="text-align: center;">DESIGNATION</th>
                    <th  style="text-align: center;">ACTION</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ salles }" var="s">
                    <tr>
                        <td  style="text-align: center;"><c:out value="${ s.getCodesal() }" /></td>
                        <td  style="text-align: center;"><c:out value="${ s.getDesignation() }" /></td>
    <td style="text-align: center;">

<button onclick="showModalEdit('${s.getCodesal()}', '${s.getDesignation()}', '${s.getId()}')" type="button"  class="btn btn-outline-success " data-bs-toggle="modal" data-bs-target="#modifierSalle" data-bs-whatever="@getbootstrap">
         <i class="material-icons-outlined" title="Modifier">create</i>
</button>
<button onclick="showModalDelete('${s.getId()}')" type="button" class="btn btn-outline-danger" data-bs-toggle="modal" data-bs-target="#supprimerSalle">
    <span class="material-icons-outlined" title="Supprimer">delete</span> 
</button>
    </td>


                     </tr>
                </c:forEach>
            </tbody>
        </table>
        </div>

       
</main>
<!-- SUPPRIMER SALLE -->


<!-- Modal -->
<div class="modal fade" id="supprimerSalle" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
        <form method="GET" action="salle/supprimer">
        
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Suppression</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        Vous voulez supprimer vraiment??
         <input id="idDelete" type="text" class="form-control" name="id" hidden="true" >

      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Annuler</button>
        <button type="submit" class="btn btn-outline-primary">Supprimer</button>
      </div>
            </form>
    </div>
  </div>
</div>

<!-- AJOUTER SALLE -->


<!-- <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#ajouterSalle" data-bs-whatever="@getbootstrap">ajouter</button>
    <a href="http://localhost:8080/GestionSalle/salle/supprimer?id=<c:out value="${s.getId()}" />" class="btn btn-outline-danger">Supprimer</a>
-->
<div class="modal fade" id="ajouterSalle" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
      
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Ajout un nouveau salle</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        <form method="POST" action="salle/ajout">
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Code Salle :</label>
            <input type="text" class="form-control" name="codesal" placeholder="code sal" required="entrez le code du salle">
          </div>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Designation :</label>
            <input type="text" class="form-control" name="designation" placeholder="designation" required="entrez le nom du salle">
          </div>
            <div class="modal-footer">
        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Annuler</button>
        <button type="submit" class="btn btn-outline-primary">Ajouter</button>
      </div>
        </form>
      </div>
      
    </div>
  </div>
</div>


<!-- MODIFIER SALLE -->

<div class="modal fade" id="modifierSalle" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h1 class="modal-title fs-5" id="exampleModalLabel">Modification un salle</h1>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
          <form method="POST" action="salle/modifier" >
              <input id="idEdit" type="text" class="form-control" name="id" hidden="true" >
             
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Code Salle :</label>
            <input id="salleEdit" type="text" class="form-control" name="codesal" >
          </div>
          <div class="mb-3">
            <label for="recipient-name" class="col-form-label">Designation :</label>
            <input id="designationEdit" type="text" class="form-control" name="designation" >
          </div>
            <div class="modal-footer">
              <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Annuler</button>
              <button type="submit" class="btn btn-outline-primary">Modifier</button>
            </div>
        </form>
      </div>
    </div>
  </div>
</div>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
 <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.3.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>
<script src="https://cdn.datatables.net/1.13.1/js/jquery.dataTables.min.js"></script>

<script>
    


    
 $(document).ready(function() {
    $('#myTable1').DataTable({
        "language": {
            "url": "//cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/French.json"
        },
        "lengthMenu": [5, 10, 20, 30] // Définir les options d'affichage
    });
    
    $('#liveToast').toast('show');
    setTimeout(function(){
        $('#liveToast').toast('hide');
    }, 5000);
    
     $('#liveToastEdit').toast('show');
    setTimeout(function(){
        $('#liveToast').toast('hide');
    }, 5000);
    
    $('#liveToastError').toast('show');
    setTimeout(function(){
        $('#liveToast').toast('hide');
    }, 5000);
});
    
    function showModalEdit(codesal, designation, id){
        const sal = document.getElementById("salleEdit");
        const des = document.getElementById("designationEdit");
        const idInput = document.getElementById("idEdit");
        console.log(codesal);
        console.log(designation);
        console.log(id);
        sal.value = codesal;
        des.value = designation;
        idInput.value = id;
    }
    
    function  showModalDelete(id){
        const idInput = document.getElementById("idDelete");
        console.log(id);
        idInput.value = id;

    }
</script>


    </body>
</html>
