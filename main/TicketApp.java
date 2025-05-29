package main;

import businessentity.Cliente;
import dao.IBaseDAO;
import database.DBConnection;
import dao.ClienteDAO;
import java.util.Scanner;

public class TicketApp {
    public static void main(String[] args) {
        DBConnection.initDatabase();
        IBaseDAO<Cliente> clienteDAO = new ClienteDAO();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.nextLine();

        Cliente cliente = ((ClienteDAO)clienteDAO).findByName(nombre);
        if (cliente == null) {
            System.out.println("Cliente no encontrado. Creando...");
            cliente = new Cliente(0, nombre);
            clienteDAO.save(cliente);
            cliente = ((ClienteDAO)clienteDAO).findByName(nombre);
        }

        System.out.println("Cliente registrado:");
        System.out.println("ID: " + cliente.getId());
        System.out.println("Nombre: " + cliente.getNombre());
    }
}
