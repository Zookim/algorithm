package algo.wk9;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class bj_치즈_2636 {

	//모두 녹는데 걸리는 시간과
	// 한시간 전의치즈의 수

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
		//입력

		bfszero();
		//print();

		while(total>0) {
			hour++;
			bfs();
			//int count = 
			//total -= count;
			print();
		}

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
			//System.out.println(que.peek()[2] + " " + que.size());
			
			int now[] = queZero.poll();
			int r = now[0];
			int c = now[1];
			visit[r][c] = true;

			//다음으로 방문할곳을 확인한다.
			for(int i=0;i<4;i++) {
				int row = r+dr[i];
				int col = c+dc[i];

				if(row >= R || row <0 || col >=C || col <0) continue;
				if( map[row][col] == 0  && !visit[row][col]) {
					//System.out.println("row "+ row);
					//que.offer(new int{r,c});
					queZero.offer(new int[] {row,col});
				
					que.offer(new int[] {r,c,0});
				}
//				else if(map[row][col] == 11) {
//					count++;
//					map[row][col] = hour;
//					que.offer(new int{r,c});
//				}
				
			}

		}

		return count;


	}
	
	static void bfs() {
		//
		int startnum = que.peek()[2];
		
		while(startnum == que.peek()[2]) {
			//System.out.println(que.peek()[2] + " " + que.size());
			int now[] = que.poll();
			int r = now[0];
			int c = now[1];


			//다음으로 방문할곳을 확인한다.
			// 
			for(int i=0;i<4;i++) {
				int row = r+dr[i];
				int col = c+dc[i];

				if(row >= R || row <0 || col >=C || col <0) continue;
				if( map[row][col] == 11) {
					//System.out.println("row "+ row);
					map[row][col]=hour;
					que.offer(new int[] {row,col,hour});
				}
				
			}
			//print();

		}



	}
}