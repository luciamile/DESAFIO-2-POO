package sv.edu.udb.desafio2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/PaymentServlet")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtener el método de pago seleccionado
        String metodoPago = request.getParameter("paymentMethod");

        // Aquí se manejaría el proceso de pago real y la actualización del estado del pedido en la base de datos
        // Simulación del procesamiento del pedido
        request.setAttribute("mensaje", "Pedido confirmado. Método de pago: " + metodoPago);

        // Redirigir a una página de confirmación de pedido
        request.getRequestDispatcher("/confirmacion.jsp").forward(request, response);
    }
}
