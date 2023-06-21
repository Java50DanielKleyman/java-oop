package telran.exceptions.tests;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.exceptions.BallBrokenFloor;

class ExceptionTest {
	@Test
	void ballBrokenTest() {
		BallBrokenFloor bbf = new BallBrokenFloor(200);
		assertEquals(bbf.getfloor(), getMiniFloor(bbf));

	}

	private int getMiniFloor(BallBrokenFloor bbf) {
		int[] ArrayFloors = getArray(200);
		int left = 0;
		int right = ArrayFloors.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (ArrayFloors[mid] == bbf.getfloor()) {
				return ArrayFloors[mid];
			}
			try {
				bbf.broken(ArrayFloors[mid]);
				left = mid + 1;

			} catch (Exception e) {
				right = mid - 1;
			}
		}
		return -1;
	}

	private int[] getArray(int nFloors) {
		int[] ArrayFloors = new int[nFloors];
		for (int i = 0; i < ArrayFloors.length; i++) {
			ArrayFloors[i] = i + 1;
		}
		;
		return ArrayFloors;
	}

//	@Test
//	void testException() {
//		int result = 0;
//		try {
//			result = itThrowsCheckedException(2000);
//
//			System.out.println("everything ok");
//		} catch (RuntimeException e) {
//
//			System.out.println(e.getMessage());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		} //
//		assertEquals(4000, result);
//	}
//
//	private int itThrowsCheckedException(int number) throws Exception {
//		if (number < 0) {
//			throw new Exception("just test checked exception");
//		}
//		if (number > 1000) {
//			throw new RuntimeException("number cannot be greater than 1000");
//		}
//		return number * 2;
//	}

}