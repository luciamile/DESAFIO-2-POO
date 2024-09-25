package sv.edu.udb.desafio2;

public class PedidoServlet {
    private int id;
    private String cliente;
    private List<String> platos;
    private String estado;
    private String comentario;

    public PedidoServlet(int id, String cliente, List<String> platos) {
        this.id = id;
        this.cliente = cliente;
        this.platos = platos;
        this.estado = "Aceptado"; // Estado inicial
        this.comentario = "";
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public String getCliente() {
        return cliente;
    }

    public List<String> getPlatos() {
        return platos;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}

