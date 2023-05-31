package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_하노이탑_11729 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		hanoi(N,1,2,3); //
		System.out.println(sb.toString());

	}
	//매 단계에서 이동과 관련된 정답은 sb에 append
	static void hanoi(int n, int from, int temp,int to) {
		//기저 조건
		 if (n==0) {return;}
		//현재 단계에서 수행할 일이 무엇인지
		 // 선행작업
		 hanoi(n-1,from,to,temp);
		 //현재 작업 :  from릐 맨밑 원반을 to로 이동 <= 출력 내용
		 //System.out.println(from + " "+to);
		 sb.append(from).append(" ").append(to).append("\n");
		 hanoi(n-1,temp,from,to);
		//재귀 호출은 언제 할것인지? 재귀 호출시 무엇을 줘야하는지 고려
	}
}
