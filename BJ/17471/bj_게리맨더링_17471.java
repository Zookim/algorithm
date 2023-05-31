package algo.wk6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_게리맨더링_17471 {
	//1.구역을 나눈다.
	//2. 나눈것들이 모두 연결되어있고, 인접한지 확인한다.
	//2-1.어떤 점에서 시작해, 자신의 선거구에 포함된것들만을 지나며 모두를 방문할수 있는지
	//두 집합 모두에서 확인하다.
	//3.가장 인구차가 적은 것을 선택한다.
	
	//없을때만 끝까지 간다.
	
	static int N,total;
	static int population[][];
	static boolean matrix[][];
	static boolean divide[];
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		divide = new boolean[N+1];
		population = new int[N+1][2];
		matrix = new boolean[N+1][N+1];
		
		st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			population[i][0] =  Integer.parseInt(st.nextToken());
			total += population[i][0];
		}
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			for(int j=1;j<=a;j++) {
				int b = Integer.parseInt(st.nextToken());
				matrix[i][b] = true; //이미 양방향으로 넣어준다.
			}
		}
		
		subSet(1);//구역은 1부터시작
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
		

	}
	static int SumA=0;
	static int min = Integer.MAX_VALUE;
	static void subSet(int index) {
		if(index == N+1) {
			//초기화
			
			if(SumA == total || SumA==0) return;//하나의 집합이어선 안된다.
			
			for(int i=1;i<=N;i++) {
				population[i][1] =0;
			}
			//나눈것들이 각자 잘 연결되어 있는지 확인한다.
			
			if(check()) {
				
				//System.out.println(Arrays.toString(divide));
				//System.out.println("SumA "+SumA);
				int a = Math.abs(total-2*SumA);
				//System.out.println(a);
				min = min > a? a : min;
			}
			return;
		}
		//선택하는 경우
		divide[index] = true;
		SumA += population[index][0];
		subSet(index+1);
		
		//선택을 다시 취소하는 경우
		divide[index] = false;
		SumA -= population[index][0];
		subSet(index+1);
		
		
	}
	static boolean check() {//연결을 확인. 만약 한쪽 집합의 합이 0이라면 그경우는 제외한다.
		int t=0,f=0;
		boolean tres = false;
		boolean fres = false;
		
		for(int i=1;i<=N;i++) { 
			if(divide[i] && t==0) { //true 집합인경우,한번씩만 확인
				tres = bfs(i,divide[i]);
				t=1;
				continue;
				
				
			}else if(!divide[i] && f==0) {//false인 경우
				f=1;
				fres = bfs(i,divide[i]);
				continue;
			}
		}
		
		if(tres && fres) {return true;}
		else return false;
	}
	static boolean bfs(int start,boolean set) {
		Queue<Integer> que= new ArrayDeque<>();
		que.offer(start);
		population[start][1] = 1;
		int sum=0;
		
		//모두 방문한 경우와 그렇지 않은경우 구별하기
		
		while(!que.isEmpty()) {
			int now = que.poll();
			
			sum += population[now][0]; 
			
			
			for(int i=1;i<=N;i++) {//같은집합이고, 방문전, 다음으로 갈곳이 있다면 넣는다.
				if(matrix[now][i] && population[i][1] == 0 && divide[i] == set) { //now와 인접한경우,아직 방문하지 않은 경우
					que.offer(i);
					population[i][1] = 1;//예약
				}
			}

		}
		//방금전 탐색으로 모두 돌았는지 확인
		for(int i=1;i<=N;i++) {
			if(divide[i] == set) {
				if(population[i][1] == 0 ) {//같은집합이지만 방문하지 않은 것이 있다면
					return false;
				}
			}
			
		}
		return true;
		
	}

}
