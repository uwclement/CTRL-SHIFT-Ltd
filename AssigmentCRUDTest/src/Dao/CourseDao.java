package Dao;
import Model.*;
import java.sql.*;
public class CourseDao {
	String url ="jdbc:postgresql://localhost/MyDatabase";
	  String user ="postgres";
	 String password="cle111";
	public String register(Course Courseobj){
	       
		try {
	        Connection con = DriverManager.getConnection(url, user, password);
	        String query = "INSERT INTO Course (crid, crname) VALUES (?, ?)";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setInt(1, Courseobj.getCourseId());
	        st.setString(2, Courseobj.getCourseName());
	        int rowAffected = st.executeUpdate();
	        con.close();
	        if (rowAffected >= 1) {
	            return "Successfully inserted";
	        } else {
	            return "Not inserted";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return "Database error: " + e.getMessage();
	    } catch (Exception e) {

	        e.printStackTrace();
	        return "Server error: " + e.getMessage();
	    }
        }
	
	
	public String update(Course Courseobj){
	       
		try {
	        Connection con = DriverManager.getConnection(url, user, password);
	        String query = "UPDATE Course SET  crname=? WHERE crid=?";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setString(1, Courseobj.getCourseName());
	        st.setInt(2, Courseobj.getCourseId());
	        int rowAffected = st.executeUpdate();
	        con.close();
	        if (rowAffected >= 1) {
	            return "Successfully Updated";
	        } else {
	            return "Not updated";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return "Database error: " + e.getMessage();
	    } catch (Exception e) {

	        e.printStackTrace();
	        return "Server error: " + e.getMessage();
	    }
        }
	
	public String delete(Course Courseobj){
	       
		try {
	        Connection con = DriverManager.getConnection(url, user, password);
	        String query = "DELETE FROM Course  WHERE crid=?";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setInt(1, Courseobj.getCourseId());
	        int rowAffected = st.executeUpdate();
	        con.close();
	        if (rowAffected >= 1) {
	            return "Successfully Deleted";
	        } else {
	            return "Not Deleted";
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return "Database error: " + e.getMessage();
	    } catch (Exception e) {

	        e.printStackTrace();
	        return "Server error: " + e.getMessage();
	    }
        }
	
	
	 public ResultSet search (Course Coursevar){
		   
	        try {
	              Connection con =DriverManager.getConnection(url, user, password);
	           PreparedStatement pst =con.prepareStatement("select * from Course where crid=?");
	           pst.setInt(1, Coursevar.getCourseId());
	           return pst.executeQuery();
	          
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    
	    }
	    
	    public ResultSet Courselist (Course Coursevar){
	   
	        try {
	              Connection con =DriverManager.getConnection(url, user, password);
	           PreparedStatement pst =con.prepareStatement("select * from Course");
	         
	           return pst.executeQuery();
	          
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    
	    }
}
