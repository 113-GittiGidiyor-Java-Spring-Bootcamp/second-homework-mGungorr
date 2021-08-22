package dev.patika.homework.model;

import javax.persistence.Entity;
import java.util.Objects;

@Entity
public class VisitingResearcher extends Instructors{
    private float hourlySalary;

    public VisitingResearcher() {
    }

    public VisitingResearcher(String instructorName, String instructorAdress, long instructorPhone, float hourlySalary) {
        super(instructorName, instructorAdress, instructorPhone);
        this.hourlySalary = hourlySalary;
    }

    public VisitingResearcher(float hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public float getHourlySalary() {
        return hourlySalary;
    }

    public void setHourlySalary(float hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VisitingResearcher that = (VisitingResearcher) o;
        return Float.compare(that.hourlySalary, hourlySalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlySalary);
    }

    @Override
    public String toString() {
        return "models.VisitingResearcher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
