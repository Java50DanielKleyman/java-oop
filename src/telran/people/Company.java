package telran.people;

import java.util.Arrays;
import java.util.function.Predicate;

public class Company {
	private Employee[] employees;
	public Company(Employee[] employees) {
		this.employees = Arrays.copyOf(employees, employees.length);
	}
	public Employee[] getAllEmployees() {
		Employee[] res = Arrays.copyOf(employees, employees.length);
		Arrays.sort(res);
		return res;
	}
	public Employee[] getEmployeesByAge(int yearFrom, int yearTo) {
		Employee[] res = getEmployeesByPredicate(new BirthYearPredicate(yearFrom, yearTo));
		Arrays.sort(res, new BirthYearsComparator());
		return res;
	}
	public Employee[] getEmployeesBySalary(int salaryFrom, final int salaryTo) {
		Employee[] res = getEmployeesByPredicate(e -> {
			int salary = e.getSalary();
			return salary >= salaryFrom && salary <= salaryTo;
		});
		Arrays.sort(res, new SalaryComparator());
		return res;
	}
	private Employee[] getEmployeesByPredicate(Predicate<Employee> predicate) {
		Employee res[] = new Employee[employees.length];
		int index = 0;
		for(int i = 0; i < employees.length; i++) {
			if(predicate.test(employees[i])) {
				res[index++] = employees[i];
			}
		}
		
		return Arrays.copyOf(res, index);
	}
	public Employee[] getEmployeesByDepartment(String department) {
		Employee[] res = getEmployeesByPredicate(new DepartmentPredicate(department));
		Arrays.sort(res);
		return res;
	}
	public boolean addEmployee(Employee empl) {
		Employee employee = getEmployee(empl.getId());
		boolean res = false;
		if(employee == null) {
			res = true;
			employees = Arrays.copyOf(employees, employees.length + 1);
			employees[employees.length - 1] = empl;
		}
		return res;
	}
	public Employee getEmployee(int id) {
		Employee res = null;
		int index = 0;
		while(index < employees.length && res == null) {
			if(employees[index].getId() == id) {
				res = employees[index];
			}
			index++;
		}
		return res;
	}
	public boolean removeEmployeesIf(Predicate<Employee> predicate) {
		Employee[] tmp = new Employee[employees.length];
		int oldSize = employees.length;
		int index = 0;
		for(int i = 0; i < oldSize; i++) {
			if(!predicate.test(employees[i])) {
				tmp[index++] = employees[i];
			}
		}
		employees = Arrays.copyOf(tmp, index);
		return oldSize > employees.length;
	}
	public Employee[] removeEmployeesByID(Employee [] employees, Employee empl) {
		Employee [] res = new Employee[employees.length - 1];
		int index = Arrays.binarySearch(employees, empl);
		System.arraycopy(employees, 0, res, 0, index);
		System.arraycopy(employees, index + 1, res, index, res.length - index);
		return res;		
	}

}
