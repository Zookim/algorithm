package algo.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_괄호추가하기_16637 {

	static int T;
	static int [] lst;
	static int t;
	static String [] str;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(b.readLine());
		t = T/2;
		System.out.println(t);
		lst = new int[t];
	
		
		str = b.readLine().split("");
		perm(0);
		//check마저구현

	}
	static void perm(int index) {
		
		if(index == t) {
			System.out.println(Arrays.toString(lst));
			//check();
			return;
		}
		
		for(int i=1;i<=2;i++) {
			if((index >= 1) && (lst[index-1] == 1) && (i == 1)) {
				continue;
			}
			lst[index] = i;
			
			perm(index+1);
		
		}
		
	}
	static int check() {
		int index=0;
		Stack stack = new Stack();
		Stackoper oper = new Stackoper();
		
		stack.push(Integer.parseInt(str[T-1]));
		for(int i=T-2 ;i<=1;i-=2) {
			if(lst[index++] == 1) {
				stack.push(cal(Integer.parseInt(str[i-1]),stack.pop(),str[i]));
			}else {
			oper.push(str[i]);
			stack.push(str[i-1]);
			}
		}
		
		while(!stack.isOne()) {
			stack.push(cal(stack.pop(),stack.pop(),oper.pop()));
		}
		return stack.pop();
	}
	static class Stack {
		static int [] s = new int [T];
		static int m=-1;
		
		static void push(int n) {
			s[m++] =n;
		}
		static int pop() {
			return s[m--];
		}
		static boolean isOne() {
			if (m==0) return true;
			else return false;
		}
		
	}

}
