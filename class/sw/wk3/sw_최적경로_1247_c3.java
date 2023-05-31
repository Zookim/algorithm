package sw.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_최적경로_1247_c3 {

	static int T, N, comY, comX, homeY, homeX, min;
	static int[][] cust; // src
	static boolean[] visit;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine()); // 고객수
			
			cust = new int[N][2];
			
			visit = new boolean[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			comY = Integer.parseInt(st.nextToken());
			comX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				cust[i][0] = Integer.parseInt(st.nextToken());
				cust[i][1] = Integer.parseInt(st.nextToken());
			}
			
			for (int i = 0; i < N; i++) {
				// visit 초기화
				Arrays.fill(visit, false);
				visit[i] = true;
				dfs( i, 1, distance(comY, comX, cust[i][0], cust[i][1]));
			}
			
			
			System.out.println("#" + t + " " + min);
		}

	}

	// c: 고객 index
	// d: depth
	// sum: dfs 로 계속 방문을 이어나가면서 거리의 합을 누적으로 전달, 계산
	// visit 로 방문체크
	static void dfs(int c, int d, int sum ) {
		// 기저조건
		if( d == N ) {
			sum += distance( homeY, homeX, cust[c][0], cust[c][1]);
			min = Math.min(min, sum);
			return;
		}
		
		for (int i = 0; i < N; i++) {
			if( visit[i] ) continue;
			int dis = distance(cust[c][0], cust[c][1], cust[i][0], cust[i][1]);
			
			// 가지치기
			if( sum + dis >= min ) continue;
			
			visit[i] = true;
			dfs( i, d + 1, sum + dis );
			visit[i] = false;
		}
	}
	
	static int distance(int y1, int x1, int y2, int x2) {// 맨하튼 거리 계산
		return Math.abs(y1-y2) + Math.abs(x1-x2);
	}
	

}