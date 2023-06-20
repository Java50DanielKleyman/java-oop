package telran.people;

import java.util.function.Predicate;

public class DepartmentPredicate implements Predicate<Employee> {


String department;

public DepartmentPredicate(String department) {
		super();
		this.department = department;
	}

	@Override
	public boolean test(Employee t) {
		
		return t.getDepartment().equals(department);
	}

}
