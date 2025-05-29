package dao;

import businessentity.TicketDetalle;
import database.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TicketDetalleDAO implements IBaseDAO<TicketDetalle> {

    @Override
    public TicketDetalle findById(int id) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM ticket_detalle WHERE id = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new TicketDetalle(rs.getInt("id"), rs.getInt("ticket_id"), rs.getInt("producto_id"), rs.getInt("cantidad"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<TicketDetalle> findAll() {
        List<TicketDetalle> detalles = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM ticket_detalle")) {
            while (rs.next()) {
                detalles.add(new TicketDetalle(rs.getInt("id"), rs.getInt("ticket_id"), rs.getInt("producto_id"), rs.getInt("cantidad")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return detalles;
    }

    @Override
    public void save(TicketDetalle detalle) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO ticket_detalle (ticket_id, producto_id, cantidad) VALUES (?, ?, ?)")) {
            stmt.setInt(1, detalle.getTicketId());
            stmt.setInt(2, detalle.getProductoId());
            stmt.setInt(3, detalle.getCantidad());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM ticket_detalle WHERE id = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
