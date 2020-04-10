<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <style type="text/css">
        body { background: rgba(0, 0, 45, 0.15) !important; }
    </style>
    <title>Система учета студентов</title>
</head>
<div class="container">
    <div class="row">
        <div class="col-md-12 text-center py-3">
            <div class="h2">СОРТИРОВКА</div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 text-center py-3">
            <div class="h6">
                Только те, у которых в имени больше 3-х гласных букв. Фамилии студентов отсортированные по алфавиту. Переведены в UPPERCASE.
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 text-center">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/">НА ГЛАВНУЮ</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/showAll">ВСЕ СТУДЕНТЫ</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/addStudent">ДОБАВИТЬ СТУДЕНТА</a>
        </div>
    </div>
    <c:forEach items="${students}" var="student">
        <div class="row pt-3">
            <div class="col-md-12 text-center">
               <div class="h6">${student.lastname}</div>
            </div>
        </div>
    </c:forEach>
</div>
</body>
</html>