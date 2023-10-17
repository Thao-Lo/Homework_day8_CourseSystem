package coding.mentor.db;

import java.util.ArrayList;
import java.util.Date;

import coding.mentor.data.Course;
import coding.mentor.data.Mentor;
import coding.mentor.data.User;

public class Database {
	// create constant that can access everywhere without creating a new object in that class
	public static ArrayList<Mentor> MENTORS_DB = new ArrayList<Mentor>();
	public static ArrayList<Course> COURSES_DB = new ArrayList<Course>();
	public static ArrayList<User> USERS_DB = new ArrayList<User>();
	
	public Database() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static void initDB() {
		//initialize Mentor DB
		MENTORS_DB.add(new Mentor(1, "Dung", "dung@gmail.com", "0909"));
		MENTORS_DB.add(new Mentor(2, "Hai", "hai@gmail.com", "0808"));
		MENTORS_DB.add(new Mentor(3, "Jayden", "jayden@gmail.com", "0707"));
		MENTORS_DB.add(new Mentor(4, "Tony", "tony@gmail.com", "0606"));
			
		//initialize Course DB
		ArrayList<Mentor> teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(0));
		COURSES_DB.add(new Course( 1, "BE 1", teachingMentors, new Date(), new Date(), 3000));
		
		teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(0));
		teachingMentors.add(MENTORS_DB.get(1));
		COURSES_DB.add(new Course(2, "BE 2", teachingMentors, new Date(), new Date(), 3100));
		
		teachingMentors = new ArrayList<Mentor>();
		teachingMentors.add(MENTORS_DB.get(2));
		COURSES_DB.add(new Course(3, "DATA 1", teachingMentors, new Date(), new Date(), 2500));
		
		teachingMentors = new ArrayList<Mentor>(); // reinitialize a new ArrayList =>empty noew
		teachingMentors.add(MENTORS_DB.get(2)); // add 1st value into ArrayList
		teachingMentors.add(MENTORS_DB.get(3)); //add 2nd value into ArrayList
		COURSES_DB.add(new Course(4, "FE 1", teachingMentors, new Date(), new Date(), 2500));
		
		
		// instead of Course course = new Course(parameters); 
		// COURSES_DB.add(course) 
		//==> combine ArrayList COURSES_DB.add(new object & its parameters) 
		//COURSE_DB = {course (0), course(1), course(2), course(3)}
		// course(0)={ 1, "BE 1", teachingMentors, new Date(), new Date(), 3000}
		//teachingMentors (0) = {1, "Dung", "dung@gmail.com", "0909"}
	}
	




	
	
}
