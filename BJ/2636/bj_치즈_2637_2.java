package algo.wk9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_치즈_2637_2 {

	static int map[][];
	static int hour=0; // 이보다 
	static PriorityQueue<int[]> que = new PriorityQueue<>((n1,n2) -> n1[2] - n2[2]);//큰값이 뒤로 가도록
	
	static int R,C;

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		map = new int[R][C];
		int total=0;
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n ==1) {
					total++;
					map[i][j] = 11;
				}else {
					map[i][j] = n;
					
				}

			}
		}

		int count=0;
		while(total>0) {
			hour++;
			count = bfszero();
			total -= count;
			//print();
		}
		

	System.out.println(hour);
	System.out.println(count);
	
	
	}

	
	static void print() {
		for(int a[] : map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}
	
	static ArrayDeque<int[]> queZero = new ArrayDeque<>();
	
	static int bfszero() {
		queZero.offer(new int[] {0,0});
		boolean visit[][] = new boolean[R][C];
		int count=0;
		
		while(!queZero.isEmpty()) {
	
			int now[] = queZero.poll();
			int r = now[0];
			int c = now[1];
			visit[r][c] = true;

			for(int i=0;i<4;i++) {
				int row = r+dr[i];
				int col = c+dc[i];

				if(row >= R || row <0 || col >=C || col <0) continue;
				if( map[row][col] < hour  && !visit[row][col]) {
					queZero.offer(new int[] {row,col});
				}else if(map[row][col] == 11) {
					count++;
					map[row][col] = hour;
				}
				
			}

		}

		return count;


	}
	

}