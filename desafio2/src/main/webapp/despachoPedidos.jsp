<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Despacho de Pedidos</title>
</head>
<body>
<h1>Gestión de Pedidos</h1>

<table border="1">
    <tr>
        <th>ID Pedido</th>
        <th>Cliente</th>
        <th>Platos</th>
        <th>Estado</th>
        <th>Comentario</th>
        <th>Acciones</th>
    </tr>

    <c:forEach var="pedido" items="${pedidos}">
        <tr>
            <td>${pedido.id}</td>
            <td>${pedido.cliente}</td>
            <td>${pedido.platos}</td>
            <td>${pedido.estado}</td>
            <td>${pedido.comentario}</td>
            <td>
                <form method="post" action="DespachoPedidos">
                    <input type="hidden" name="pedidoId" value="${pedido.id}"/>
                    <select name="estado">
                        <option value="Aceptado" ${pedido.estado == 'Aceptado' ? 'selected' : ''}>Aceptado</option>
                        <option value="En proceso de elaborar" ${pedido.estado == 'En proceso de elaborar' ? 'selected' : ''}>En proceso de elaborar</option>
                        <option value="Entregado al repartidor" ${pedido.estado == 'Entregado al repartidor' ? 'selected' : ''}>Entregado al repartidor</option>
                        <option value="Entregado al cliente" ${pedido.estado == 'Entregado al cliente' ? 'selected' : ''}>Entregado al cliente</option>
                    </select>
                    <input type="text" name="comentario" placeholder="Agregar comentario" value="${pedido.comentario}"/>
                    <button type="submit">Actualizar</button>
                </form>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
