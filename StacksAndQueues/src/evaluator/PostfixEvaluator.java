package evaluator;

import java.util.Stack;

public class PostfixEvaluator extends Evaluator {

	@Override
	public int evaluate(String expression) throws ArithmeticException {
		// TODO Auto-generated method stub.
		Stack<String> operands = new Stack<>();
		String[] str = expression.split(" ");
		int sum = 0;
		int numOperands= 0;
		int numOperators = 0;
		if(str.length<=1){
			return Integer.parseInt(str[0]);
		}
		if(str.length>=1){
			operands.push(str[0]);
		}
		int i =0;
		while(!operands.isEmpty()){
			if(i<str.length-1){
				i++;
			}
			if(isNumber(str[i])){
				operands.push(str[i]);
				if(Math.abs(operands.size()-str.length)<operands.size()-1){
					throw new ArithmeticException();
				}
				if(operands.size()==str.length){
					throw new ArithmeticException();
				}
			}
			else if(isOperator(str[i])){
				int secondNum=0;
				if(operands.size()!=0){
					secondNum = Integer.parseInt(operands.pop());
					if(operands.size()==0){
						throw new ArithmeticException();
					}
				}
				if(str[i].equals("+") && operands.size() >0){
					sum = Integer.parseInt(operands.pop()) + secondNum;
					operands.push(Integer.toString(sum));
				}if(str[i].equals("-") && operands.size() >0){
					sum = Integer.parseInt(operands.pop()) - secondNum;
					operands.push(Integer.toString(sum));
				}if(str[i].equals("*") && operands.size() >0){
					sum = Integer.parseInt(operands.pop()) * secondNum;
					operands.push(Integer.toString(sum));
				}if(str[i].equals("/") && operands.size() > 0){
					sum = Integer.parseInt(operands.pop()) / secondNum;
					operands.push(Integer.toString(sum));
				}if(str[i].equals("^") && operands.size() > 0){
					sum = (int)Math.pow(Integer.parseInt(operands.pop()),secondNum);
					operands.push(Integer.toString(sum));
				}
				if(operands.size()==1 && i>=str.length-1){
					sum = Integer.parseInt(operands.pop());
					break;
				}
			}
			else{
				throw new ArithmeticException();
			}
		}
		return sum;
	}
}

