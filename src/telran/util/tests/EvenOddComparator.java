package telran.util.tests;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {

	@Override
	public int compare(Integer o1, Integer o2) {
		int res = 1;
		if (o1 % 2 == 0 && o2 % 2 != 0) {
			res = -1;
		} else if(o1 % 2 != 0 && o2 % 2 != 0) {
			res = o2 - o1;
		} else if(o1 % 2 == 0 && o2 % 2 == 0) {
			res = o1 - o2;
		}
		return res;
	}

}
