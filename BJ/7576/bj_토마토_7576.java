package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_토마토_7576 {

	static int R,C;
	static int map[][];
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static boolean v[][];
	static Queue<int []> q = new ArrayDeque<>();
	
	static List<int[]> list = new ArrayList<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		v = new boolean[R][C];
		
		// 큐가 비면 더이상 익을 것이 없거나 다익은 상태
		// 익은 것의 갯수를 저장한다.
		//빈칸의 수도 저장한다.
		int blank=0;
		int count=0;
		q.offer(new int[] {-1,-1});
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				int a = Integer.parseInt(st.nextToken());
				map[i][j] =a;
				if(a == -1) {
					blank++;
				}else if(a==1){
					q.offer(new int[] {i,j});
					count++;
				}
						
			}
		}
		//
		//System.out.println(q.size());
		int day=0;
		int [] now = new int [2];
		while(!(R*C == (count+blank))) {
			now = q.poll();
			
			if(now[0] == -1) { //1일차
				day++;
				if(q.isEmpty()) {break;}
				now = q.poll();
				q.offer(new int[] {-1,-1});
				
			}
			//아직 남은 것이 있다.
			for(int i=0;i<4;i++) {
				int row = now[0] + dr[i];
				int col = now[1] + dc[i];
				
				if(row >=0 && row <R &&col >=0 && col <C &&(map[row][col]==0)) {
					// 범위 내에 있고, 아직 익기전이라면
					q.offer(new int[] {row,col});
					count++;
					map[row][col] =1;
				}
			}

		}
		if(R*C == (count+blank)) {
			System.out.println(day);
		}else {
			System.out.println(-1);
		}
		
		
		

	}

}
