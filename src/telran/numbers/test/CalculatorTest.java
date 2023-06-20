package telran.numbers.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BinaryOperator;
import org.junit.jupiter.api.Test;

import telran.numbers.CalcData;
import telran.numbers.Calculator;

class CalculatorTest {
	@Test
	void calculateTest() {
		assertEquals(20, Calculator.calculate(new CalcData(40, 20, '-')));
		assertEquals(30, Calculator.calculate(new CalcData(10, 20, '+')));
		assertEquals(300, Calculator.calculate(new CalcData(10, 30, '*')));
		assertEquals(11, Calculator.calculate(new CalcData(22, 2, '/')));
		assertTrue(Calculator.setOperations('%'));
		assertFalse(Calculator.setOperations('+'));
//		assertEquals(1, Calculator.calculate(new CalcData(3,2, '%')));
	}

	
	
	
	
	@Test
	void test() {
		BinaryOperator<Double> bo = (a, b) -> a + b;
		assertEquals(30, bo.apply(10.0, 20.0));
		DoubleBinaryOperator[] operators = {
				(a, b) -> a + b,
				(a, b) -> a - b,
				(a, b) -> a * b,
				(a, b) -> a / b
		};
	double[] results = {30, 10, 200, 2};
	double op1 = 20;
	double op2 = 10;
	for(int i = 0; i < operators.length; i++) {
		assertEquals(results[i], operators[i].apply(op1, op2));
	}
//		BinaryOperator<Double>[] operators = new BinaryOperator[4];
//		operators[0] = (a, b) -> a + b;
//		operators[1] = (a, b) -> a - b;
//		operators[2] = (a, b) -> a * b;
//		operators[3] = (a, b) -> a / b;

	}
	

}
interface DoubleBinaryOperator extends BinaryOperator<Double>{
	
}