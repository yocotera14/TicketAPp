package database;

import java.sql.*;

public class DBConnection {
    private static final String URL = "jdbc:sqlite:clientes.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void initDatabase() {
        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            stmt.execute("CREATE TABLE IF NOT EXISTS cliente (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL UNIQUE)");
            stmt.execute("CREATE TABLE IF NOT EXISTS producto (id INTEGER PRIMARY KEY AUTOINCREMENT, nombre TEXT NOT NULL, precio REAL NOT NULL)");
            stmt.execute("CREATE TABLE IF NOT EXISTS ticket (id INTEGER PRIMARY KEY AUTOINCREMENT, cliente_id INTEGER, fecha TEXT NOT NULL, FOREIGN KEY(cliente_id) REFERENCES cliente(id))");
            stmt.execute("CREATE TABLE IF NOT EXISTS ticket_detalle (id INTEGER PRIMARY KEY AUTOINCREMENT, ticket_id INTEGER, producto_id INTEGER, cantidad INTEGER NOT NULL, FOREIGN KEY(ticket_id) REFERENCES ticket(id), FOREIGN KEY(producto_id) REFERENCES producto(id))");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
