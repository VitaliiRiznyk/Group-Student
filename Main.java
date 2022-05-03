package sample;

import java.io.IOException;
import java.util.Arrays;
import java.io.File;

public class Main {

	public static void main(String[] args) {
		Group group2 = new Group();
		group2.setGroupName("Group 2");

		Student student1 = new Student("Vitalii", "Riznyk", Gender.Male, 1, group2.getGroupName());
		Student student2 = new Student("Oleg", "Hahun", Gender.Male, 2, group2.getGroupName());
		Student student3 = new Student("Mukola", "Zdibai", Gender.Male, 3, group2.getGroupName());
		Student student4 = new Student("Viktoria", "Horunsha", Gender.Female, 4, group2.getGroupName());
		Student student5 = new Student("Veronica", "Subirova", Gender.Female, 5, group2.getGroupName());
		Student student6 = new Student("Vlad", "Deunhc", Gender.Male, 6, group2.getGroupName());
		Student student7 = new Student("Oleg", "Kriliuk", Gender.Male, 7, group2.getGroupName());
		Student student8 = new Student("Michail", "Polischuk", Gender.Male, 8, group2.getGroupName());
		Student student9 = new Student("Vadim", "Moisei", Gender.Male, 9, group2.getGroupName());
		Student student10 = new Student("Oleksandr", "Popur", Gender.Male, 10, group2.getGroupName());
		Student student11 = new Student("Oleg", "Tsaplin", Gender.Male, 11, group2.getGroupName());

		System.out.println();

		try {
			group2.addStuded(student1);
			group2.addStuded(student2);
			group2.addStuded(student3);
			group2.addStuded(student4);
			group2.addStuded(student5);
			group2.addStuded(student6);
			group2.addStuded(student7);
			group2.addStuded(student8);
			group2.addStuded(student9);
			group2.addStuded(student10);
			group2.addStuded(student11);
		} catch (GroupOverflowException e) {
			System.out.println(e.getMessage());
		}

		System.out.println();

		GroupFileStorage gfs = new GroupFileStorage();

		try {
			GroupFileStorage.saveGroupToCSV(group2);
		} catch (IOException e) {
			e.printStackTrace();
		}

		File fileFrom = new File("E:\\Java OOP actual\\Lesson 3 a\\Group 2.csv");// current file
		Group group3 = new Group();
		try {
			group3 = gfs.loadGroupFromCSV(fileFrom);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (GroupOverflowException e) {
			e.printStackTrace();
		}

		File folderFrom = new File("E:\\Java OOP actual\\Lesson 3 a");

		File file = gfs.findFileByGroupName("Group 2", folderFrom);

		System.out.println(file.getAbsolutePath());

	}
}
