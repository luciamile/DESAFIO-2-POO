package sv.edu.udb.desafio2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

@WebServlet("/OrderServlet")
public class OrderServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener los platos seleccionados
        String[] platosSeleccionados = request.getParameterValues("platosSeleccionados");

        // Verificar que el cliente seleccionó al menos un plato
        if (platosSeleccionados == null || platosSeleccionados.length == 0) {
            request.setAttribute("error", "Debes seleccionar al menos un plato.");
            request.getRequestDispatcher("/menu.jsp").forward(request, response);
            return;
        }

        // Calcular el total (simulado)
        double total = platosSeleccionados.length * 5.00; // Ejemplo: cada plato cuesta 5.00

        // Enviar los datos a la JSP para confirmar el pedido
        request.setAttribute("platos", Arrays.asList(platosSeleccionados));
        request.setAttribute("total", total);

        request.getRequestDispatcher("/confirmarPedido.jsp").forward(request, response);
    }
}
