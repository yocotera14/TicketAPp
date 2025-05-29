package businessentity;

public class TicketDetalle {
    private int id;
    private int ticketId;
    private int productoId;
    private int cantidad;

    public TicketDetalle() {}

    public TicketDetalle(int id, int ticketId, int productoId, int cantidad) {
        this.id = id;
        this.ticketId = ticketId;
        this.productoId = productoId;
        this.cantidad = cantidad;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getTicketId() { return ticketId; }
    public void setTicketId(int ticketId) { this.ticketId = ticketId; }

    public int getProductoId() { return productoId; }
    public void setProductoId(int productoId) { this.productoId = productoId; }

    public int getCantidad() { return cantidad; }
    public void setCantidad(int cantidad) { this.cantidad = cantidad; }
}
