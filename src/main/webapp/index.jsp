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
            <div class="h2">СИСТЕМА УЧЕТА СТУДЕНТОВ</div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 text-center">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/showAll">ВСЕ СТУДЕНТЫ</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/addStudent">ДОБАВИТЬ СТУДЕНТА</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/l29Sorting">СОРТИРОВКА ИЗ УРОКА 29</a>
        </div>
    </div>
    <div class="row py-3">
        <div class="col-md-12 text-center">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/init">ИНИЦИАЛИЗИРОВАТЬ СПИСОК СТУДЕНТОВ</a>
        </div>
    </div>
</div>
</body>
</html>
