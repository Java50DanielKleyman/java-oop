package telran.people;

import java.util.function.Predicate;

public class BirthYearPredicate implements Predicate<Employee> {

int yearFrom;
int yearTo;
public BirthYearPredicate(int yearFrom, int yearTo) {
	super();
	this.yearFrom = yearFrom;
	this.yearTo = yearTo;
}
	@Override
	public boolean test(Employee empl) {
		int year = empl.getBirthYear();
		return year >= yearFrom && year <= yearTo;
	}

}
