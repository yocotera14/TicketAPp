package businessentity;

import java.time.LocalDate;

public class Ticket {
    private int id;
    private int clienteId;
    private LocalDate fecha;

    public Ticket() {}

    public Ticket(int id, int clienteId, LocalDate fecha) {
        this.id = id;
        this.clienteId = clienteId;
        this.fecha = fecha;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getClienteId() { return clienteId; }
    public void setClienteId(int clienteId) { this.clienteId = clienteId; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}
