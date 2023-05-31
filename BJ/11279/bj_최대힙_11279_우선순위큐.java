package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class bj_�ִ���_11279_�켱����ť{

	public static void main(String[] args) throws Exception{
		//�켱 ���� ť�� ����ϴ� ���
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
