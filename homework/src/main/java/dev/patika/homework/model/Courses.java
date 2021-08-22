package dev.patika.homework.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String courseName;
    private int courseCode;
    private int courseCreditPoint;

    @ManyToMany
    private List<Student> students = new ArrayList<>();

    @ManyToOne
    private Instructors instructor;

    public Courses() {
    }

    public Courses(String courseName, int courseCode, int courseCreditPoint) {
        this.courseName = courseName;
        this.courseCode = courseCode;
        this.courseCreditPoint = courseCreditPoint;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public int getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(int courseCode) {
        this.courseCode = courseCode;
    }

    public int getCourseCreditPoint() {
        return courseCreditPoint;
    }

    public void setCourseCreditPoint(int courseCreditPoint) {
        this.courseCreditPoint = courseCreditPoint;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Instructors getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructors instructor) {
        this.instructor = instructor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Courses courses = (Courses) o;
        return courseCode == courses.courseCode && courseCreditPoint == courses.courseCreditPoint && Objects.equals(courseName, courses.courseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseName, courseCode, courseCreditPoint);
    }

    @Override
    public String toString() {
        return "models.Courses{" +
                "courseName='" + courseName + '\'' +
                ", courseCode=" + courseCode +
                ", courseCreditPoint=" + courseCreditPoint +
                '}';
    }
}
