package com.testing.learning.instructor.dao;

import com.testing.learning.instructor.Entity.Instructor;
import com.testing.learning.instructor.Entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class AppDAOImplemnt implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImplemnt(EntityManager entityManager){
        this.entityManager=entityManager;
    }



    @Override
    @Transactional
    public void saveInstructor(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public InstructorDetail saveInstructorDetail(InstructorDetail instructorDetail) {
        entityManager.persist(instructorDetail);
        return instructorDetail;
    }

    @Override
    @Transactional
    public Instructor getInstructor(int id) {
        Instructor instructor=entityManager.find(Instructor.class, id);
        return instructor;
    }

    @Override
    @Transactional
    public String deleteInstructor(int id) {
        Instructor instructor=entityManager.find(Instructor.class,id);
        entityManager.remove(instructor);

        return "delete instructor has been done";

    }

    @Override
    @Transactional
    public InstructorDetail getInstructorDetail(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public String deleteInstructorDetail(int id) {
        InstructorDetail instructorDetail=entityManager.find(InstructorDetail.class,id);
        entityManager.remove(instructorDetail);
        return "";
    }


}
