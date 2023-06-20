package telran.exceptions.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ExceptionTest {

	@Test
	void testException() {
		int result = 0;
		try {
			 result = itThrowsCheckedException(2000);
			
			System.out.println("everything ok");
		} catch (RuntimeException e) {

			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			
		}
		assertEquals(4000, result);
	}

	private int itThrowsCheckedException(int number) throws Exception {
		if(number < 0) {
			throw new Exception("just test checked exception");
		}
		if(number > 1000) {
			throw new RuntimeException("number cannot be greater than 1000");
		}
		return number * 2;
	}
}