package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
//blank에따로 저장해줘서 0이 많으면 안된다.
public class bj_스도쿠_2580_c1 {

	static int N=9;
	static int [][] map;
	static List<Point> zero;
	static boolean complete = false;
	static int len;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws Exception {
		StringTokenizer st;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		zero  = new ArrayList<Point>();
		map = new int[N][N];

	    //len=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				
				int n =  Integer.parseInt(st.nextToken());
				map[i][j] = n; 
				if(n ==0)zero.add(new Point(i,j));
			}
		}
		
		// 해당위치를 매순간 임의로 결정, 모두돌면 위치에 저장하고 끝낸다. 
		
		dfs(0);
		System.out.println(sb);

	}
	static void dfs(int index) {
		if(complete) return;
		if(index == zero.size()) {
			//여기서 값을 출력
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sb.append(map[i][j]).append(" ");
				}
				sb.append("\n");
			}
			return;
		}

		
		int y = zero.get(index).y;
		int x = zero.get(index).x;
		
		boolean [] visit = new boolean [N+1]; //0은 버린다.
		
		//격자의 후보 제외, 현재 상태에서 후보 확인
		
		for(int i=0;i<N;i++) {
			if(map[y][i] !=0) { visit[map[y][i]] =true;} //후보에서 제외
		}
		
		for(int i=0;i<N;i++) {
			if(map[i][x] !=0) visit[map[i][x]] =true; //후보에서 제외	
		}
		int ny = (y/3)*3;
		int nx = (x/3)*3;
		for (int i = ny; i < ny+3; i++) {
			for (int j = nx; j < nx+3; j++) {
				if(map[i][j] != 0) visit[map[i][x]] =true;
			}
		}
		
		// 후보들을 모두 결정
		
		for(int i=1;i<=N;i++) {
			if(visit[i]) continue;
			//후보에 있다면 임시로 그값으로 본다
				 map[y][x] = i;
				 dfs(index+1); // 다음 blank로간다.
				 map[y][x] = 0; //찾지 못한경우 다시 돌린다.
			
		}
	}
	
	static class Point{
		int x,y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
	}
	

}
