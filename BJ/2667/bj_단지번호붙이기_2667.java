package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_단지번호붙이기_2667 {

	// 연결된 것의 수와, 종류 수 
	//1.bfs
	static int N;
	static int count,num;
	static Queue<int []> que = new ArrayDeque<>();
	static boolean[][]  visit;
	static int map[][];
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws Exception  {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		visit = new boolean[N][N];
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String str[] = br.readLine().split("");
			for(int j=0;j<N;j++) {
	
				map[i][j] = Integer.parseInt(str[j]);

			}
		}
		//각각의 수를 언제 담아서 정렬?
		List<Integer> res = new ArrayList<>();
		
		for (int i = 0; i <N; i++) {
			for (int j = 0; j <N; j++) {
				num=0;
				if(map[i][j] == 1 && !visit[i][j]) {
					count++;
					bfs(i,j); //count :집단번호 , num :단지수
					res.add(num);
					//System.out.println(count +" "+ num);
					//print();
				}
				
				
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(count).append("\n");
		Collections.sort(res,(n1,n2) -> {return n1-n2;});
		for(int i=0;i<count;i++) {
			sb.append(res.get(i)).append("\n");
		}
		sb.setLength(sb.length()-1);
		System.out.println(sb);

	}
	static void bfs(int r,int c) {
		
		que.offer(new int[]{r,c});
		visit[r][c] = true;
		num++;

		while(!que.isEmpty()) {
			int[] now = que.poll();
			int nr = now[0];
			int nc = now[1];
			
			for(int i=0;i<4;i++) {
				int row = nr+dr[i];
				int col = nc+dc[i];

				if(col >= 0 && col <N && row >=0 && row < N && map[row][col] == 1 && !visit[row][col]) {
					num++;
					que.offer(new int[]{row,col});
					visit[row][col] = true;
					
				}
			}
		}
		
	}
	static void print() {
		for(boolean [] a: visit) {
			System.out.println(Arrays.toString(a));
		}
	}

//	static int dfs(int r,int c,int count) {
//		visit[r][c] = true;
//
//		for(int i=0;i<4;i++) {
//			int row = r+dr[i];
//			int col = c+dc[i];
//
//			if(col >= 0&& col <N && row >=0 && row > N && map[r][c] == map[row][col]) {
//				dfs(row,col,count+1);
//			}
//		}
//
//	}
	
	
	
	
	

}
