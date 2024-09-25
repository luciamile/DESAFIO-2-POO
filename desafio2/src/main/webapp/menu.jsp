<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Menú</title>
</head>
<body>
<h1>Menú de Productos</h1>
<form action="OrderServlet" method="post">
    <ul>
        <!-- Iterar sobre el menú recibido desde el Servlet -->
        <c:forEach var="plato" items="${menu}">
            <li>
                <input type="checkbox" name="platosSeleccionados" value="${plato}">${plato}
            </li>
        </c:forEach>
    </ul>
    <input type="submit" value="Realizar Pedido">
</form>
</body>
</html>
