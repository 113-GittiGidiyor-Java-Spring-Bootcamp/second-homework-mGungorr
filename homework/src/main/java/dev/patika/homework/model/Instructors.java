package dev.patika.homework.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Instructors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String instructorName;
    private String instructorAdress;
    private long instructorPhone;

    @OneToMany(mappedBy = "instructor")
    private List<Courses> courseList = new ArrayList<>();


    public Instructors(String instructorName, String instructorAdress, long instructorPhone) {
        this.instructorName = instructorName;
        this.instructorAdress = instructorAdress;
        this.instructorPhone = instructorPhone;
    }

    public Instructors(int id, String instructorName, String instructorAdress, long instructorPhone, List<Courses> courseList) {
        this.id = id;
        this.instructorName = instructorName;
        this.instructorAdress = instructorAdress;
        this.instructorPhone = instructorPhone;
        this.courseList = courseList;
    }

    public Instructors() {
    }

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorAdress() {
        return instructorAdress;
    }

    public void setInstructorAdress(String instructorAdress) {
        this.instructorAdress = instructorAdress;
    }

    public long getInstructorPhone() {
        return instructorPhone;
    }

    public void setInstructorPhone(long instructorPhone) {
        this.instructorPhone = instructorPhone;
    }

    public List<Courses> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Courses> courseList) {
        this.courseList = courseList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Instructors that = (Instructors) o;
        return instructorPhone == that.instructorPhone && Objects.equals(instructorName, that.instructorName) && Objects.equals(instructorAdress, that.instructorAdress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(instructorName, instructorAdress, instructorPhone);
    }

    @Override
    public String toString() {
        return "models.Instructors{" +
                "instructorName='" + instructorName + '\'' +
                ", instructorAdress='" + instructorAdress + '\'' +
                ", instructorPhone=" + instructorPhone +
                '}';
    }
}
