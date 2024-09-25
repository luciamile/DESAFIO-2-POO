package sv.edu.udb.desafio2;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/DespachoPedidos")
public class DespachoPedidosServlet extends HttpServlet {
    private List<PedidoServlet> pedidos = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        // Inicializar con algunos pedidos de ejemplo
        pedidos.add(new PedidoServlet(1, "Juan Perez", Arrays.asList("Pizza", "Coca Cola")));
        pedidos.add(new PedidoServlet(2, "Ana Lopez", Arrays.asList("Ensalada", "Agua")));
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("pedidos", pedidos);
        request.getRequestDispatcher("despachoPedidos.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int pedidoId = Integer.parseInt(request.getParameter("pedidoId"));
        String estado = request.getParameter("estado");
        String comentario = request.getParameter("comentario");

        // Buscar el pedido y actualizarlo
        for (PedidoServlet pedido : pedidos) {
            if (pedido.getId() == pedidoId) {
                pedido.setEstado(estado);
                pedido.setComentario(comentario);
                break;
            }
        }

        response.sendRedirect("DespachoPedidos");
    }
}
