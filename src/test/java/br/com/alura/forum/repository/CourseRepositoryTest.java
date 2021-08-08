package br.com.alura.forum.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.com.alura.forum.model.Course;

@DataJpaTest
public class CourseRepositoryTest {
	
	@Autowired
	private CourseRepository repository;

	@Test
	public void shouldLoadCourseByName() {
		String courseName = "HTML 5";
		Course course = repository.findByName(courseName);
		
		Assertions.assertNotNull(course);
		Assertions.assertEquals(courseName, course.getName());
	}
	
	@Test
	public void shouldNotLoadCourseWithUnregisteredName() {
		String courseName = "JPA";
		Course course = repository.findByName(courseName);
		
		Assertions.assertNull(course);
	}


}
