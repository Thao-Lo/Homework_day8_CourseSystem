package coding.mentor.service;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.db.Database;

public class CourseService {
	final static int BE1 = 1;
	final static int BE2 = 2;
	final static int DATA1 = 3;
	final static int FE1 = 4;

	public void showAllCourses() {
		// TODO
		for (int i = 0; i < Database.COURSES_DB.size(); i++) {

			System.out.print(i + 1 + " - " + Database.COURSES_DB.get(i).getName()); // getName() from course(i) in
																					// ArrayList COURSES_DB

			// object mentor in Mentor, run every index in ArrayList<Mentor> teachingMentors
			// in ArrayList<Course> COURSES_DB
			for (Mentor mentor : Database.COURSES_DB.get(i).getTeachingmentors()) {
				System.out.print(" -- Mentor Name: " + mentor.getName()); // object.getter -> getName() from class
																			// Mentor
			}
			System.out.println();
		}
	}

	public void showCourseDetails(int id) {
		// TODO
		System.out.println("***COURSE DETAIL");
		System.out.println("- Course name: " + Database.COURSES_DB.get(id - 1).getName());
		for (Mentor mentor : Database.COURSES_DB.get(id - 1).getTeachingmentors()) {
			System.out.println("- Mentor Name: " + mentor.getName());
		}
		System.out.println("- Course start date: " + Database.COURSES_DB.get(id - 1).getBegin());
		System.out.println("- Course end date: " + Database.COURSES_DB.get(id - 1).getEnd());
		System.out.println("- Course fee: " + Database.COURSES_DB.get(id - 1).getFee());
	}

	public void showMentorByCourse(int id) {
		System.out.println("***MENTOR DETAILS");
		for (Mentor mentor : Database.COURSES_DB.get(id - 1).getTeachingmentors()) {
			System.out.println("- Mentor name: " + mentor.getName());
			System.out.println("- Mentor phone number: " + mentor.getPhone());
			System.out.println(("- Mentor email: " + mentor.getEmail()));
			System.out.println();
		}
	}
}
