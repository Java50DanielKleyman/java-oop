package telran.people;

import java.util.function.Predicate;

public class SalaryPredicate implements Predicate<Employee> {
int salaryFrom;
int salaryTo;
	public SalaryPredicate(int salaryFrom, int salaryTo) {
	super();
	this.salaryFrom = salaryFrom;
	this.salaryTo = salaryTo;
}
	@Override
	public boolean test(Employee t) {
		int salary = t.getSalary();
		return salary >= salaryFrom && salary <= salaryTo;
	}

}
