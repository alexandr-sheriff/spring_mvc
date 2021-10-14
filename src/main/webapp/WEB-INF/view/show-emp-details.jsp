<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Spring MVC</title>
</head>
<body>

<h2>Dr. Emp, you are WELCOME!!!</h2>

<br>
<br>

<%--    <p>Your name: ${param.empName}</p>--%>
<p>Your name ${employee.name}</p>

<p>Your name ${employee.surname}</p>

<p>Your salary ${employee.salary}</p>

<p>Your department ${employee.department}</p>

<p>Your car ${employee.carBrand}</p>

<p>Language(s):
<ul>
    <c:forEach var="lang" items="${employee.languages}">
        <li>${lang}</li>
    </c:forEach>
</ul>
</p>

<p>Phone Number: ${employee.phoneNumber}</p>

<p>Email: ${employee.email}</p>

</body>
</html>