package evaluator;

import java.util.Stack;

public class InfixEvaluator extends Evaluator {

	@Override
	public int evaluate(String expression) throws ArithmeticException {
		// TODO Auto-generated method stub.
		String str = (String) convertToPostfix(expression);
		PostfixEvaluator evalf = new PostfixEvaluator();
		return evalf.evaluate(str);
	}

	public Object convertToPostfix(String expression) {
		String[] str = expression.split(" ");
		StringBuilder sb = new StringBuilder();
		boolean inPara = false;
		int leftP = 0;
		int rightP = 0;
		int numOperands = 0;
		int numOperators = 0;
		Stack<String> operators = new Stack<>();
		for (int i = 0; i < str.length; i++) {
			if (isOperator(str[i])) {
				// System.out.println(str[i]);
				if (pemdas(str[i]) == 4) {
					operators.push(str[i]);
					inPara = true;
					leftP++;
					numOperators++;
					// System.out.println(operators.toString());
					continue;
				}
				if (pemdas(str[i]) == 5) {
					inPara = false;
					rightP++;
					while (pemdas(operators.peek()) != 4) {
						// System.out.println(operators.toString());
						sb.append(operators.pop());
						sb.append(" ");
						if (operators.isEmpty()) {
							throw new ArithmeticException();
						}
					}
					operators.pop();
				} else if (!operators.isEmpty() && operators.peek().equals("(")) {
					operators.push(str[i]);
					numOperators++;
				} else {
					if (!operators.isEmpty() && (pemdas(operators.peek()) >= pemdas(str[i]))) {
						while (pemdas(operators.peek()) >= pemdas(str[i]) && pemdas(operators.peek()) != 4) {
							sb.append(operators.pop());
							sb.append(" ");
							if (!str[i].equals("(") && !str[i].equals(")")) {
								numOperators++;
							}
							if (operators.isEmpty()) {
								break;
							}
						}
						operators.push(str[i]);
						// System.out.println(operators.toString());
						// sb.append(operators.pop());
						// sb.append(" ");
						// operators.push(str[i]);
						// if(!str[i].equals("(") && !str[i].equals(")")){
						// numOperators++;
						// }
					} else {
						if (!str[i].equals("(") && !str[i].equals(")")) {
							operators.push(str[i]);
							numOperators++;
						}
					}
				}
			}
			if (!isNumber(str[i]) && !isOperator(str[i])) {
				throw new ArithmeticException();
			}
			if (isNumber(str[i])) {
				sb.append(str[i]);
				numOperands++;
				sb.append(" ");
			}
		}
		if (inPara) {
			throw new ArithmeticException();
		}
		if (rightP != leftP) {
			throw new ArithmeticException();
		}

		while (!operators.isEmpty()) {
			sb.append(operators.pop());
			if (operators.size() >= 1) {
				sb.append(" ");
			}
		}
		if (Math.abs(numOperands - str.length) < numOperands - 1) {
			throw new ArithmeticException();
		}

		return sb.toString();
	}

	public int pemdas(String input) {
		if (input.equals("+") || input.equals("-")) {
			return 1;
		} else if (input.equals("*") || input.equals("/")) {
			return 2;
		} else if (input.equals("^")) {
			return 3;
		} else if (input.equals("(")) {
			return 4;
		} else if (input.equals(")")) {
			return 5;
		}
		return 0;
	}

}
