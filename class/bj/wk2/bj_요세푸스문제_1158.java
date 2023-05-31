package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_요세푸스문제_1158 {

	
	static int N,K;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(b.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		input = new int[N+1]; // 0 dummy

		for (int i = 1; i <= N; i++) {
			input[i] = i;
			
		}
		
		// 풀이
		int count =0; // 죽은 사람의 수, 모두 죽으면 count ==N <= 종료조건
		int index =1; //죽은 사람 포함 //2.index
		int step=1; // 살아있는 번호에서만 증가 (K번째를 따진다.)
		
		//죽으면 0으로 표시한다.
		sb.append("<");
		while(true) {
			if(count == N) break; //종료조건
			//k번째 사람을 선택해서 죽인다.
			//System.out.println(index);
			
			//살아있는 사람중에 k번째를 죽인다.
			//int newIdx = index % N+1; //1.
			if(input[index] != 0) {
				if((step % K) == 0) {
					sb.append(input[index]).append(", ");
					input[index] = 0; //죽음으로 표시
					count++; //죽은수 증가.
				}
				step++; //살아있는데k번째가 아니다.
			}
			index++;
			if(index >N) index =1; //2. 얘가 연산이 더 단순하기에 더 빠르다, C에선 큰차이가 없지만, 자바에선 차이가 크다
			//단순할뿐만아니라 조건에 해당할때만 초기화하므로 더빠르다.
		}
		sb.setLength(sb.length()-2); // 마지막에 붙은,와 empty space를 제거
		sb.append(">");
		System.out.println(sb);
	
	}
}
