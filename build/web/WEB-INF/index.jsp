<%-- 
    Document   : index.jsp
    Created on : 4 mars 2024, 14:50:59
    Author     : Bota
--%>
<%@page import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page import="java.text.*" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
       
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
.main-container {
        background-image: url('image/sary.jpg'); /* Remplacez 'chemin/vers/votre/image.jpg' par le chemin de votre image */
        background-size: cover;
        background-position: center;
        background-repeat: no-repeat;
    }
    
.container {
  display: flex;
}

.left, .center, .right {
  flex: 1;
}

.center {
  text-align: center;
}

.right {
  text-align: right;
}

    </style>
  </head>
  
  <body>
    <div class="grid-container">

      <!-- Header -->
     <header class="header" id="header" style="text-align: center; font-weight: bold;">
         <h3  style="text-align: center; font-weight: bold; margin-left: 300px;">GESTION DE SALLES</h3>
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
        <a href="http://localhost:8080/GestionSalle/dashboard" >
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


      <!-- Main -->
      <main class="main-container mt-2 " id="main-container">
    
<div class="container">
  <div class="center">
    <div class="card">
      <div class="card-content">
        <h2 class="card-title">Professeur : ${totalProf}</h2>
      </div>
    </div>
  </div>
  
  <div class="center">
    <div class="card">
      <div class="card-content">
          <h2 class="card-title">Salle : ${totalSalle}</h2>
      </div>
    </div>
  </div>
  
  <div class="center">
    <div class="card">
      <div class="card-content">
        <h2 class="card-title">Total : ${totalOccuper} </h2>
      </div>
    </div>
  </div>
</div>
          <br>
 <div class="charts mt-2">

          <div class="charts-card">
            <p class="chart-title">Nombre du salle par un prof</p>
            <div id="bar-chart"></div>
          </div>

          <div class="charts-card">
            <p class="chart-title">Liste de salles occupent</p>
           
                  <table border="1" class="table table-striped mt-2">
                <thead>
                <tr>
                    <th style="text-align: center;">CODE PROF</th>
                    <th style="text-align: center;">CODE SALLE</th>
                    <th style="text-align: center;">DATE</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${ occupers }" var="o">
                    <tr>
                        <td style="text-align: center;"> <c:out value="${ o.getProf().getCodeprof() }" /> </td>
                        <td style="text-align: center;"> <c:out value="${ o.getSalle().getCodesal() }" /> </td>
                        <td style="text-align: center;"> <fmt:formatDate value="${ o.getDate() }" pattern="dd-MM-YYYY" /> </td>
                       
                    </tr>
                </c:forEach>
            </tbody>
        </table>
            </div>
          </div>

       
          
      </main>
      <!-- End Main -->

    </div>

    <!-- Scripts -->
    <!-- ApexCharts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/apexcharts/3.35.3/apexcharts.min.js"></script>
    <!-- Custom JS -->
    <script>
        
        // BAR CHART
        const barChartOptions = {
          series: [
            {
              data: ${totalS},
            },
          ],
          chart: {
            type: 'bar',
            height: 350,
            toolbar: {
              show: false,
            },
          },
          plotOptions: {
            bar: {
              distributed: true,
              borderRadius: 4,
              horizontal: false,
              columnWidth: '40%',
            },
          },
          dataLabels: {
            enabled: false,
          },
          legend: {
            show: false,
          },
          xaxis: {
            categories: ${listeProf},
          },
          yaxis: {
            title: {
              text: 'Count',
            },
          },
        };

        const barChart = new ApexCharts(
          document.querySelector('#bar-chart'),
          barChartOptions
        );
        barChart.render();
    </script>
  </body>
</html>