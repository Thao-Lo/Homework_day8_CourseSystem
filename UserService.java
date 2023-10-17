package coding.mentor.service;

import java.util.ArrayList;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.data.User;
import coding.mentor.db.Database;

public class UserService {
	

	public void registerNewUser(String name, String id, String password) {
		

		
		for (int i = 0; i < Database.USERS_DB.size(); i++) {
			if (Database.USERS_DB.get(i).getId().equals(id)) {
				System.out.println("ID is unavailable");
				System.out.println("Please register again with different user ID");
				break;
			}
		}
		
		User user = new User(name, id, password);

		
		Database.USERS_DB.add(user);
		System.out.println("size: " + Database.USERS_DB.size());
		System.out.println("Register successfully");
		
	}

	public int findUser(String id) {

		for (int i = 0; i < Database.USERS_DB.size(); i++) {
			if (Database.USERS_DB.get(i).getId().equals(id)) {
				return i;
			}
		}

		return 0;
	}

	public boolean login(String id, String password, int failedCount) {
		

		for (int i = 0; i < Database.USERS_DB.size(); i++) {
			if (Database.USERS_DB.get(i).getId().equals(id)
					&& !Database.USERS_DB.get(i).getPassword().equals(password)) {
				Database.USERS_DB.get(i).setFailedCount(failedCount);
				break;
			}
			if (Database.USERS_DB.get(i).getId().equals(id)
					&& Database.USERS_DB.get(i).getPassword().equals(password)) {

				return true;	
			}
		}
		return false;

	}

	public void showRegisterCoursesByUser(User user) {
		
		System.out.println("**YOUR COURSES: ");
		System.out.println("course size: " + user.getRegisteredCourses().size());
		if (user.getRegisteredCourses().size() == 0) {
			System.out.println(" Please register a new course");
		}
		if ((user.getRegisteredCourses() != null)) {
			for (Course course : user.getRegisteredCourses()) {
				System.out.println("Course name:" + course.getName());
			}
		}
	}

	public void registerNewCourse(Course course, User user) {
		
		for ( int i = 0; i < user.getRegisteredCourses().size(); i++) {
			if (course.getId() == user.getRegisteredCourses().get(i).getId()) {
				System.out.println("You already registered this course");
				System.out.println("Please register a different course");
				return;
			}
		}
		user.setRegisteredCourses(course);
		
		System.out.println("**You registered this course successfully");
		System.out.println("- Course name:" + course.getName());
		for (Mentor mentor : course.getTeachingmentors()) {
			System.out.println("- Mentor names:" + mentor.getName());
		}
		System.out.println("- Star date: " + course.getBegin());
		System.out.println("- End date: " + course.getEnd());
		System.out.println("- Course fee: " + course.getFee());
		
		System.out.println("****registeredCourses size: " + user.getRegisteredCourses().size());
		System.out.println("************************");
	}

}
