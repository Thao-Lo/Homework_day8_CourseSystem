package coding.mentor.data;

import java.util.ArrayList;

public class User {
	private String name;
	private String id;
	private String password;
	private ArrayList<Course> registeredCourses;
	private int failedCount;

	public User() {
		super();		
		// TODO Auto-generated constructor stub
	}

	
	public User(String name, String id, String password) {
		super();		
		this.name = name;
		this.id = id;
		this.password = password;
		this.registeredCourses = new ArrayList<Course>();
	}
	
	
	

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}


	public String getPassword() {
		return password;
	}


	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Course> getRegisteredCourses() {
		return registeredCourses;
	}

	public void setRegisteredCourses(Course course) {
		
		this.registeredCourses.add(course);
	
		
	}

	public int getFailedCount() {
		return failedCount;
	}

	public void setFailedCount(int failedCount) {
		this.failedCount = failedCount;
	}

}
