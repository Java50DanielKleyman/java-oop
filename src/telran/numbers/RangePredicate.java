package telran.numbers;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Predicate;

public class RangePredicate implements Iterable<Integer> {
	int minInclusive;
	int maxExclusive;
	Predicate<Integer> predicate;

	public RangePredicate(int minInclusive, int maxExclusive) {

		this.minInclusive = minInclusive;
		this.maxExclusive = maxExclusive;
		if (minInclusive >= maxExclusive) {
			throw new IllegalArgumentException("min must be less than max");
		}
	}

	public Predicate<Integer> getPredicate() {
		return predicate;
	}

	public void setPredicate(Predicate<Integer> predicate) {
		this.predicate = predicate;
	}

	public int[] toArray() {
		int[] res = new int[length()];
		int index = 0;
		for (int num = minInclusive; num < maxExclusive; num++) {
			if (predicate == null || predicate.test(num)) {
				res[index++] = num;
			}
		}
		return Arrays.copyOf(res, index);
	}

	public int length() {
		return maxExclusive - minInclusive;
	}

	private class RangePredicateIterator implements Iterator<Integer> {
		int current;
		Predicate<Integer> innerPredicate;

		RangePredicateIterator(Predicate<Integer> predicate) {
			innerPredicate = predicate;
			current = getCurrent();
		}

		int getCurrent() {
			int num = minInclusive;
			while (!innerPredicate.test(num)) {
				num++;
				if (num >= maxExclusive) {
					return maxExclusive;
				}
			}
			return num;
		}

		@Override
		public boolean hasNext() {
			return innerPredicate.test(current) && current < maxExclusive;
		}

		@Override
		public Integer next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			int res = current++;
			return res;
		}

	}

	@Override
	public Iterator<Integer> iterator() {

		return new RangePredicateIterator(predicate);
	}

}