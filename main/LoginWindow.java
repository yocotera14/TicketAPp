/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import javax.swing.*;
import java.awt.*;

public class LoginWindow {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginWindow().createLoginWindow());
    }

    public void createLoginWindow() {
        JFrame frame = new JFrame("Iniciar Sesión");
        frame.setSize(350, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(4, 1, 10, 10));

        JPanel userPanel = new JPanel(new FlowLayout());
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField(15);
        userPanel.add(userLabel);
        userPanel.add(userField);

        JPanel passPanel = new JPanel(new FlowLayout());
        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField(15);
        passPanel.add(passLabel);
        passPanel.add(passField);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton loginButton = new JButton("Iniciar Sesión");
        buttonPanel.add(loginButton);

        JLabel statusLabel = new JLabel("", SwingConstants.CENTER);
        statusLabel.setForeground(Color.RED);

        frame.add(userPanel);
        frame.add(passPanel);
        frame.add(buttonPanel);
        frame.add(statusLabel);

        // Acción del botón
        loginButton.addActionListener(e -> {
            String usuario = userField.getText().trim();
            String clave = new String(passField.getPassword());

            // Aquí defines usuario y clave válidos
            if (usuario.equals("admin") && clave.equals("1234")) {
                frame.dispose();  // Cierra ventana de login
                TicketAppGUI.main(null); // Abre ventana principal
            } else {
                statusLabel.setText("Usuario o contraseña incorrectos");
            }
        });

        frame.setLocationRelativeTo(null); // Centrado
        frame.setVisible(true);
    }
}
