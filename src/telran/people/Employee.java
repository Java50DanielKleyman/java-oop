package telran.people;

public class Employee implements Comparable<Employee>{
 
private int id;
 private String name;
 private int birthYear;
 private String department;
 private int salary;
 public Employee(int id, String name, int birthYear, String department, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.birthYear = birthYear;
		this.department = department;
		this.salary = salary;
	}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public int getBirthYear() {
	return birthYear;
}
public String getDepartment() {
	return department;
}
public int getSalary() {
	return salary;
}
@Override
public boolean equals(Object emplObj) {
	return ((Employee)emplObj).id == id;
}
@Override
public int compareTo(Employee o) {
	
	return id - o.id;
}

}
