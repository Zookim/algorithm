package algogo.wk1;
// 잘못된 풀이
// 이렇게 풀면 스택에서 pop되는 값이 항상 (이므로 . 정확한 값을 구할수 없다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_쇠막대기_10799_2 {

	static class Stack{
		//p는 빈칸을 가리킨다.
		String stack[];
		int p=0;
		
		public Stack(int n) {
			stack = new String[n];
		}
		public void push(String str) {
			stack[p++] = str;
		}
		public String pop() {
			//return stack[--p];
			String s = stack[--p];
			stack[p] = null;
			return s;
		}
		public String peek() {
			return stack[p-1];
		}
		public int size() {
			return p;
		}
		public void print() {
			System.out.println(Arrays.toString(stack));
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split("");
		int totalpiece =0;
		Stack stack = new Stack(str.length);
		
		for(int i=0;i<str.length;i++) {
			if(str[i].equals(")")) {
				if(stack.pop().equals("(")) {
					totalpiece += stack.size();
				}else {// 근데 이 경우는 존재하지 않는다.
					//
					totalpiece += 1;
				}
				System.out.println(totalpiece);
				
			}else {
				stack.push(str[i]);				
			}
			stack.print();
			
		}
		System.out.println(totalpiece);
		
	}

}
