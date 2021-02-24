<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>

<c:forEach items="${booksList}" var="book">
    <div class="row">
        <div class="col">
            <div class="card explore-card search-card">
                <div class="card-body">
                    <div class="card-info">
                        <ul class="list-inline">
                            <c:forEach var="i" begin="0" end="4">
                                <c:choose>
                                    <c:when test="${i < book.rating}">
                                        <li class="list-inline-item star selected-star"><i class="fa fa-star"></i></li>
                                    </c:when>
                                    <c:otherwise>
                                        <li class="list-inline-item star"><i class="fa fa-star"></i></li>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </ul>
                        <h4 class="text-nowrap text-truncate card-title"><c:out value="${book.title}"/></h4>
                        <h6 class="text-muted card-subtitle mb-2"><i class="fa fa-user card-icon"></i>${book.user}</h6><a class="card-link" href="/books/book?title=<c:out value="${book.title}"/>">Scopri di più</a></div>
                    <div class="card-img-cover" style="background-image: url('/images/books/${book.imageId}.jpg');"></div>
                </div>
            </div>
        </div>
    </div>
</c:forEach>