package Model;

public class Student {
  private int id;
  private String fullname;
  private String course;
public Student() {
	super();
}
public Student(int id) {
	super();
	this.id = id;
}
public Student(int id, String fullname, String course) {
	super();
	this.id = id;
	this.fullname = fullname;
	this.course = course;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getFullname() {
	return fullname;
}
public void setFullname(String fullname) {
	this.fullname = fullname;
}
public String getCourse() {
	return course;
}
public void setCourse(String course) {
	this.course = course;
}
}
