package com.zeta.cruddemo;

import com.zeta.cruddemo.dao.StudentDAO;
import com.zeta.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {

			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastName(studentDAO);

			//updateStudent(studentDAO);

			//deleteStudent(studentDAO);

			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students");

		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count : " + numRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId = 1;
		System.out.println("Deleting student id: " + studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId = 1;
		//retrieve student based on the id: pk
		System.out.println("Getting student with id : " + studentId);
		Student myStudent = studentDAO.findById(studentId);
		//change first name to "Scooby"
		System.out.println("Updating student.....");
		myStudent.setFirst_name("Scooby");

		// update the student
		studentDAO.update(myStudent);
		// display the updated student
		System.out.println("Updated student : " + myStudent);


	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Orozco");
		//display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
        //get a list of students
		List<Student> theStudents = studentDAO.findAll();

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		//create a student object
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("Ana", "Orozco", "pfff@gmail.com");
		//save the student
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		//display id of the saved student
        int theId = tempStudent.getId();
		System.out.println("Saved student.Generated id : " + theId);

		// retrieve student based on the id: pk
		System.out.println("Retrieving student with the id : " + theId);
		Student myStudent = studentDAO.findById(theId);
		//display student
		System.out.println("Found the student : " + myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		//create multiple students
		System.out.println("Creating 3 new student object..");
		Student tempStudent1 = new Student("Paul", "Doe", "paul@doe.com");
		Student tempStudent2 = new Student("Paul1", "Doe1", "paul@doe.com1");
		Student tempStudent3 = new Student("Paul2", "Doe2", "paul@doe.com2");
		//save the student objects
		System.out.println("Saving the  3 student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		//create the student object
		System.out.println("Creating new student object..");
		Student tempStudent = new Student("Paul", "Doe", "paul@doe.com");
		//save the student object
		System.out.println("Saving the student");
		studentDAO.save(tempStudent);
		//display id of the saved student
		System.out.println("Saved student. Generated id : " + tempStudent.getId());
	}
}
