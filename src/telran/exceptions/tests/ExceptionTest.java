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
		int left = 1;
		int right = 200;
		while (left <= right) {
			int mid = (left + right) / 2;
			try {
				bbf.broken(mid);
				left = mid + 1;
			} catch (Exception e) {
				try {
					bbf.broken(mid-1);
					return mid;
				} catch (Exception d) {
					right = mid - 1;
				}
			}
		}
		return -1;
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