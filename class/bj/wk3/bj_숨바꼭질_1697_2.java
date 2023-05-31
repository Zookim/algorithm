package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_숨바꼭질_1697_2 {
	//가장 작은수까지 *2
	

	static int K,N;
	static int count;;
	static Queue<Integer> que = new ArrayDeque<Integer>();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		count = Math.abs(K-N);

		que.offer(N);
		bfs(0);
		
		
		System.out.println(count);
		

	}

	static void bfs(int c) {
		int now = que.poll();
		
		if(now == K) {
			count = count < c? count:c; 
			return;}
		if(c>=count) {return;}
		//초과
		
		for(int i=0;i<3;i++) {
			if(i ==1) {
				que.offer(now*2);
				bfs(c+1);
			}else if(i==2) {
				que.offer(now+1);
				bfs(c+1);
			}
			else {
				que.offer(now-1);
				bfs(c+1);
			}
		}


	}

}
