package dev.patika.homework.service;

import dev.patika.homework.model.Courses;
import dev.patika.homework.model.Student;
import dev.patika.homework.repository.CrudRepository;
import dev.patika.homework.repository.StudentRepository;
import dev.patika.homework.utils.EntityManagerUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class StudentService implements CrudRepository<Student>, StudentRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {
        return em.createQuery("select c from Student c",Student.class).getResultList();
    }

    @Override
    public Student findById(int id) {
        return em.find(Student.class, id);
    }

    @Override
    public void saveToDatabase(Student student) {
        em.getTransaction().begin();
        em.persist(student);
        em.getTransaction().commit();
    }

    @Override
    public void updateOnDatabase(Student object) {

    }

    @Override
    public void deleteCourseFromDatabase(int id) {

    }

}
