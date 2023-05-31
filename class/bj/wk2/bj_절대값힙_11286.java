package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

public class bj_절대값힙_11286 {


	static int lastindex;
	static int N;
	
	static PriorityQueue<Integer> pqueue = new PriorityQueue<>(
			(n1,n2) -> Math.abs(n1) == Math.abs(n2) ? n1-n2 :  Math.abs(n1) - Math.abs(n2) 
			);
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		
		for(int i=0;i<N;i++) {
			int data = Integer.parseInt(br.readLine());
			
			if(data == 0) {
				Integer min = pqueue.poll(); // 이미 위에서 말하는 대로 정렬되어있다.
				//비어있는 경우 null 리턴
				System.out.println(min == null ? 0: min);
			}
			else {
				pqueue.offer(data);
			}
		}
	}
}
