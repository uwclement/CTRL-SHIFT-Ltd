import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.Test;

import Dao.CourseDao;
import Model.Course;

class CourseDaoTest {

   private CourseDao  courseDao;
   Course  course = new Course();
   @BeforeEach
   public void setUp() throws Exception {
	   courseDao = new CourseDao();
   }
   
   @AfterEach
   public void tearDown() throws Exception
   {
	   
   }
	
   @Test
   public void registerTest() throws Exception
   {
	   course.setCourseId(100);
	   course.setCourseName("Software Testing");
	   
	   String result = courseDao.register(course);
	   assertEquals("Successfully inserted", result);
   }
   
   @Test
   public void searchTest() throws Exception 
   {
	   course.setCourseId(100);
	   ResultSet result = courseDao.search(course);
	   assertNotNull(result);
	   
	   assertTrue(result.next());
	   int id = result.getInt("crid");
	   String name = result.getString("crname").trim();
	   
	   assertEquals(100,id);
	   assertEquals("Software Testing",name);
   }
   
   @Test 
   public void courseList() throws Exception
   {
	   ResultSet result = courseDao.Courselist(course);
	   assertNotNull(result);
	   
	   assertTrue(result.next());
	   int id = result.getInt("crid");
	   String name = result.getString("crname").trim();
	   
	   assertEquals(100,id);
	   assertEquals("Software Testing",name);
   }
 
   @Test
   public void courseupdate () throws Exception
   {
	   course.setCourseId(100);
	   course.setCourseName("WebTech");
	   
	   String actual = courseDao.update(course);
	   assertEquals("Successfully Updated", actual);
   }
   
   @Test
   public void coursedelete () throws Exception
   {
	   course.setCourseId(100);
	   
	   String actual = courseDao.delete(course);
	   assertEquals("Successfully Deleted", actual);
   }
}
