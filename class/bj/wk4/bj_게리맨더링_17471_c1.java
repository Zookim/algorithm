package bj.wk4;
//안된다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_게리맨더링_17471_c1 {

	//인구차이의 최소값
	
	static int N,min;
	static int[][] matrix;
	static boolean[] select; //부분집합 사용
	static boolean[] visit; // 각 그룹별 선거구가 모두 연결되어있는지 확인 <=dfs
	static Queue<Integer> que = new ArrayDeque<>();

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		matrix = new int[N+1][N+1]; //
		select = new boolean[N+1];
		visit = new boolean[N+1];
		
		min = Integer.MAX_VALUE;
		

		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1;i<=N;i++) {
			matrix[i][0] = Integer.parseInt(st.nextToken()); //dummy에 각 선거구별 인구수를 저장;
		}
		
		//인접 행렬
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); //인구수
			
			for(int j=1;j<n;j++) {
				int v = Integer.parseInt(st.nextToken());
				matrix[i][j] = v;
	
			}
		}
		
		//부분집합의 모든 경우의 수에 대해서, 모두 연결되었는지 확인,select에 같은 것들끼리 연결되어 있는지 확인
		subSet(1); //1부터 시작
		
		if(min == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(min);

		

	}
	static void subSet(int index) {
		if(index == N+1) {
			check();
			return;
		}
		
		select[index] = true;
		subSet(index+1);
		select[index] = false;
		subSet(index+1);
		
	}
	static void check() {
		//반복적으로 호출 되므로 초기화
		Arrays.fill(visit, false);
		que.clear();
		// A : bfs로 select 배열에 true인 것 하나로 시작해서 갈수 있는곳까지 모두간다.
		
		for(int i=1;i<=N;i++) {
			if(select[i]) { //일단 하나를 찾는다.
				visit[i] =true;
				que.offer(i);
				break;
			}
		}
		if(que.size() ==0) return; //선거구가 한쪽에 있으면 의미 없디.
		while(! que.isEmpty()) {
			int v = que.poll();
			for(int i=1;i<=N;i++) {
				int adj = matrix[v][i]; //v로 부터 갈 수 있는 adj
				if(adj !=0 && !visit[adj] && select[adj]) {
					visit[adj] = true; //A그룹에 연결되어있는 모든 정점에 기록
					que.offer(adj);
				}
			}
		}
		// B
		for(int i=1;i<=N;i++) {
			if(!select[i]) { //일단 하나를 찾는다.
				visit[i] =true;
				que.offer(i);
				break;
			}
		}
		if(que.size() ==0) return; //선거구가 한쪽에 있으면 의미 없디.
		while(! que.isEmpty()) {
			int v = que.poll();
			for(int i=1;i<=N;i++) {
				int adj = matrix[v][i]; //v로 부터 갈 수 있는 adj
				if(adj !=0 && !visit[adj] && !select[adj]) {
					visit[adj] = true; //A그룹에 연결되어있는 모든 정점에 기록
					que.offer(adj);
				}
			}
		}
		// 모두 방문할 수 있는 경우의 수인지 확인
		for(int i=1;i<=N;i++) {
			if(!visit[i]) return;//연결될 수 없는 경우
		}
		
		// 조건 만족
		//A,B각각 인구수의 합을 구한뒤 차를 구하고 이를 min으로 갱신
		int sumA = 0;
		int sumB = 0;
		for(int i=1;i<=N;i++) {
			if(!select[i]) sumA+= matrix[i][0];
			else sumB +=  matrix[i][0];
		}
		
		min = Math.min(min, Math.abs(sumA-sumB));
	}

}


