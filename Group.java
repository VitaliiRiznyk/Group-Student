package sample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class Group {

	private String groupName; // field groupName
	private List<Student> students = new ArrayList<>();// create new Student array

	public Group(String groupName, List<Student> students) {
		super();
		this.groupName = groupName;
		this.students = students;
	}

	public Group() {
		super();
	}

	public List<Student> getStudent() {
		return students;
	}

	public void setStudent(List<Student> students) {
		this.students = students;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public void addStuded(Student student) throws GroupOverflowException {
		if (student != null && groupName != null && isContains(student) != true) {
			for (int i = 0; i < 10; i++) {
				if (students.size() != 10) {
					student.setGroupName(groupName);// if student have another groupName this void could rename it
					students.add(i, student);
					System.out.println("You added " + student.getName() + " " + student.getLastName() + " to "
							+ student.getGroupName());
					return; // we finish the method if we add student into group
				}
			}
			throw new GroupOverflowException("This group is full, try another group");
		} else if (isContains(student) == true) {
			System.out.println(
					student.getName() + " " + student.getLastName() + " is already added to group " + groupName);
		} else {
			System.out.println("Set studetn or group");
		}
	}

	private boolean isContains(Student student) {
		for (int i = 0; i < students.size(); i++) {
			if (student.equals(students.get(i))) {
				return true;
			}
		}
		return false;
	}

	public Student findStudentByLastName(String lastName) throws StudentNotFoundException {
		if (students.size() != 0 && lastName != null && groupName != null) {
			for (int i = 0; i < students.size(); i++) {
				if (students.get(i).getLastName().equalsIgnoreCase(lastName)) {
					System.out.println("You found student you need in group " + groupName);
					return students.get(i);
				}
			}
			throw new StudentNotFoundException("Group doesn't contains student with lastName " + lastName);
		}
		return null;
	}

	public boolean removeStudentById(int id) {
		for (int k = 0; k < students.size(); k++) {
			if (students.get(k).getId() == id) {
				students.remove(k);
				System.out.println("You removed student with Id " + id);
				return true;
			}
		}
		System.out.println("You didn't removed student with id " + id);
		return false;
	}

	public List<Student> sortStudentsNullLast() {
		students.sort(Comparator.nullsLast(new SortStudentsByLastName()));
		// Arrays.sort(students, Comparator.nullsLast(new SortStudentsByLastName()));
		return students;
	}

	@Override
	public int hashCode() {
		return Objects.hash(groupName, students);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(groupName, other.groupName) && Objects.equals(students, other.students);
	}

	@Override
	public String toString() {
		return "Group [groupName=" + groupName + ", students=" + Group.this.sortStudentsNullLast() + "]";
	}

}
