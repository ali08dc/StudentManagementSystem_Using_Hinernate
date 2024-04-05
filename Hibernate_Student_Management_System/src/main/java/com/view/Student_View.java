package com.view;

import java.util.List;
import java.util.Scanner;
import com.controller.Student_Controller;
import com.model.Student_Entity;

public class Student_View {

	private static Scanner sc = new Scanner(System.in);

	public static Student_Entity getStudentObject() {

		Student_Entity s = new Student_Entity();

		System.out.println("Enter the Id: ");
		int id = sc.nextInt();

		System.out.println("Enter the name: ");
		sc.nextLine();
		String name = sc.nextLine();

		System.out.println("Enter the mobile number: ");
		long mob = sc.nextLong();

		System.out.println("Enter Gender: ");
		sc.nextLine();
		String gender = sc.nextLine();

		System.out.println("Enter Email: ");
		String email = sc.nextLine();

		System.out.println("Enter DOB: ");
		String dob = sc.nextLine();

		System.out.println("Enter password: ");
		String pswd = sc.nextLine();

		s.setId(id);
		s.setName(name);
		s.setMob(mob);
		s.setGender(gender);
		s.setEmail(email);
		s.setDob(dob);
		s.setPassword(pswd);

		return s;

	}

	public static void main(String[] args) {

		Student_Controller controller = new Student_Controller();

		System.out.println("...Welcome to Student Portal...");

		while (true) {

			System.out.println("\n---Choose What to Perform---\n");
			System.out.println("1. Save Student.");
			System.out.println("2. Find Student By Id.");
			System.out.println("3. Update Student By Id.");
			System.out.println("4. Delete Student By Id.");
			System.out.println("5. Find All.");
			System.out.println("6. Exit.");

			System.out.println("\n Enter Your choice... ");
			int choice = sc.nextInt();

			switch (choice) {

			case 1: {
				System.out.println("Enter the No. of Records to Enter: ");
				int no = sc.nextInt();

				int count = 1;
				while (count <= no) {
					System.out.println("Enter Data for student " + count);

					Student_Entity student = getStudentObject();

					boolean s = controller.saveStudent(student);

					if (s) {
						System.out.println("Data saved Successfully!\n");
					} else {
						System.out.println("Data not saved!...");
					}
					count++;
				}

				break;
			}

			case 2: {
				System.out.println("Enter Student Id: ");
				int id = sc.nextInt();
				Student_Entity s = controller.findStudentById(id);

				if (s != null) {
//					System.out.println(s);

					System.out.println(s.getId() + " | " + s.getName() + " | " + s.getEmail() + " | " + s.getPassword()
							+ " | " + s.getGender() + " | " + s.getDob() + " | " + s.getMob());

				} else {
					System.out.println("Record Not Found...");
				}
				break;

			}

			case 3: {
				System.out.println("Enter Student ID: ");
				int id2 = sc.nextInt();

				System.out.println("Enter new Email: ");
				sc.nextLine();
				String email = sc.nextLine();

				boolean n = controller.updateStudentByID(id2, email);

				if (n) {
					System.out.println("\nStudent details updated!");
				} else {
					System.out.println("Record not found...\n");
				}
				break;

			}

			case 4: {
				System.out.println("Enter Student ID");
				int id3 = sc.nextInt();

				boolean b = controller.deleteStudentByID(id3);
				if (b) {
					System.out.println("\nRecord deleted!..\n");
				} else {
					System.out.println("\nRecord not Found!..\n");
				}
				break;

			}

			case 5: {
				List<Student_Entity> list = controller.findAll();

				if (!list.isEmpty()) {

					for (Student_Entity std : list) {
						System.out.println(
								std.getId() + " | " + std.getName() + " | " + std.getEmail() + " | " + std.getPassword()
										+ " | " + std.getMob() + " | " + std.getGender() + " | " + std.getDob());
					}

				} else {
					System.out.println("Record Not Found");
				}

				break;

			}

			case 6: {
				System.out.println("Thank You!..");
				return;

			}
			default:
				System.out.println("Invalid choice..\n");
				break;
			}
		}

	}
}
