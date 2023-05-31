package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_연구소_14502_c {
	static int N,M,max;
	static int [][] map, virusMap;
	static boolean visit[][];
	static List<int[]> virus = new ArrayList<>();
	static List<int[]> zero = new ArrayList<>();
	static int zeroSize;
	static int wall[][] = new int[3][2]; //벽이 세워지는 src해당
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		max = Integer.MIN_VALUE;
		

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <M; j++) {
				int a =  Integer.parseInt(st.nextToken());
				map[i][j] = a;
				
				if(a==0)zero.add(new int[] {i,j});
				else if(a==2) virus.add(new int[] {i,j});
			
			}
		}
		//입력
		zeroSize = zero.size();
		
		comb(0,0);
		System.out.println(max);

	}

	static void comb(int srcIdx,int tgtIdx) {
		if(tgtIdx == 3) {
			virus();
			return;
		}
		if(srcIdx == zeroSize ) return;
		wall[tgtIdx] = zero.get(srcIdx);
		
		wall[tgtIdx] = zero.get(srcIdx);
		comb(srcIdx+1,tgtIdx+1);
		comb(srcIdx+1,tgtIdx);
		
		
	}
	static void virus() {
		virusMap = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				virusMap[i][j] = map[i][j];
			}
		}
		
		
		for (int i = 0; i < 3; i++) {
			virusMap[wall[i][0]][wall[i][1]]=1;
			
		}
		for (int[] v : virus) {
			dfs(v[0],v[1]);
		}
		//안전지대 계산
		int sum =0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if(virusMap[i][j] == 0) sum++;
			}
		}
		max = Math.max(max,sum);
		
	}
	static void dfs(int r,int c) {
		for (int i = 0; i < 4; i++) {
			int nr = r+dr[i];
			int nc = c+dc[i];
			if(nr < 0 || nc <0 ||nr >= N|| nc >= M || visit[nr][nc] ) continue;
			if(virusMap[nr][nc]==0) {
				virusMap[nr][nc] =2;
				visit[nr][nc] =true;
				dfs(nr,nc);
			}
		}
	}

}
