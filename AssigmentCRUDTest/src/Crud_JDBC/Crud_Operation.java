package Crud_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import Model.*;
import Dao.*;
public class Crud_Operation {

public static void main(String[] args) {
	 boolean conditon = true;
	 boolean section = true;
     int id;
     String fullname;
     String course;
     String coursename;
     int courseid;
     Student stud = new Student();
     StudentDao dao = new StudentDao();
     Course cr = new Course();
     CourseDao crdao = new CourseDao();
     String feedback;
         System.out.println("=========================");
        System.out.println("STUDENT MANAGMENT SYSTEM");
        System.out.println("------------------------");
        System.out.println("1. COURSE ");
        System.out.println("2. STUDENT ");
        System.out.print("Choose: ");
        Scanner input = new Scanner(System.in);
        int Choice1 = input.nextInt();
       if (Choice1 == 2) {
    	  
      while(conditon){
          System.out.println("=========================");
         System.out.println("STUDENT MANAGMENT SYSTEM");
         System.out.println("------------------------");
         System.out.println("1. Register Student ");
         System.out.println("2. Update Student ");
         System.out.println("3. Delete Student ");
         System.out.println("4. Retrieve All Student");
         System.out.println("5. Search Student By ID");
         System.out.println("0. Exit");
         System.out.println("----------------");
         System.out.print("Choose: ");
         Scanner input2 = new Scanner(System.in);
         int Choice = input.nextInt();
         switch(Choice){
         case 1:
              System.out.print("Enter Student Id:");
             id =Integer.parseInt(input.next());
             System.out.print("Enter FullNamme:");
             fullname =input.next();
             System.out.print("Enter Course:");
             course =input.next();
             stud.setId(id);
             stud.setFullname(fullname);
             stud.setCourse(course);
             feedback = dao.register(stud);
             System.out.println(feedback);
             break;
         case 2:
             System.out.print("Enter Student Id:");
            id =Integer.parseInt(input.next());
            System.out.print("Enter FullNamme:");
            fullname =input.next();
            System.out.print("Enter Course:");
            course =input.next();
            stud.setId(id);
            stud.setFullname(fullname);
            stud.setCourse(course);
            feedback = dao.update(stud);
            System.out.println(feedback);
            break;
         case 3:
             System.out.print("Enter Student Id:");
            id =Integer.parseInt(input.next());
            stud.setId(id);
            feedback = dao.delete(stud);
            System.out.println(feedback);
            break; 
         case 4:
        	   
        	    ResultSet seek = dao.studentlist(stud);

        	    try {
        	        while (seek.next()) {
        	            int studentId = seek.getInt("id");
        	            fullname = seek.getString("fullname");
        	            course = seek.getString("course");
        	            System.out.println("Student ID: " + studentId + ", Fullname: " + fullname + ", Course: " + course);
        	        }
        	    } catch (SQLException ex) {
        	        ex.printStackTrace();
        	    }
        	    break;


         case 5:
        	    System.out.print("Enter Student Id:");
        	    id = Integer.parseInt(input.next());
        	    stud.setId(id);
        	    ResultSet feed = dao.search(stud);
        	    try {
        	        while (feed.next()) {
        	            int studentId = feed.getInt("id");
        	            fullname = feed.getString("fullname");
        	             course = feed.getString("course");
        	            System.out.println("Student ID: " + studentId + ", Fullname: " + fullname + ", Course: " + course);
        	        }
        	    } catch (SQLException ex) {
        	        ex.printStackTrace();
        	    }
        	    break;
         case 0:
        	 System.exit(0);
         }
      }
      
       }else {
    	   while(conditon){
    	          System.out.println("=========================");
    	         System.out.println("STUDENT MANAGMENT SYSTEM");
    	         System.out.println("------------------------");
    	         System.out.println("1. Register Course ");
    	         System.out.println("2. Update Course ");
    	         System.out.println("3. Delete Course ");
    	         System.out.println("4. Retrieve All Course ");
    	         System.out.println("5. Search Course By ID");
    	         System.out.println("0. Exit");
    	         System.out.println("----------------");
    	         System.out.print("Choose: ");
    	         Scanner input2 = new Scanner(System.in);
    	         int Choice = input.nextInt();
    	         switch(Choice){
    	         case 1:
    	              System.out.print("Enter Course Id:");
    	             courseid =Integer.parseInt(input.next());
    	             System.out.print("Enter Course Name:");
    	             coursename =input.next();
    	             cr.setCourseId(courseid);
    	             cr.setCourseName(coursename);;
    	             feedback = crdao.register(cr);
    	             System.out.println(feedback);
    	             break; 
        	 
         }
        	 
             
 }
       }
}}


