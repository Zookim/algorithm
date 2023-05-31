package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_괄호의값_2504_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c[] = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		int value =1;
		int res=0;
		
		
		for(int i=0; i<c.length;i++) {
			char now = c[i];
			
			if(now == '(') {
				stack.push('(');
				value *= 2;
			}else if(now == '[') {
				stack.push('[');
				value *= 3;
			}else if(now == ')') {
				//스택이 비었거나 자신의 쌍이 아니면 실패
				if(stack.isEmpty() || stack.peek() != '(') {
					res =0;
					break;
				}// 아니라면 자신의 쌍이므로 값을 더해준다.단 모든 닫는 괄호에대해서가나이라
				// 방금 열고 닫힌괄호일때만 값을 더해준다.
				else if(c[i-1] == '(') {
					res += value;
				}
				//일단 닫혔다면 더해지는 값을 다시 줄여준다.
				value /= 2;
				stack.pop();
				
			}else if(now == ']') {
				//스택이 비었거나 자신의 쌍이 아니면 실패
				if(stack.isEmpty() || stack.peek() != '[') {
					res =0;
					break;
				}// 아니라면 자신의 쌍이므로 값을 더해준다.단 모든 닫는 괄호에대해서가나이라
				// 방금 열고 닫힌괄호일때만 값을 더해준다.
				else if(c[i-1] == '[') {
					res += value;
				}
				//일단 닫혔다면 더해지는 값을 다시 줄여준다.pop도 해야한다.
				value /= 3;
				stack.pop();
				
				
				
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println(res);
		}else {
			System.out.println(0);

		}
		
		

	}

}
