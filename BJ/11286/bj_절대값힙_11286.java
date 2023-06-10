package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_절대값힙_11286 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		int N = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();            // 절대값 오름차순 ,오름차순 
		PriorityQueue<Integer> que = new PriorityQueue<>((n1,n2) ->(Math.abs(n1) == Math.abs(n2)) ? n1-n2:Math.abs(n1) - Math.abs(n2) ) ;
		
		for(int i=0 ;i<N;i++) {
			int n = Integer.parseInt(br.readLine());
			if(n==0) {
				if(que.isEmpty()) {
					sb.append(0).append("\n");
				}else {
					sb.append(que.poll()).append("\n");
				}
			}else {
				que.offer(n);
				
			}
		}
		System.out.println(sb);
	}

}
