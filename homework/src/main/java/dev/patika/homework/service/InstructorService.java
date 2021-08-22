package dev.patika.homework.service;

import dev.patika.homework.model.Courses;
import dev.patika.homework.model.Instructors;
import dev.patika.homework.repository.CrudRepository;
import dev.patika.homework.repository.InstructorRepository;
import dev.patika.homework.utils.EntityManagerUtils;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class InstructorService implements CrudRepository<Instructors>, InstructorRepository {

    EntityManager em = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Instructors> findAll() {
        return em.createQuery("select c from Instructors c",Instructors.class).getResultList();
    }

    @Override
    public Instructors findById(int id) {
        return em.find(Instructors.class, id);
    }

    @Override
    public void saveToDatabase(Instructors instructors) {
        em.getTransaction().begin();
        em.persist(instructors);
        em.getTransaction().commit();
    }

    @Override
    public void updateOnDatabase(Instructors object) {

    }

    @Override
    public void deleteCourseFromDatabase(int id) {

    }

}

