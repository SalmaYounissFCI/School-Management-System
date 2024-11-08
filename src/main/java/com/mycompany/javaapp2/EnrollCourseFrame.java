package com.mycompany.javaapp2;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EnrollCourseFrame extends JFrame {
    private JComboBox<Course> courseComboBox;
    private JTextField studentIdField;
    private JButton enrollButton;

    public EnrollCourseFrame() {
        setTitle("Enroll in Course");
        setSize(300, 150);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        studentIdField = new JTextField(10);  
        courseComboBox = new JComboBox<>(JavaApp2.courses); 
        enrollButton = new JButton("Enroll in Course");

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));  // ترتيب رأسي للعناصر

        // إضافة الحقول والأزرار إلى اللوحة

        panel.add(new JLabel("Student ID (14 digits):"));
        panel.add(studentIdField);
        panel.add(new JLabel("Select Course:"));
        panel.add(courseComboBox);
        panel.add(enrollButton);

        add(panel);  

        enrollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String studentId = studentIdField.getText().trim();

                Student student = findStudentById(studentId);
                if (student != null) {
                    Course selectedCourse = (Course) courseComboBox.getSelectedItem();
                    if (selectedCourse != null) {
                        student.enrollCourse(selectedCourse);  // تسجيل الطالب في الكورس
                        JOptionPane.showMessageDialog(EnrollCourseFrame.this, "Student enrolled in course successfully!");
                    }
                } else {
                    JOptionPane.showMessageDialog(EnrollCourseFrame.this, "Student not found!");
                }
            }
        });
    }

    // دالة للبحث عن الطالب باستخدام ID
    private Student findStudentById(String studentId) {
        for (int i = 0; i < JavaApp2.studentCount; i++) {
            if (JavaApp2.students[i].getId().equals(studentId)) {
                return JavaApp2.students[i];
            }
        }
        return null;
    }

    public static void main(String[] args) {
        EnrollCourseFrame enrollCourseFrame = new EnrollCourseFrame();
        enrollCourseFrame.setVisible(true);
    }
}
