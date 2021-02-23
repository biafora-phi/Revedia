<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, shrink-to-fit=no">
    <title>Revedia - Scheda libro</title>
    <link rel="stylesheet" href="/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:400,500,700">
    <link rel="stylesheet" href="/fonts/font-awesome.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.5.2/animate.min.css">
    <link rel="stylesheet" href="/css/styles.css">
</head>

<body>
<nav class="navbar navbar-light navbar-expand-md sticky-top pulse animated">
    <div class="container-fluid"><a class="navbar-brand text-uppercase" href="/">REVEDIA</a>
        <button data-toggle="collapse" class="navbar-toggler" data-target="#navcol-1">
            <span class="sr-only">Toggle navigation</span>
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse"
             id="navcol-1">
            <ul class="nav navbar-nav">
                <li class="nav-item"><a class="nav-link" href="/music">Musica</a></li>
                <li class="nav-item"><a class="nav-link" href="/movies">Film</a></li>
                <li class="nav-item"><a class="nav-link active" href="/books">Libri</a></li>
            </ul>
            <form class="form-inline mr-auto" target="_self">
                <div class="form-group"><label class="searchLbl" for="search-field">
                    <i class="fa fa-search"></i></label>
                    <input class="form-control search-field" type="search" id="search-field-1" name="search" placeholder="Cerca un contenuto" autocomplete="off">
                </div>
            </form>
            <div class="dropdown ml-auto dropdown-user-controls" style="${hideuser}">
                <a class="text-left dropdown-user-controls-btn" data-toggle="dropdown" aria-expanded="false" href="#">
                    <i class="fa fa-user-circle"></i>${user.nickname}
                </a>
                <div class="dropdown-menu dropdown-menu-right dropdown-user-controls-menu">
                    <div class="dropdown-info-area"><i class="fa fa-user-circle"></i>
                        <h5 class="dropdown-info-header">${user.nickname}</h5>
                        <h6 class="dropdown-info-subheader">Utente ${fn:toLowerCase(user.permissions)}</h6>
                    </div>
                    <div class="dropdown-divider"></div>
                    <a class="dropdown-item" href="/user"><i class="fa fa-area-chart item-icon"></i>Profilo</a>
                    <c:if test="${user.permissions != 'STANDARD'}"><a class="dropdown-item" href="/manage"><i class="fa fa-edit item-icon"></i>Gestisci contenuti</a></c:if>
                    <a class="dropdown-item" href="/logout"><i class="fa fa-sign-out item-icon"></i>Esci</a></div>
            </div>
            <a href="/Login">
                <button class="btn btn-primary btn-sm ml-auto nav-login-btn" type="button" style="${signupbutton}">Accedi</button>
            </a>
        </div>
    </div>
</nav>
    <div class="content-page-img" style="background-image: url(&quot;/images/books/${book.imageId}.jpg&quot;);"></div>
    <div class="card explore-card content-page-main-card">
        <div class="card-body">
            <div class="card-info">
                <ul class="list-inline">
                    <c:forEach var="counter" begin="0" end="4">
                        <c:choose>
                            <c:when test="${counter < book.rating}">
                                <li class="list-inline-item star selected-star"><i class="fa fa-star"></i></li>
                            </c:when>
                            <c:otherwise>
                                <li class="list-inline-item star"><i class="fa fa-star"></i></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </ul>
                <h6 class="text-muted card-subtitle mb-2"><i class="fa fa-user card-icon user-icon"></i><c:out value="${book.user}"/></h6>
                <h6 class="text-muted card-subtitle mb-2 last-subtitle"><i class="fa fa-spinner card-icon"></i><c:out value="${book.postDate}"/></h6>
                <h1 class="text-nowrap text-truncate card-title card-title-xl"><c:out value="${book.title}"/></h1>
                <div class="content-page-info-section">
                    <h5 class="info-header-lbl"><i class="fa fa-book section-title-icon"></i>Autore</h5>
                    <h4 class="text-nowrap text-truncate card-title info-lbl"><c:out value="${book.artist}"/></h4>
                </div>
                <div class="content-page-info-section">
                    <h5 class="info-header-lbl"><i class="fa fa-bookmark section-title-icon clock-icon"></i>Numero di pagine</h5>
                    <h4 class="text-nowrap text-truncate card-title info-lbl">${book.numberOfPages}</h4>
                </div>
                <div class="content-page-info-section">
                    <h5 class="info-header-lbl"><i class="fa fa-print section-title-icon clock-icon"></i>Casa editrice</h5>
                    <h4 class="text-nowrap text-truncate card-title info-lbl"><c:out value="${book.publishingHouse}"/></h4>
                </div>
                <div class="content-page-info-section">
                    <h5 class="info-header-lbl"><i class="fa fa-info-circle section-title-icon genre-icon"></i>Genere</h5>
                    <h4 class="text-nowrap text-truncate card-title info-lbl"><c:out value="${book.genres}"/></h4>
                </div>
                <div class="content-page-info-section">
                    <h5 class="info-header-lbl"><i class="fa fa-list section-title-icon"></i>Trama</h5>
                    <p class="description-lbl"><c:out value="${book.description}"/><br></p>
                </div>
            </div>
        </div>
    </div>
    <div class="home-main-container">
        <div class="container-fluid pulse animated content-section-area">
            <h2><i class="fa fa-file-text section-title-icon"></i>Estratto</h2>
            <div class="row">
                <div class="col"><button class="btn btn-primary btn-sm" type="button">Leggi l'estratto</button></div>
            </div>
        </div>
        <div class="container-fluid pulse animated content-section-area">
            <h2><i class="fa fa-pencil-square section-title-icon"></i>Lascia la tua recensione</h2>
            <div class="row">
                <div class="col">
                    <h6 class="not-logged-msg">Devi essere autenticato per pubblicare una recensione</h6>
                </div>
            </div>
        </div>
        <div class="container-fluid pulse animated content-section-area">
            <h2><i class="fa fa-users section-title-icon"></i>Recensioni</h2>
            <div class="row">
                <c:forEach items="${reviews}" var="review">
                    <div class="col">
                        <div class="card explore-card review-card">
                            <div class="card-body">
                                <div class="card-info">
                                    <div class="row review-card-header">
                                        <div class="col d-md-flex align-self-center align-items-md-center review-card-user-area-container left-container">
                                            <div class="d-flex align-items-center flex-wrap review-card-user-area">
                                                <h6 class="text-muted card-subtitle mb-2"><i class="fa fa-user card-icon"></i><c:out value="${review.user}"/></h6>
                                                <ul class="list-inline text-nowrap">
                                                    <c:forEach var="counter" begin="0" end="4">
                                                        <c:choose>
                                                            <c:when test="${counter < review.numberOfStars}">
                                                                <li class="list-inline-item star selected-star"><i class="fa fa-star"></i></li>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <li class="list-inline-item star"><i class="fa fa-star"></i></li>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                        <div class="col align-self-center review-card-user-area-container">
                                            <div class="justify-content-start align-items-center flex-wrap justify-content-sm-end review-card-user-area">
                                                <h6 class="text-nowrap text-muted card-subtitle mb-2 rate-section"><i class="fa fa-thumbs-up card-icon like-icon selected-like-icon"></i>143</h6>
                                                <h6 class="text-nowrap text-muted card-subtitle mb-2"><i class="fa fa-thumbs-down card-icon like-icon"></i>21</h6>
                                            </div>
                                        </div>
                                    </div>
                                    <p class="review-card-txt"><c:out value="${review.description}"/></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>
                </div>
            </div>
        </div>
    </div>
    <footer>
        <div class="container-fluid">
            <div class="row">
                <div class="col">
                    <h6 class="footer-logo">REVEDIA</h6>
                    <p class="footer-text">Revedia è un punto di incontro per tutti gli amanti di musica, film e libri<br>Esplora il vasto catalogo di contenuti, contribuendo anche tu con le tue recensioni</p><a class="card-link" href="/aboutus">Chi siamo</a></div>
            </div>
        </div>
    </footer>
    <script src="/js/jquery.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script src="/js/bs-init.js"></script>
</body>

</html>