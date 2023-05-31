package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_최대힙_11279_우선순위큐{

	public static void main(String[] args) throws Exception{
		//우선 순위 큐를 사용하는 경우
		PriorityQueue<Integer> que = new PriorityQueue<>((n1,n2) -> n2-n1);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int now = Integer.parseInt(br.readLine());
			if(now ==0) {
				int res;
				Object obj = que.poll();
				if(obj == null) {
					res =0;
				}else {
					res = (int) obj;
				}
				sb.append(res).append("\n");
			}else {
				que.offer(now);
			}
			
			
		}
		System.out.println(sb);
	}

}
