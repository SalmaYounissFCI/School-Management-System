package com.mycompany.javaapp2;

public class Student {
    private String id;
    private String name;
    private String password;
    private Course[] courses;
    private int enrolledCourseCount;

    public Student(String id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.courses = new Course[5];
        this.enrolledCourseCount = 0;
    }

    public String getId() {
        return id;
    }

    public boolean verifyPassword(String password) {
        return this.password.equals(password);
    }

    public void enrollCourse(Course course) {
        if (enrolledCourseCount < 5) {
            courses[enrolledCourseCount] = course;
            enrolledCourseCount++;
        } else {
            System.out.println("Maximum courses enrolled.");
        }
    }

    public void removeCourse(String courseId) {
        for (int i = 0; i < enrolledCourseCount; i++) {
            if (courses[i].getCourseId().equals(courseId)) {
                courses[i] = courses[enrolledCourseCount - 1];
                courses[enrolledCourseCount - 1] = null;
                enrolledCourseCount--;
                return;
            }
        }
    }

    public void showInfo() {
        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Enrolled Courses:");
        for (int i = 0; i < enrolledCourseCount; i++) {
            System.out.println(courses[i]);
        }
    }
    public String getInfo() {
    StringBuilder info = new StringBuilder();
    info.append("Student ID: ").append(id).append("\n");
    info.append("Name: ").append(name).append("\n");
    info.append("Enrolled Courses:\n");
    for (int i = 0; i < enrolledCourseCount; i++) {
        info.append(courses[i]).append("\n");
    }
    return info.toString();
}

}