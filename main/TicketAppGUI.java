/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import businessentity.Cliente;
import dao.ClienteDAO;
import database.DBConnection;

public class TicketAppGUI {

    public static void main(String[] args) {
        DBConnection.initDatabase();
        ClienteDAO clienteDAO = new ClienteDAO();

        // Crear ventana principal
        JFrame frame = new JFrame("Gestión de Clientes");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 400);
        frame.setLayout(new BorderLayout());

        // Panel superior: entrada y botones
        JPanel topPanel = new JPanel(new GridLayout(3, 1, 5, 5));
        topPanel.setBackground(new Color(220, 240, 255)); 
        // Subpanel de entrada
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel label = new JLabel("Nombre:");
        JTextField nombreField = new JTextField(20);
        inputPanel.add(label);
        inputPanel.add(nombreField);

        // Subpanel de botones
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton btnRegistrar = new JButton("Registrar");
        JButton btnListar = new JButton("Listar");
        JButton btnEliminar = new JButton("Eliminar");
        btnRegistrar.setBackground(Color.GREEN);
        btnRegistrar.setForeground(Color.WHITE);
        btnListar.setBackground(Color.BLUE);
        btnListar.setForeground(Color.WHITE);
        btnEliminar.setBackground(Color.RED);
        btnEliminar.setForeground(Color.WHITE);
        buttonPanel.add(btnRegistrar);
        buttonPanel.add(btnListar);
        buttonPanel.add(btnEliminar);

        // Subpanel vacío para espacio 
        JPanel spacer = new JPanel();

        topPanel.add(inputPanel);
        topPanel.add(buttonPanel);
        topPanel.add(spacer);

        // Panel central: resultados
        JTextArea output = new JTextArea();
        output.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(output);
        output.setBackground(Color.BLACK);
        output.setForeground(Color.GREEN);
        output.setFont(new Font("Monospaced", Font.PLAIN, 13));

        // Añadir paneles a la ventana
        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        
        

        // Acción: Registrar cliente
        btnRegistrar.addActionListener(e -> {
            String nombre = nombreField.getText().trim();
            if (nombre.isEmpty()) {
                output.setText("Por favor, ingresa un nombre.");
                return;
            }

            Cliente cliente = clienteDAO.findByName(nombre);
            if (cliente == null) {
                cliente = new Cliente(0, nombre);
                clienteDAO.save(cliente);
                cliente = clienteDAO.findByName(nombre);
                output.setText("Cliente registrado:\nID: " + cliente.getId() + "\nNombre: " + cliente.getNombre());
            } else {
                output.setText("El cliente ya existe:\nID: " + cliente.getId() + "\nNombre: " + cliente.getNombre());
            }
        });

        // Acción: Listar clientes
        btnListar.addActionListener(e -> {
            List<Cliente> clientes = clienteDAO.findAll();
            if (clientes.isEmpty()) {
                output.setText("No hay clientes registrados.");
                return;
            }

            StringBuilder sb = new StringBuilder("Lista de clientes:\n");
            for (Cliente c : clientes) {
                sb.append("ID: ").append(c.getId()).append(" | Nombre: ").append(c.getNombre()).append("\n");
            }
            output.setText(sb.toString());
        });

        // Acción: Eliminar cliente
        btnEliminar.addActionListener(e -> {
            String nombre = nombreField.getText().trim();
            if (nombre.isEmpty()) {
                output.setText("Ingresa un nombre para eliminar.");
                return;
            }

            Cliente cliente = clienteDAO.findByName(nombre);
            if (cliente != null) {
                clienteDAO.delete(cliente.getId());
                output.setText("Cliente eliminado:\nID: " + cliente.getId() + "\nNombre: " + cliente.getNombre());
            } else {
                output.setText("Cliente no encontrado.");
            }
        });

        // Mostrar ventana
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}

