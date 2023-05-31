package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_숨바꼭질_1697_c1 {
	

	static int K,N;
	static int count;;
	static Queue<Integer> que = new ArrayDeque<Integer>();
	static int[]  visit = new int[100000]; //그냥 충분히큰수 ?
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		System.out.println(bfs(N,K));

	}
	
	static int bfs(int N,int K) {
		int minus = 0;
		int plus =0;
		int mul=0;
		
		visit[N] =0;
		que.add(N);
		
		while(! que.isEmpty()) {
			int curr = que.poll();
			
			if(curr == K) break;
			
			minus = curr-1;
			plus =curr+1;
			mul = curr*2;
			
			if(minus >=0 && visit[minus] == 0) { //0미만의 값이 아니고, 아직 방문하지 않은 수라면
				visit[minus] = visit[curr]+1; // 해당 값가지 오는 동안 걸린 초를 저장한다.
				que.offer(minus);
			}
			if(plus <=100000 && visit[plus] == 0) { //0미만의 값이 아니고, 아직 방문하지 않은 수라면
				visit[minus] = visit[curr]+1; // 해당 값가지 오는 동안 걸린 초를 저장한다.
				que.offer(plus);
			}
			if(mul >=0 && visit[mul] == 0) { //0미만의 값이 아니고, 아직 방문하지 않은 수라면
				visit[mul] = visit[curr]+1; // 해당 값가지 오는 동안 걸린 초를 저장한다.
				que.offer(mul);
			}
			
		}
		
		return visit[K];
	}


}
