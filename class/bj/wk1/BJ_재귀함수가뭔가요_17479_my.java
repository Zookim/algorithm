package bj.wk1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ_재귀함수가뭔가요_17479_my {

	public static void main(String[] args) throws Exception {
		BufferedReader b= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(b.readLine());
		StringBuilder str = new StringBuilder();
		str.append("");
		re(n,str);
	}
	
	public static void re(int n,StringBuilder str) {
		if(n== 0) {
			System.out.print(str);
			System.out.println("\"재귀함수가 뭔가요?\"");
			System.out.print(str);
			System.out.println("\"재귀함수는 자기 자신을 호출하는 함수라네\"");
			System.out.print(str);
			System.out.println("라고 답변하였지.");
			return;
		}
		
		System.out.print(str);
		System.out.println("\"재귀함수가 뭔가요?\"");
		System.out.print(str);
		System.out.println("\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
		System.out.print(str);
		System.out.println("마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
		System.out.print(str);
		System.out.println("그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
		
		str.append("____");
		re(n-1,str);
		
		if(str.length() !=0) {
			for(int i=0;i<4;i++) str.deleteCharAt(str.length()-1);
		}
		System.out.print(str);
		System.out.println("라고 답변하였지.");
		
		
		
	}

}