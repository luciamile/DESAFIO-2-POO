package sv.edu.udb.desafio2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// Servlet encargado de mostrar el menú al cliente
@WebServlet("/MenuServlet")
public class MenuServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Aquí iría la lógica para obtener los platos desde la base de datos
        // Ejemplo de un menú simulado
        List<String> menu = List.of("Pizza", "Hamburguesa", "Ensalada", "Tacos", "Bebida");

        // Enviando el menú como atributo para ser visualizado en la JSP
        request.setAttribute("menu", menu);

        // Redirigir a la página JSP que muestra el menú
        request.getRequestDispatcher("/menu.jsp").forward(request, response);
    }
}
