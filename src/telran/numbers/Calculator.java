package telran.numbers;

import java.util.Arrays;
import java.util.function.BinaryOperator;

public class Calculator {
	static char[] operations = { '+', '-', '*', '/' };
	static DoubleBinaryOperator[] operators = { (a, b) -> a + b, (a, b) -> a - b, (a, b) -> a * b, (a, b) -> a / b };

	public static double calculate(CalcData cd) {
		int index = findIndex(cd.getOperation());
		return operators[index].apply(cd.getOp1(), cd.getOp2());
	}

	private static int findIndex(char operation) {
		int index = new String(operations).indexOf(operation);
		return index;
	}

	public static boolean setOperations(char newOperation) {
		int oldSizeOperations = operations.length;
		int oldSizeOperators = operators.length;
		if (new String(operations).indexOf(newOperation) == -1) {
			operations = Arrays.copyOf(operations, operations.length + 1);
			operations[operations.length - 1] = newOperation;
			operators = Arrays.copyOf(operators, operators.length + 1);
			operators[operators.length - 1] = (a, b) -> {
				String result = Double.toString(a) + " " + newOperation + " " + Double.toString(b);
				return Double.parseDouble(result);
			};
		}
		return (oldSizeOperations < operations.length && oldSizeOperators < operators.length);
	}
}

interface DoubleBinaryOperator extends BinaryOperator<Double> {

}