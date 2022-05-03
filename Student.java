package sample;

public class Student extends Human implements CSVConverter {

	private int id; // create stud id
	private String groupName;// create groupName for every student

	public Student(String name, String lastName, Gender gender, int id, String groupName) {
		super(name, lastName, gender);
		this.id = id;
		this.groupName = groupName;
	}

	public Student() {
		super();
	}

	@Override
	public String toCSVString() {
		String toCSV = Student.this.getName() + ";" + Student.this.getLastName() + ";" + Student.this.getGender() + ";" + Student.this.getId()+ ";" + Student.this.getGroupName();
		return toCSV;
	}

	@Override
	public Student fromCSVString(String str) {
		
		String [] strMass = str.split(";"); // creates a massive from string
				
		return new Student(strMass[0],strMass[1],Gender.valueOf(strMass[2]),Integer.valueOf(strMass[3]),strMass[4]);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", groupName=" + groupName + ", " + super.toString() + "]";
	}

}
