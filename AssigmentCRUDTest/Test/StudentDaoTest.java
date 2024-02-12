import static org.junit.jupiter.api.Assertions.*;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Dao.StudentDao;
import Model.Student;

class StudentDaoTest {

    private StudentDao studentDao;

    @BeforeEach
    public void setUp() throws Exception {
        // Initialize StudentDao
        studentDao = new StudentDao();
    }

    @AfterEach
    public void tearDown() throws Exception {
        // Cleanup resources if needed
    }

    @Test
    public void testRegister() {
        Student student = new Student();
        student.setId(24601);
        student.setFullname("Kevin");
        student.setCourse("Best");

        String result = studentDao.register(student);
        assertEquals("Successfully inserted", result);
    }
    
    @Test
    public void testUpdate() {
        Student student = new Student();
        student.setId(24601);
        student.setFullname("Kevin");
        student.setCourse("Linux");

       String result = studentDao.update(student);
        assertEquals("Successfully Updated", result);
    }



    @Test
    public void testSearch() throws SQLException {
        Student student = new Student();
        student.setId(24601);

        ResultSet resultSet = studentDao.search(student);
        assertNotNull(resultSet);

        // Check if ResultSet contains data
       assertTrue(resultSet.next());

        // Retrieve data from ResultSet
        int id = resultSet.getInt("id");
        String fullname = resultSet.getString("fullname").trim();;
        String course = resultSet.getString("course").trim();;

        // Verify retrieved data
        assertEquals(24601, id);
        assertEquals("Kevin", fullname);
        assertEquals("Linux", course);
    }

    @Test
    public void testStudentList() throws SQLException {
    	Student student = new Student();
    	ResultSet resultSet = studentDao.studentlist(student);
        assertNotNull(resultSet);

        // Check if ResultSet contains data
        assertTrue(resultSet.next());

        // Retrieve data from ResultSet
        int id = resultSet.getInt("id");
        String fullname = resultSet.getString("fullname").trim();
        String course = resultSet.getString("course").trim();

        // Verify retrieved data
        assertEquals(24601, id);
        assertEquals("Kevin", fullname);
        assertEquals("Linux", course);
    }
    
    
        @Test
    public void testDelete() {
        Student student = new Student();
        student.setId(24601);

        String result = studentDao.delete(student);
        assertEquals("Successfully Deleted", result);
    }
}
