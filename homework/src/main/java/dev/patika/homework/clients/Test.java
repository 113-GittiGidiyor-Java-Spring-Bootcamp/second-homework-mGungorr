package dev.patika.homework.clients;

import dev.patika.homework.controller.CourseController;
import dev.patika.homework.model.*;
import dev.patika.homework.service.CourseService;
import dev.patika.homework.utils.EntityManagerUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        CourseService courseService;
//        //saveTestData();
////        CourseController courseController = new CourseController();
////        courseController.deleteCourseFromDatabase(101);
//        List<Courses> returnedList = new CourseController(courseService).findAll();
//
//        System.out.println("---------Courses---------");
//        System.out.println("ID | NAME | CODE | CREDIT");
//        System.out.println("-------------------------");
//        for (Courses courses : returnedList) {
//            System.out.println(courses.getId() + " | " + courses.getCourseName() + " | " + courses.getCourseCode() + " | " + courses.getCourseCreditPoint());
//        }
    }

    private static void saveTestData() {
        Student student1 = new Student("Mustafa Güngör", LocalDate.of(1997, Month.MARCH, 18), "Eskişehir", Gender.MALE);
        Student student2 = new Student("Mehmet Doğan", LocalDate.of(1985, Month.APRIL, 11), "Ankara", Gender.MALE);
        Student student3 = new Student("Ayşe Şahin", LocalDate.of(2006, Month.MAY, 20), "İstanbul", Gender.FEMALE);

        Instructors instructor1 = new PermanentInstructor("Koray Güney", "İstanbul", 05071234567, 5000);
        Instructors instructor2 = new PermanentInstructor("Hüseyin Avcı", "İstanbul", 05070000000, 6000);
        Instructors instructor3 = new VisitingResearcher("Nazmi Aksoy", "Ankara", 05071111111, 1000);

        Courses course1 = new Courses("Math", 101, 4);
        Courses course2 = new Courses("Physics", 102, 4);
        Courses course3 = new Courses("Programming", 103, 8);

        course1.setInstructor(instructor1);
        course2.setInstructor(instructor2);
        course3.setInstructor(instructor3);

        course1.getStudents().add(student1);
        course1.getStudents().add(student2);
        course2.getStudents().add(student3);

        EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

        try {
            em.getTransaction().begin();
            em.persist(student1);
            em.persist(student2);
            em.persist(student3);

            em.persist(course1);
            em.persist(course2);
            em.persist(course3);

            em.persist(instructor1);
            em.persist(instructor2);
            em.persist(instructor3);

            em.getTransaction().commit();

            System.out.println("All Data Persisted.......");

        } catch (Exception e) {
            em.getTransaction().rollback();
        } finally {
            EntityManagerUtils.closeEntityManager(em);
        }

    }
}
