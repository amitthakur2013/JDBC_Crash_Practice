import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Student Management App");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			System.out.println("Press 1 to add Student");
			System.out.println("Press 2 to delete Student");
			System.out.println("Press 3 to display Student");
			System.out.println("Press 4 exit app");
			int c = Integer.parseInt(br.readLine());
			
			if(c==1) {
				//add student
				System.out.println("Enter name : ");
				String name=br.readLine();
				
				System.out.println("Enter phone : ");
				String phone=br.readLine();
				
				System.out.println("Enter city : ");
				String city=br.readLine();
				
				Student st=new Student(name, phone, city);
			
				boolean ans=StudentDao.insertStudent(st);
				if(ans) {
					System.out.println("Student Added Successfully!");
				} else {
					System.out.println("Something went wrong!!");
				}
				
				System.out.println(st);
				
			} else if(c==2) {
				
				//delete student
				System.out.println("Enter the id of student to be deleted!");
				int sid=Integer.parseInt(br.readLine());
				boolean ans=StudentDao.deleteStudent(sid);
				if(ans) {
					System.out.println("Student Deleted Successfully!");
				} else {
					System.out.println("Something went wrong!!");
				}
				
			} else if(c == 3) {
				// display students
				StudentDao.showAll();
			} else if(c == 4) {
				//exit
				break;
			} else {
				System.out.println("Please enter valid option!");
			}
		}
		System.out.println("Thanks for using our app!!");
	}


}
