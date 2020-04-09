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
            <div class="h2">ДОБАВИТЬ НОВОГО СТУДЕНТА</div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12 text-center">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/">НА ГЛАВНУЮ</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/showAll">ВСЕ СТУДЕНТЫ</a>
        </div>
    </div>
    <div class="row justify-content-center pt-3">
        <form action="${pageContext.request.contextPath}/saveStudent" method="post" name="newStudentForm">
            <div class="form-group text-center">
                <label for="firstname">Имя</label>
                <input type="text" class="form-control" id="firstname" name="firstname">
            </div>
            <div class="form-group text-center">
                <label for="lastname">Фамилия</label>
                <input type="text" class="form-control" id="lastname" name="lastname">
            </div>
            <div class="form-group text-center">
                <button type="submit" class="btn btn-primary">Сохранить</button>
            </div>
        </form>
    </div>
</div>
</body>
</html>
