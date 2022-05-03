package sample;

import java.util.Arrays;
import java.util.Comparator;

public class Group {

	private String groupName; // field groupName
	private Student[] students = new Student[10];// create new Student array, 10 persons

	public Group(String groupName, Student[] students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}

	public Group() {
		super();
	}

	public Student[] getStudent() {
		return students;
	}

	public void setStudent(Student[] students) {
		this.students = students;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void addStuded(Student student) throws GroupOverflowException {
		if (student != null && groupName != null) {
			for (int i = 0; i < students.length; i++) {
				if (students[i] == null) {
					student.setGroupName(groupName);// if student have another groupName this void could rename it
					students[i] = student;
					System.out.println("You added " + student.getName() + " " + student.getLastName() + " to "
							+ student.getGroupName());
					return; // we finish the method if we add student into group
				}
			}
			throw new GroupOverflowException("This group is full, try another group");
		} else {
			System.out.println("Set student or groupName");
		}
	}

	public Student findStudentByLastName(String lastName) throws StudentNotFoundException {
		if (lastName != null && groupName != null) {
			for (int i = 0; i < students.length; i++) {
				if (students[i] != null && students[i].getLastName().equalsIgnoreCase(lastName)) {
					System.out.println("You found student you need in group " + groupName);
					return students[i];
				}
			}
			throw new StudentNotFoundException("Group doesn't contains student with lastName " + lastName);
		}
		return null;
	}

	public boolean removeStudentById(int id) {
		for (int k = 0; k < students.length; k++) {
			if (students[k] != null && students[k].getId() == id) {
				students[k] = null;
				System.out.println("You removed student with Id " + id);
				return true;
			}
		}
		System.out.println("You didn't removed student with id " + id);
		return false;
	}

	public Student[] sortStudentsNullLast() {
		Arrays.sort(students, Comparator.nullsLast(new SortStudentsByLastName()));
		return students;
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", students=" + Arrays.toString(Group.this.sortStudentsNullLast())
				+ "]";
	}

}
