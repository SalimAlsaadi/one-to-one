package com.testing.learning.instructor.Controller;

import com.testing.learning.instructor.Entity.Instructor;
import com.testing.learning.instructor.Entity.InstructorDetail;
import com.testing.learning.instructor.dao.AppDAOImplemnt;
import com.testing.learning.instructor.dao.InstructorDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dao")
public class ControllerMethods {

    private AppDAOImplemnt appDAOImplemnt;

    public ControllerMethods(){}

    @Autowired
    public ControllerMethods(AppDAOImplemnt appDAOImplemnt){
        this.appDAOImplemnt=appDAOImplemnt;
    }


    @PostMapping("/save")
    public String saveInstructor(@RequestBody InstructorDTO instructorDTO){
       InstructorDetail instructorDetail=instructorDTO.getInstructorDetail();
       Instructor instructor=instructorDTO.getInstructor();
       instructor.setInstructorDetail(instructorDetail);
       appDAOImplemnt.saveInstructorDetail(instructorDetail);
       appDAOImplemnt.saveInstructor(instructor);
        return "Done";
    }

    @GetMapping("/getInstructor/{id}")
    public ResponseEntity<?> getInstructor(@PathVariable int id) {
        Instructor instructor = appDAOImplemnt.getInstructor(id);

        // Check if instructor is found
        if (instructor != null) {
            return new ResponseEntity<>(instructor, HttpStatus.OK);  // Return found instructor with 200 OK
        } else {
            // Return a 404 Not Found status with an error message
            return new ResponseEntity<>("Instructor not found with id: " + id, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/getInstructorDetail/{id}")
    public InstructorDetail getInstructorDetail(@PathVariable int id){
    return appDAOImplemnt.getInstructorDetail(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteInstructor(@PathVariable int id){

    return appDAOImplemnt.deleteInstructor(id);
    }

    @DeleteMapping("/deletedetail/{id}")
    public String deleteInstructorDetail(@PathVariable int id){
    return appDAOImplemnt.deleteInstructorDetail(id);
    }

}
