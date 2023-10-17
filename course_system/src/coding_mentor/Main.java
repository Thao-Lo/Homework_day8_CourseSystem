package coding_mentor;

import java.util.Scanner;

import coding.mentor.data.Course;
import coding.mentor.data.User;
import coding.mentor.db.Database;
import coding.mentor.service.CourseService;
import coding.mentor.service.UserService;

public class Main {
	final static int LOGIN = 1;
	final static int REGISTER = 2;
	final static int COURSE_REGISTER = 1;
	final static int VIEW_MENTOR_DETAIL = 2;
	final static int BACK_TO_COURSE_LIST = 3;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);

		CourseService courseService = new CourseService();
		UserService userService = new UserService();
		User user = new User();

		Database.initDB();

		int selectLoginorRegister = 0;
		String id = null;
		boolean loginResult = false; // đổi tên
		int selectedCourseOption = 0;

		//LOGIN + REGISTER
		do {
			showHomePage();
			selectLoginorRegister = Integer.parseInt(keyboard.nextLine());
			System.out.println("-----------------------");
			loginResult = showLoginOrRegister(selectLoginorRegister, userService, id);
			user = Database.USERS_DB.get(userService.findUser(id));

		} while (loginResult == false);
		
		do {

			selectedCourseOption = showCourseListSelection(courseService, userService, user);

		} while (selectedCourseOption != VIEW_MENTOR_DETAIL);

	}

	public static int showCourseListSelection(CourseService courseService, UserService userService, User user) {
		Scanner keyboard = new Scanner(System.in);
		int courseId = 0;
		int selectedCourseOption = 0;
		do {
			System.out.println("***COURSE LIST");
			System.out.println("0 - Your course");
			courseService.showAllCourses();
			System.out.print("Enter your course id: ");
			courseId = keyboard.nextInt();

			if (courseId == 0) {
				userService.showRegisterCoursesByUser(user);
				break;
			}
		} while (courseId == 0);

		if (courseId > 0 && courseId < 5) {
			courseService.showCourseDetails(courseId);
			System.out.println("-------------------");

			showCourseOption();
			selectedCourseOption = keyboard.nextInt();
			switch (selectedCourseOption) {
			case COURSE_REGISTER:
				Database.COURSES_DB.get(courseId - 1); // current course
				// show current registered course of this user
				
				userService.registerNewCourse(Database.COURSES_DB.get(courseId - 1), user);

				break;
			case VIEW_MENTOR_DETAIL:
				courseService.showMentorByCourse(courseId);
				break;
			case BACK_TO_COURSE_LIST:
				break;
			}
		}
		return selectedCourseOption;

	}

	public static boolean showLoginOrRegister(int selectLoginorRegister, UserService userService, String id) {
		Scanner keyboard = new Scanner(System.in);
		
		
		boolean loginResult = false;
		switch (selectLoginorRegister) {
		case REGISTER:
			System.out.println("***REGISTER");
			System.out.print("- Enter your Name: ");
			String name = keyboard.nextLine();
			System.out.print("- Enter your ID: ");
			id = keyboard.nextLine();
			System.out.print("- Enter your Password: ");
			String password = keyboard.nextLine();
			userService.registerNewUser(name, id, password);

			break;

		case LOGIN:
			System.out.println("***LOGIN");
			for (int failedCount = 1; failedCount < 5; failedCount++) {
				System.out.print("-- ID: ");
				id = keyboard.nextLine();
				System.out.print("-- Password: ");
				password = keyboard.nextLine();

				loginResult = userService.login(id, password, failedCount);

				if (loginResult == true) {

					break;
				}
				if (failedCount <= 3 && loginResult == false) {
					System.out.println("Wrong Id or Password, try again");
				}
				if (failedCount > 3) {
					System.out.println("Wrong Id or Password.");
					System.out.println("Your account is block");
					System.out.println(Database.USERS_DB.get(0).getFailedCount());
					return false;
				}
			}
			break;
		}
		return loginResult;

	}

	public static void showHomePage() {

		System.out.println("1. Login");
		System.out.println("2. Register");
		System.out.print("Please choose Login or Register: ");
	}

	public static void showCourseOption() {
		System.out.println("1. Register");
		System.out.println("2. View mentor details");
		System.out.println("3. Back to course list");
	}
}
