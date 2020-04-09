<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        body {
            background: rgba(0, 0, 45, 0.15) !important;
        }
    </style>
    <title>Система учета студентов</title>
</head>
<div class="container">
    <div class="row">
        <div class="col-md-12 text-center py-3">
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/showAll">НА ГЛАВНУЮ</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/showAll">ВСЕ СТУДЕНТЫ</a>
            <a class="btn btn-primary" href="${pageContext.request.contextPath}/addStudent">ДОБАВИТЬ СТУДЕНТА</a>
        </div>
    </div>
        <div class="row justify-content-center py-3">
    <form action="${pageContext.request.contextPath}/updateStudent" method="post">
           <input type="text" value="${student.id}" name="id" hidden>
            <div class="form-group text-center form-check-inline">
                                <label for="idStudent">id</label>
                <input type="text" value="${student.id}" class="form-control" id="idStudent" name="idStudent" disabled>
            </div>
            <div class="form-group text-center form-check-inline">
                                <label for="firstname">Имя</label>
                <input type="text" value="${student.firstname}" class="form-control" id="firstname" name="firstname"
                       disabled>
            </div>
            <div class="form-group text-center form-check-inline">
                                <label for="lastname">Фамилия</label>
                <input type="text" value="${student.lastname}" class="form-control" id="lastname" name="lastname"
                       disabled>
            </div>
            <div class="form-group text-center">
                <div class="h4">Оценки</div>
            </div>
            <div class="form-group text-center">
                <c:forEach items="${marks}" var="mark" varStatus="loop">
                    <div class="form-group text-center form-check-inline">
                        <select name="marks">
                            <c:choose>
                                <c:when test="${mark==0}">
                                    <option selected>0</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                </c:when>
                                <c:when test="${mark==1}">
                                    <option>0</option>
                                    <option selected>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                </c:when>
                                <c:when test="${mark==2}">
                                    <option>0</option>
                                    <option>1</option>
                                    <option selected>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                </c:when>
                                <c:when test="${mark==3}">
                                    <option>0</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option selected>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                </c:when>
                                <c:when test="${mark==4}">
                                    <option>0</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option selected>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                </c:when>
                                <c:when test="${mark==5}">
                                    <option>0</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option selected>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                </c:when>
                                <c:when test="${mark==6}">
                                    <option>0</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option selected>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                </c:when>
                                <c:when test="${mark==7}">
                                    <option>0</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option selected>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                </c:when>
                                <c:when test="${mark==8}">
                                    <option>0</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option selected>8</option>
                                    <option>9</option>
                                    <option>10</option>
                                </c:when>
                                <c:when test="${mark==9}">
                                    <option>0</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option selected>9</option>
                                    <option>10</option>
                                </c:when>
                                <c:when test="${mark==10}">
                                    <option>0</option>
                                    <option>1</option>
                                    <option>2</option>
                                    <option>3</option>
                                    <option>4</option>
                                    <option>5</option>
                                    <option>6</option>
                                    <option>7</option>
                                    <option>8</option>
                                    <option>9</option>
                                    <option selected>10</option>
                                </c:when>
                            </c:choose>
                        </select>
                    </div>
                </c:forEach>
            </div>
            <div class="form-group text-center">
                <button type="submit" class="btn btn-primary">Сохранить изменения</button>
            </div>
    </form>
        </div>
</div>
</body>
</html>