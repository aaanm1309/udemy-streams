package br.com.adrianomenezes.calculator;

import br.com.adrianomenezes.calculator.lambda.MathOperation;

import java.util.HashMap;
import java.util.Map;

public class Calculator {

	private static final Map<String, MathOperation> map = new HashMap<>();
	static {
		map.put("+",((i1, i2) -> i1 + i2));
		map.put("-",((i1, i2) -> i1 - i2));
		map.put("*",((i1, i2) -> i1 * i2));
		map.put("/",((i1, i2) -> i1 / i2));
	}

	public static void addOperation(String key, MathOperation mathOperation){
		map.put(key, mathOperation);
	}

	public static int calculate (String expression) {
		String[] splitExpression = expression.split(" ");
		int onScreenNumber = Integer.parseInt(splitExpression[0]);
		for( int i = 1; i < splitExpression.length;i++){
			MathOperation op = map.get(splitExpression[i]);
			int nextNumber = Integer.parseInt(splitExpression[i+1]);
			onScreenNumber = calculate(onScreenNumber,op,nextNumber);
			i++;
		}
		return onScreenNumber;

	}

	private  static int calculate(int OnScreenNUmber, MathOperation mop, int enteredNumber){
		return mop.operate(OnScreenNUmber,enteredNumber);
	}
}
