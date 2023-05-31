package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_����ǥ���_1918 {

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
				//�ڽź��� �켱������ �����ų� ���� ���� ������ �ٷ��Ѵ�.
				while(!stack.isEmpty() && (stack.peek() != '(')) {
					sb.append(stack.pop());
				}
				stack.push(now);
				
			}else if(now == '(') { //�켱������ ���� �����Ƿ�
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
