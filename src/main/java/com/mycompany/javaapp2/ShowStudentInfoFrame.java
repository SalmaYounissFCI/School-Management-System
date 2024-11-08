package com.mycompany.javaapp2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShowStudentInfoFrame extends JFrame {
    private JTextField idField;
    private JTextArea infoArea;
    private JButton showInfoButton;

    public ShowStudentInfoFrame() {
        setTitle("Show Student Info");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        idField = new JTextField(20);
        infoArea = new JTextArea(10,20);
        infoArea.setEditable(false);
        showInfoButton = new JButton("Show Info");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(new JLabel("Student ID (16 digits):"));
        panel.add(idField);
        panel.add(showInfoButton);
        panel.add(new JScrollPane(infoArea));  

        add(panel);

        showInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = idField.getText().trim();

                Student student = findStudentById(studentId);
                if (student != null) {
                    infoArea.setText(student.getInfo());  
                } else {
                    JOptionPane.showMessageDialog(ShowStudentInfoFrame.this, "Student not found!");
                }
            }
        });
    }

    private Student findStudentById(String studentId) {
        for (int i = 0; i < JavaApp2.studentCount; i++) {
            if (JavaApp2.students[i].getId().equals(studentId)) {
                return JavaApp2.students[i];
            }
        }
        return null;
    }

   
}
