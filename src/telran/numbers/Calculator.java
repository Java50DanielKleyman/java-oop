package telran.numbers;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class Calculator {
	static char[] operations = { '+', '-', '*', '/' };
	static DoubleBinaryOperator[] operators = { 
			(a, b) -> a + b, 
			(a, b) -> a - b, 
			(a, b) -> a * b, 
			(a, b) -> {
				if(b == 0) {
					throw new ArithmeticException("devision on 0"); };
					return a / b;
				}
			};

	public static double calculate(CalcData cd) {
		int index = findIndex(cd.getOperation());
		if(index < 0) {
			throw new UnsupportedOperationException("unsupported operation" + cd.getOperation());
		}
		return operators[index].apply(cd.getOp1(), cd.getOp2());
	}

	private static int findIndex(char operation) {
		int index = new String(operations).indexOf(operation);		
		return index;
	}

	
}

interface DoubleBinaryOperator extends BinaryOperator<Double> {

}