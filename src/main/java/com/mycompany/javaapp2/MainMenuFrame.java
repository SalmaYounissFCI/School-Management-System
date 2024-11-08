package com.mycompany.javaapp2;

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuFrame extends JFrame {
    public MainMenuFrame() {
        setTitle("School Management System");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("School Management System");
        label.setBounds(150, 30, 200, 35);
        panel.add(label);

        JButton addStudentButton = new JButton("Add Student");
        addStudentButton.setBounds(150, 80, 200, 35);
        panel.add(addStudentButton);

        JButton enrollCourseButton = new JButton("Enroll Course");
        enrollCourseButton.setBounds(150, 130, 200, 35);
        panel.add(enrollCourseButton);

        JButton removeCourseButton = new JButton("Delete Student");
        removeCourseButton.setBounds(150, 180, 200, 35);
        panel.add(removeCourseButton);

        JButton showInfoButton = new JButton("Show Student Info");
        showInfoButton.setBounds(150, 230, 200, 35);
        panel.add(showInfoButton);

        JButton exitButton = new JButton("Exit");
        exitButton.setBounds(150, 280, 200, 35);
        exitButton.setBackground(Color.PINK);  
        exitButton.setForeground(Color.BLACK);
        panel.add(exitButton);

        // Add ActionListeners to buttons
        addStudentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddStudentFrame().setVisible(true);
            }
        });

        enrollCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EnrollCourseFrame().setVisible(true);  // استدعاء نافذة تسجيل الطالب في الكورس
            }
        });

        removeCourseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeleteStudentFrame().setVisible(true);  // استدعاء نافذة حذف الطالب
            }
        });

        showInfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowStudentInfoFrame().setVisible(true);  // استدعاء نافذة عرض بيانات الطالب
            }
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
}
