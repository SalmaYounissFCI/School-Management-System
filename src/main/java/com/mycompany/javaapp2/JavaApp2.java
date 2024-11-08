package com.mycompany.javaapp2;

import javax.swing.*;

public class JavaApp2 {
    public static Student[] students = new Student[100];  
    public static int studentCount = 0;  
    public static Course[] courses = new Course[5];  
    public static int courseCount = 0; 

    public static void main(String[] args) {
        
        courses[courseCount++] = new Course("CS101", "Introduction to Computer Science", 3);
        courses[courseCount++] = new Course("MATH101", "Calculus I", 4);
        courses[courseCount++] = new Course("PHY101", "Physics I", 3);
        
        MainMenuFrame frame = new MainMenuFrame();
        frame.setVisible(true);
    }

    public static void addStudent(String id, String name, String password) {
        
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId().equals(id)) {
                JOptionPane.showMessageDialog(null, "Student ID already exists!");
                return;  
            }
        }

        students[studentCount] = new Student(id, name, password);
        studentCount++;
        JOptionPane.showMessageDialog(null, "Student added successfully!");
    }
    public static boolean deleteStudent(String id) {
    for (int i = 0; i < studentCount; i++) {
        if (students[i].getId().equals(id)) {
            students[i] = students[studentCount - 1];  // Replace with the last student
            students[studentCount - 1] = null;  // Remove the last student
            studentCount--;  // Reduce the count
            return true;  // Successfully deleted
        }
    }
    return false;  // Student not found
}
}