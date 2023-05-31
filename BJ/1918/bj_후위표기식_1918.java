package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_후위표기식_1918 {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		char now;
		Stack<Character> stack = new Stack<>();
		
		StringBuilder sb =  new StringBuilder();
		
		for(int i=0;i<input.length();i++) {
			now = input.charAt(i);
			
			if(now >= 'A' && now <='Z') {
				sb.append(now);
			}else if(now == '*' || now == '/') { 
				while(!stack.isEmpty() && (stack.peek() == '*' ||stack.peek() == '/' )) {
					sb.append(stack.pop());
				}
				stack.push(now);
			}else if(now == '+' || now == '-') {
				//자신보다 우선순위가 높은거나 같은 것이 있으면 줄력한다.
				while(!stack.isEmpty() && (stack.peek() != '(')) {
					sb.append(stack.pop());
				}
				stack.push(now);
				
			}else if(now == '(') { //우선순위가 가장 낮으므로
				stack.push(now);
				
			}else if(now == ')') { //
				while(!stack.isEmpty() && (stack.peek() != '(')) {
					sb.append(stack.pop());
				}
				stack.pop();
				
			}
		}
		while(!stack.isEmpty()) {sb.append(stack.pop());}
		System.out.println(sb);
		

	}

}
