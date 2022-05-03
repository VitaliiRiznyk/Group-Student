package sample;

import java.util.Scanner;

public class CreateNewStudent {

	public Student createNew() {
		try (Scanner sc = new Scanner(System.in)) {
			String name;
			String lastName;
			String gender = null;
			Integer id = null;
			String groupName;

			for (;;) {
				System.out.println("Enter students name");
				name = sc.nextLine();
				if (name.length() > 0) {
					break;
				}
			}

			for (;;) {
				System.out.println("Enter students lastName");
				lastName = sc.nextLine();
				if (lastName.length() > 0) {
					break;
				}
			}

			for (;;) {
				System.out.println("Enter Gender for student:1 - Male, 2 - Female");
				String gender1 = sc.nextLine();
				switch (gender1) {
				case "1":
					gender = Gender.Male.toString();
					break;
				case "2":
					gender = Gender.Female.toString();
					break;
				}
				if (gender != null) {
					break;
				}
			}

			for (;;) {
				System.out.println("Enter groupName");
				groupName = sc.nextLine();
				if (groupName.length() != 0) {
					break;
				}
			}

			while (id == null) {
				System.out.println("Enter students id");
				id = sc.nextInt();
			}
			Student student = new Student(name, lastName, Gender.valueOf(gender), id, groupName);
			return student;
		}

	}
}
