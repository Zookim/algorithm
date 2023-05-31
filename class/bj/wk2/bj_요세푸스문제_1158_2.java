package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_요세푸스문제_1158_2 {

	
	static int N,K;
	static Queue<Integer> queue =new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(b.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());


		for (int i = 1; i <= N; i++) {
			queue.offer(i);
			
		}
		
		// 풀이
		int count =0; // 죽은 사람의 수, 모두 죽으면 count ==N <= 종료조건
		int index =1; //죽은 사람 포함 //2.index
		int step=1; // 살아있는 번호에서만 증가 (K번째를 따진다.)
		
		//죽으면 0으로 표시한다.
		sb.append("<");
		
		int alive=1;
		while(! queue.isEmpty()) {
			int num = queue.poll();
			if(alive %K==0) {
				sb.append(num + ", ");
			}
			else {
				queue.offer(num);
			}
			alive++;
		}
		sb.setLength(sb.length()-2); // 마지막에 붙은,와 empty space를 제거
		sb.append(">");
		System.out.println(sb);
	
	}
}
