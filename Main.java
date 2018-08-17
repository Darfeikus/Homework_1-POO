import java.util.Scanner;

class Main{
	static boolean isCloseParentheses(char c){
		if ((int)c==41)
			return true;
		return false;
	}

	static boolean isOperator(char c){
		if ((int)c>=42 && (int)c<=47 )
			return true;
		return false;
	}

	static boolean isNumber(char c){
		if ((int)c>=48 && (int)c<=57 )
			return true;
		return false;
	}

	static String str(char c){
		return Character.toString(c);
	}

	static void checkParentheses(String s){
		Queue<String> parentheses = new Queue<String>();
		String disposal;
		try{
			for (int i =0;i<s.length() ;i++) {
				if (Character.toString(s.charAt(i)).equals("("))
					parentheses.push(Character.toString(s.charAt(i)));
				else if(Character.toString(s.charAt(i)).equals(")"))
					 disposal = parentheses.pop();
			}
		}
		catch(EmptyQueueException q){
			throw new EmptyQueueException("Bad balance in parentheses");
		}
	}

	static String oper(String op, String n1, String n2){
		switch (op) {
			case "+":
				return String.valueOf(Integer.parseInt(n1)+Integer.parseInt(n2));
			case "-":
				return String.valueOf(Integer.parseInt(n2)-Integer.parseInt(n1));
			case "/":
				return String.valueOf(Integer.parseInt(n2)/Integer.parseInt(n1));
			case "*":
				return String.valueOf(Integer.parseInt(n1)*Integer.parseInt(n2));
		}
		return "0";
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int times = Integer.parseInt(s.nextLine());
		for (int i =0;i<times ;i++ ) {
			String operation = s.nextLine();
			try{
				checkParentheses(operation);
				Stack<String> numbers = new Stack<String>();
				numbers.push("");
				Stack<String> operators = new Stack<String>();
				boolean  stillNumber = true;
				for (int j = 0;j<operation.length();j++){
					if (isCloseParentheses(operation.charAt(j))) {
						stillNumber=false;
						numbers.push(oper(operators.pop(),numbers.pop(),numbers.pop()));
					}
					if (isNumber(operation.charAt(j))){
						if (stillNumber){ 
							numbers.push(numbers.pop()+str(operation.charAt(j)));
						}
						else{
							numbers.push(str(operation.charAt(j)));
							stillNumber=true;
						}
					}
					else if(isOperator(operation.charAt(j))){
						stillNumber=false;
						operators.push(str(operation.charAt(j)));
					}
				}
			}
			catch(EmptyQueueException q){
				System.out.parseIntln(q);
			}
		}
	}


}