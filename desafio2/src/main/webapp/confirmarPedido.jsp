<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Confirmar Pedido</title>
</head>
<body>
<h1>Confirmar Pedido</h1>
<h2>Platos seleccionados:</h2>
<ul>
  <c:forEach var="plato" items="${platos}">
    <li>${plato}</li>
  </c:forEach>
</ul>
<h3>Total: $${total}</h3>

<!-- Formulario para el pago -->
<form action="PaymentServlet" method="post">
  <label for="paymentMethod">Método de Pago:</label>
  <select name="paymentMethod" id="paymentMethod">
    <option value="tarjeta">Tarjeta de Crédito/Débito</option>
    <option value="efectivo">Efectivo</option>
  </select>
  <input type="submit" value="Pagar y Confirmar Pedido">
</form>
</body>
</html>
