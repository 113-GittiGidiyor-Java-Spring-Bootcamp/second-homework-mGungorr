package dev.patika.homework.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate birthDate;
    private String adress;
    private Gender gender;

    @ManyToMany(mappedBy = "students")
    private List<Courses> studentCourses = new ArrayList<>();

    public Student() {
    }

    public Student(String name, LocalDate birthDate, String adress, Gender gender) {
        this.name = name;
        this.birthDate = birthDate;
        this.adress = adress;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Courses> getStudentCourses() {
        return studentCourses;
    }

    public void setStudentCourses(List<Courses> studentCourses) {
        this.studentCourses = studentCourses;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(birthDate, student.birthDate) && Objects.equals(adress, student.adress) && gender == student.gender;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthDate, adress, gender);
    }

    @Override
    public String toString() {
        return "models.Student{" +
                "name='" + name + '\'' +
                ", birthDate=" + birthDate +
                ", adress='" + adress + '\'' +
                ", gender=" + gender +
                '}';
    }
}
