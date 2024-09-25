package sv.edu.udb.desafio2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet("/LoginServlet")
public class LoginServlet<HttpServletRequest> extends HttpServlet {

    @Override
    protected <HttpServletResponse> void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password;
        password = request.getParameter("password");

        try {
            // Conectar a la base de datos
            Object DatabaseConnection = null;
            Connection conn = DatabaseConnection.initializeDatabase();  // Asegúrate de tener tu clase de conexión

            // Comprobar si el usuario existe en la base de datos
            String query = "SELECT * FROM usuarios WHERE email = ? AND password = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);  // Si estás cifrando la contraseña, debes hacer la comparación adecuada

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String tipoUsuario = rs.getString("tipo_usuario");

                // Redirigir al usuario según su rol
                if ("cliente".equals(tipoUsuario)) {
                    // Redirigir al menú de cliente
                    request.getSession().setAttribute("usuario", email);
                    response.sendRedirect("cliente/menu.jsp");
                } else if ("empleado".equals(tipoUsuario)) {
                    // Redirigir a la página de empleados
                    request.getSession().setAttribute("usuario", email);
                    response.sendRedirect("empleado/pedidos.jsp");
                }
            } else {
                // Redirigir de vuelta al login si la autenticación falla
                response.sendRedirect("login.jsp?error=invalid");
            }

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=db");
        }
    }
}
