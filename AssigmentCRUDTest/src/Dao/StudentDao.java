package Dao;
import Model.*;
import java.sql.*;
public class StudentDao {
	String url ="jdbc:postgresql://localhost/MyDatabase";
	  String user ="postgres";
	 String password="cle111";
	public String register(Student studentobj){
	       
		try {
	        Connection con = DriverManager.getConnection(url, user, password);
	        String query = "INSERT INTO \"Student\" (id, fullname, course) VALUES (?, ?, ?)";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setInt(1, studentobj.getId());
	        st.setString(2, studentobj.getFullname());
	        st.setString(3, studentobj.getCourse());
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
	
	
	public String update(Student studentobj){
	       
		try {
	        Connection con = DriverManager.getConnection(url, user, password);
	        String query = "UPDATE \"Student\" SET  fullname=?, course=? WHERE id=?";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setString(1, studentobj.getFullname());
	        st.setString(2, studentobj.getCourse());
	        st.setInt(3, studentobj.getId());
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
	
	public String delete(Student studentobj){
	       
		try {
	        Connection con = DriverManager.getConnection(url, user, password);
	        String query = "DELETE FROM \"Student\"  WHERE id=?";
	        PreparedStatement st = con.prepareStatement(query);
	        st.setInt(1, studentobj.getId());
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
	
	
	 public ResultSet search (Student studentvar){
		   
	        try {
	              Connection con =DriverManager.getConnection(url, user, password);
	           PreparedStatement pst =con.prepareStatement("select * from \"Student\" where id=?");
	           pst.setInt(1, studentvar.getId());
	           return pst.executeQuery();
	          
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    
	    }
	    
	    public ResultSet studentlist (Student studentvar){
	   
	        try {
	              Connection con =DriverManager.getConnection(url, user, password);
	           PreparedStatement pst =con.prepareStatement("select * from \"Student\"");
	         
	           return pst.executeQuery();
	          
	        } catch (Exception ex) {
	            ex.printStackTrace();
	        }
	        return null;
	    
	    }
}
