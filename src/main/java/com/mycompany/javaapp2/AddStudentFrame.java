package com.mycompany.javaapp2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddStudentFrame extends JFrame {
    private JTextField idField;
    private JTextField nameField;
    private JPasswordField passwordField;
    private JButton addButton;

    public AddStudentFrame() {
        setTitle("Add New Student");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField(20);
        nameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        addButton = new JButton("Add Student");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Student ID (14 digits):"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Password:"));
        panel.add(passwordField);
        panel.add(addButton);

        add(panel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String id = idField.getText().trim();
                String name = nameField.getText().trim();
                String password = new String(passwordField.getPassword());

                if (id.matches("\\d{14}") && name.matches("[a-zA-Z ]+") && !password.isEmpty()) {
                    JavaApp2.addStudent(id, name, password);
                    JOptionPane.showMessageDialog(AddStudentFrame.this, "Student added successfully!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(AddStudentFrame.this, "Invalid input. Please check the fields.");
                }
            }
        });
    }

    
}