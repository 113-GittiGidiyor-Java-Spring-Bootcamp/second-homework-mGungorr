package dev.patika.homework.service;

import dev.patika.homework.model.Courses;
import dev.patika.homework.repository.CourseRepository;
import dev.patika.homework.repository.CrudRepository;
import dev.patika.homework.utils.EntityManagerUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class CourseService implements CrudRepository<Courses>, CourseRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Courses> findAll() {
        return em.createQuery("select c from Courses c",Courses.class).getResultList();
    }

    @Override
    public Courses findById(int id) {
        return em.find(Courses.class, id);
    }

    @Override
    public void saveToDatabase(Courses course) {
        em.getTransaction().begin();
        em.persist(course);
        em.getTransaction().commit();
    }

    @Override
    public void updateOnDatabase(Courses object) {

    }

    @Override
    public void deleteCourseFromDatabase(int courseCode) {
        em.getTransaction().begin();
        Courses courses = em.createQuery("from Courses c WHERE c.courseCode =:ssid",Courses.class).setParameter("ssid",courseCode).getSingleResult();
        em.remove(courses);
        em.getTransaction().commit();
    }

}
