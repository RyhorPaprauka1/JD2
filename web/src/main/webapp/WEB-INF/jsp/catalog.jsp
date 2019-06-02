<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 04.05.2019
  Time: 1:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Catalog</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
<script>
    $(function () {
        var el;
        $("#rng").change(function () {
            el = $(this);
            el
                .next("#ong")
                .text(el.val());
        })
            .trigger('change');
    });
</script>
</head>
<body>
<div class="search-menu">
    <form id="catalogForm" action="${pageContext.request.contextPath}/catalog" method="post">
        <input type="text" name="name" placeholder="Название">
        Жанр:
        <select name="genre">
            <option value="COMEDY">COMEDY</option>
            <c:forEach var="genre" items="${requestScope.genres}">
                <option value="${genre.name()}">${genre.name()}</option>
            </c:forEach>
        </select>
        Цена до:
        <input id="rng" name="maxPrice" type="range" min="0" max="300" value="300" step="20">
        <output id="ong" for="rng">50</output>
        Показывать по
        <select name="maxResult">
            <option value="2">2</option>
            <option value="4">4</option>
        </select>
        <input type="submit" value="Искать">
    </form>
</div>
<div>
    <br>
    <ul>
        <c:forEach var="book" items="${requestScope.books}">
            <p>${book.name} ${book.price}<br></p>
        </c:forEach>
    </ul>
</div>
<div>
    <select form="catalogForm" name="pageNumber">
        <option selectedvalue="1">1</option>
        <c:forEach var="i" begin="1" end="${requestScope.pageNumber}" step="1">
            <option value="${i}">${i}</option>
        </c:forEach>
    </select>
</div>
</body>

</html>
