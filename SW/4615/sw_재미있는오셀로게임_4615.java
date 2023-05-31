package my.wk5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
//
//
public class sw_재미있는오셀로게임_4615 {

	// N 의 수에 따라 격자를 생성한다.
	// 매 돌을 놓은후 사이에 있는 돌을 해당 색으로 바꾼다.

	// 돌을 놓을때 주변을 탐색해서 조건이 성립하면 배열값을 바꾼다
	//대각선포함
	static int map[][];
	static int dr[] = {-1,1,0,0,-1,-1,1,1};//상하좌우 대각선
	static int dc[] = {0,0,-1,1,-1,1,-1,1};
	static int N,M;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test = 1; test <= T; test++) {
			st = new StringTokenizer(br.readLine());
			N =Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());

			// 좌표 생성
			//흑 1, 백 2
			//2 1
			//1 2

			int mid = N/2;
			map = new int[N][N];
			map[mid-1][mid-1] = 2;
			map[mid][mid-1]= 1;

			map[mid-1][mid] = 1;
			map[mid][mid]= 2;


			//각돌을 놓으면 검사한다.
			for(int i=0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken())-1;
				int r = Integer.parseInt(st.nextToken())-1;

				int color =Integer.parseInt(st.nextToken());
				map[r][c]=color;
				check( r, c, color);
				//System.out.println("r "+r+"c "+c);
				//print();

			}
			int count=0;
			int wcount=0;

			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map[i][j]==1) {count++;}//흑돌의 수
					else if(map[i][j]==2){wcount++;}
				}
			}
			bw.write(String.valueOf("#"+test+" "+ count+" "+(wcount)));
            bw.flush();
			
			//System.out.println("#"+test+" "+ count+" "+(wcount));


		}

	}

	static void check(int r,int c,int color) {
		Queue<int []> que= new ArrayDeque<>();
		int n;
		if(color ==1) {n=2;}
		else {n=1;}

		for(int i=0;i<8;i++) {// 8방으로 현재 돌과 다른 내돌 사이에 상대 돌이 있는지 확인
			int row = r+dr[i];
			int col = c+dc[i];


			while(row >=0 && row <N &&col >=0 && col <N && map[row][col] == n) {//상대방 돌인동안
				que.offer(new int[] {row,col}); //큐에 넣는다.
				row += dr[i];
				col += dc[i];
			}
			if(row >=0 && row <N &&col >=0 && col <N && map[row][col] == color) {//나왔을때 내것고 범위를 벗어나지 않았다면 그사이를 바꾼다.
				while(!que.isEmpty()) {
					int [] now = que.poll();
					map[now[0]][now[1]] = color;//자신으로 바꾼다.
				}
			}
			que.clear();

		}




	}
	static void print() {
		System.out.println();
		for(int []a: map) {
			System.out.println(Arrays.toString(a));
		}
	}

}
