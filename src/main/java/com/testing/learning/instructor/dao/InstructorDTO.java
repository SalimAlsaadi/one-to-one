package com.testing.learning.instructor.dao;

import com.testing.learning.instructor.Entity.Instructor;
import com.testing.learning.instructor.Entity.InstructorDetail;

public class InstructorDTO {
    private Instructor instructor;
    private InstructorDetail instructorDetail;

    // Getters and setters
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }
}
