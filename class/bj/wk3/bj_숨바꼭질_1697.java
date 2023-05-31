package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_숨바꼭질_1697 {
	//가장 작은수까지 *2
	

	static int N,K;
	static int count;
	static boolean visit[] = new boolean[100_0000]; //적당히
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//먼저 K에 도착하는 경우의 시간
		
		bfs(N);
		if(count == 0) {
			System.out.println(0);
		}else {
			System.out.println(count-1);
		}
		

	}
	static void bfs(int n) {
		Queue<Integer> que = new ArrayDeque<>();
		que.offer(-1);
		que.offer(n);
		visit[n] = true;
		
		while(n!=K) {
			n = que.poll();
			
			if(n == -1) {
				count++;
				n=que.poll();
				que.offer(-1);
			}
			
			
			int now = n-1;
			if(now >=0 && !visit[now]) {
				que.offer(now);
				visit[now] = true;
			}
			
			
			now = n+1;
			if(now <100_0000 && !visit[now]) { //아예 넘지 않도록체크
				que.offer(now);
				visit[now] = true;
			}
			
			now = n*2;
			if(now <100_0000 && !visit[now]) {
				que.offer(now);
				visit[now] = true;
			}
			
			
		}
	
		
		
	}

}
