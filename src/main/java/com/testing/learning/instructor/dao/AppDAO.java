package com.testing.learning.instructor.dao;


import com.testing.learning.instructor.Entity.Instructor;
import com.testing.learning.instructor.Entity.InstructorDetail;

public interface AppDAO {

    void saveInstructor(Instructor instructor);
    InstructorDetail saveInstructorDetail(InstructorDetail instructorDetail);
    Instructor getInstructor(int id);
    String deleteInstructor(int id);
    InstructorDetail getInstructorDetail(int id);
    String deleteInstructorDetail(int id);
}
