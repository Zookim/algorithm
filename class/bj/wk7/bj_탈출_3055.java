package bj.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_탈출_3055 {
	// D <- S : 
	// 사방탐색
	//돌 X    물 *
	//최소시간
	// 같은시간동안 물을 먼저 이동시켜야한다. 
	//이제 떠날자리라면 물이차도 괜찮다.
	static int R,C;
	static char map[][];
	static boolean maps[][];
	static int startr,startc;
	static int endr,endc;
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static boolean visit[][];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		visit = new boolean[R][C];

		
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				if(map[i][j] == 'S') {
					map[i][j] = '.';
					startr = i;
					startc = j;
				}else if(map[i][j] == 'D') {
					endr = i;
					endc = j;
				}
			}
		}
		//입력
		
		int res = 0;
		res = bfs();
		if(res == -1) {
			System.out.println("KAKTUS");
		}else if(res ==0) {
			System.out.println(1);
		}else {
			System.out.println(res);
		}

	}
	static ArrayDeque<int[]> que = new ArrayDeque<>();
	
	static int bfs() {
		//물을 채운다
		// 이동할 방향을 넣는다.
		int res=0;
		que.offer(new int[] {startr,startc});
		visit[startr][startc] = true;
		while(!que.isEmpty()) {
			
			
			int n = que.size();
			water(); //map에 물을 채운다.-> 아래의 for문이끝나야 한턴이 끝난것이므로 for문 밖으로 빼주여야한다.
			for(int i=0;i<n;i++) { //지금있는 길이 만큼이동한다.
				
				//print();
				int now[] = que.poll();
				int r = now[0];
				int c = now[1];
				if(r==endr && c==endc) {
					//System.out.println("Sdf");
					return res;
					}// 탈출성공

				for(int k=0;k<4;k++) {
					int row = r+dr[k];
					int col = c+dc[k];
					if(row >= R ||row <0 || col >=C || col <0|| map[row][col]=='*' || map[row][col]=='X'|| visit[row][col]) continue;//물이 있는 곳과 바깥으론 이동 할 수 없다.
					que.offer(new int[] {row,col});	
					visit[row][col]=true;
				}
			}
			//
			res++;
			//System.out.println("asd");
			


		}
		//System.out.println("sdf");
		return -1;
		
	}
	static void water() {
		List<int[]> list = new ArrayList<>();
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				
				if(map[i][j] == '*') { //빈칸이면 이동가능하다.
					for(int k=0;k<4;k++) {
						int row = i+dr[k];
						int col = j+dc[k];
						if(row < R &&row >=0 && col < C && col >=0 && map[row][col]=='.') {
							list.add(new int[] {row,col});
						}
					}
				} 
				
			//
			}
		}
		
		//
		for(int[] a: list) {
			map[a[0]][a[1]] = '*';
		}
		
	}
	static void print() {
		for(char a[]: map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}

}
