package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_°ýÈ£ÀÇ°ª_2504 {

	public static void main(String[] args) throws Exception {
		
		Stack<Character> stack = new Stack<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char c[] = br.readLine().toCharArray();
		
		int mul = 1;
		int res = 0;
		

		
		for(int i=0;i<c.length;i++) {
			char now = c[i];

			if(now == '(') {
				stack.push(c[i]);
				mul *= 2;
			}else if(now == '[') {
				stack.push(c[i]);
				mul *= 3;
			}else if(now == ')') {
				if(stack.isEmpty() || stack.peek() !='(') {
					res =0; break;
				}if(c[i-1] == '('){
					res += mul;
					
					
				}
				stack.pop();
				mul /= 2;
			}else if(now == ']') {
				if(stack.isEmpty() || stack.peek() !='[') {
					res =0; break;
				}if(c[i-1] == '['){
					res += mul;
					
					
				}
				stack.pop();
				mul /= 3;
			}
			
			
		}
		System.out.println(!stack.isEmpty()?0:res);
		

	}

}
