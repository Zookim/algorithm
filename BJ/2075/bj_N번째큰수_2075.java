package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_N번째큰수_2075 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; 
		PriorityQueue<Integer> pque = new PriorityQueue<>((n1,n2) -> n1-n2); //작은수가 먼저 나온다
		
		int N = Integer.parseInt(br.readLine());
		int Nst = Integer.MIN_VALUE;
		


		for(int i=0 ;i<N;i++) {
			st = new StringTokenizer(br.readLine());

			for(int j =0;j<N;j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n < Nst) continue;

				pque.offer(n);
				if(pque.size() ==  N) {
					Nst = pque.poll();
				}



			}
		}
		System.out.println(Nst);

		
	}
	

}
