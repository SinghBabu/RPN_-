package main.java;

import java.math.BigDecimal;
import java.util.Stack;

public class PostfixEvaluation {
	
	public String evaluate(String postfixInput)
	{
		String [] input = postfixInput.split(" ");
		if(input.length == 2 && (input[1].equals("%") || input[1].equals("!")));
		else if(input.length < 3)
		  return "Input is Invalid";

		Stack<Double> container = new Stack<Double>();
		
		try {
			double output = 0;
			int i = 0;
			while(i<input.length)
			{
				String element = input[i];
				//if element is an operator
				if(element.length() == 1 && isOperator(element))
				{
					 if(isUnaryOperator(element)) {
						 if(element.equals("!") && container.peek() < 0)
							 return "Input is Invalid";
						 output = calculate(container.pop(), 0, element.charAt(0));
					 }
					 else
						 output = calculate(container.pop(), container.pop(), element.charAt(0));
				}
				else 
					     output = Double.parseDouble(element);
				
			  container.push(output);
			  i++;
			}
				
			Double ans = Double.parseDouble(container.pop().toString());
			if(container.isEmpty()) {
				if(Math.floor(ans) == Math.ceil(ans)) {
					int temp = Integer.parseInt(String.valueOf(new BigDecimal(ans).toPlainString()).split("\\.")[0]); 
				    return String.valueOf(temp);
				}
				return String.valueOf(ans);
			}
			else
				return "Input is Invalid";
			
		} catch (Exception e) {  
			//e.printStackTrace();
			return "Input is Invalid";
		}
	}
	
	//Function to check whether the element is operator or operand
	private boolean isOperator(String str)
	{
		char ch = str.charAt(0);
		switch(ch)
		{
			case '+':
			case '-':
			case '/':
			case '*':	
			case '%':
			case '!':
			case '^':
				return true;  
		}
		return false;
	}
	
	//Function to check whether an operator is unary or binary
	private boolean isUnaryOperator(String str)
	{
		char ch = str.charAt(0);
		switch(ch)
		{
			case '%':
			case '!':
				return true;
		}
		return false;
	}
	
	private double factorial(double n)
	{
		double ans = 1;
		while(n>1)
		{
			ans*= n;
			n--;
		}
	 return ans;	
	}
	
	//Function to evaluate operators and operands
		private double calculate(double oprnd1, double oprnd2, char opr)
		{
			double result = 0 ;
			try {
					switch(opr)
					{
					case '+':
						result = oprnd2 + oprnd1;
						break;
					case '-':
						result = oprnd2 - oprnd1;
						break;
					case '*':
						result = oprnd1 * oprnd2;
						break;
					case '/':
						result = oprnd2 / oprnd1;
						break;
					case '^':
						result = Math.pow(oprnd2, oprnd1);
						break;
					case '%':
						result = oprnd1 / 100;
						break;
					case '!':
						result = factorial(oprnd1);
						break;   
					}
			} catch (NumberFormatException e) {
				throw e;
			}
			return result;
		}

}
