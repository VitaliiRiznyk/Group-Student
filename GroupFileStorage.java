package sample;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.io.BufferedReader;
import java.util.List;

public class GroupFileStorage {

	public static void saveGroupToCSV(Group gr) throws IOException {
		String groupName = gr.getGroupName();
		File file = new File(groupName + ".csv");
		List<Student> students = gr.getStudent();

		try (Writer writer = new PrintWriter(file)) {
			for (int i = 0; i < students.size(); i++) {
				String studStatus = students.get(i).getName() + ";" + students.get(i).getLastName() + ";" + students.get(i).getGender() + ";"
						+ students.get(i).getId() + System.lineSeparator();
				writer.write(studStatus);
			}
			System.out.println("You save group");
		}
	}

	public Group loadGroupFromCSV(File file) throws IOException, GroupOverflowException {
		Group group = new Group();
		group.setGroupName(file.getName().substring(0, file.getName().lastIndexOf(".")));
		StringBuilder sb = new StringBuilder();
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String str = "";
			for (;;) {
				str = br.readLine();
				if (str == null) {
					break;
				}
				sb.append(str + System.lineSeparator());
			}
		}
		String[] groupMass = String.valueOf(sb).split(System.lineSeparator());
		for (int k = 0; k < groupMass.length; k++) {
			String[] stud = groupMass[k].split(";");
			Student student = new Student(stud[0], stud[1], Gender.valueOf(stud[2]), Integer.parseInt(stud[3]),
					group.getGroupName());
			group.addStuded(student);
		}
		return group;
	}

	public File findFileByGroupName(String groupName, File workFolder) {
		File[] file = workFolder.listFiles();
		File current=null;
		for (int i = 0; i < file.length; i++) {
			if (file[i].getName().contains(groupName)) {
				current = file[i];
				System.out.println("You have found file in the directory");
				break;
			}
		}
		if(current == null) {
			System.out.println("There wasn't file in the directory");
		}
		return current;
	}
}