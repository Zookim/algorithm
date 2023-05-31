package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.List;
import java.util.StringTokenizer;

public class bj_달이차오른다가자_1194_c {

	//열쇠는 여러번 사용할 수 있다.
	// 이동횟수의 최소 값
	// 너비 우선 탐색
	// 상하좌우로 이동한다.
	// 열쇠를 만나면 이를 갖고 같은 이후에 이어지는 경로를 탐색할때만 해당문을 지나갈수 있다.
	
	// 열쇠를 얻으면 다음 DFS의 입력값에 넣어준다.
	//문을 만나면 대응하는 열쇠 유뮤에따라 결정한다.
	//static List<String> keys = new ArrayList<>(); //만날때마다 추가해준다.
	
	static class Minsiki {
		int keys ;
		int r,c,m;
		
		public Minsiki(int r, int c,int keys,int m) {
			super();
			this.m = m;
			this.keys = keys;
			this.r = r;
			this.c = c;
		}

	}
	
	static int N;
	static int M;
	static ArrayDeque<Minsiki> que = new ArrayDeque<>();
	static char map [][];
	//static int res=-1;
	
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static boolean [][][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //행의수
		M = Integer.parseInt(st.nextToken()); //열의 수
		map = new char[N][M];
		visit = new boolean[N][M][1 << 6];
		
		for (int i = 0; i <N; i++) {
			String str = br.readLine();
			for(int j=0;j<M;j++) {
				char ch = str.charAt(j);
				map[i][j] = ch;
				if(ch== '0') {
					visit[i][j][0] =true;
					que.offer( new Minsiki(i,j,0,0) ); // 시작점 
				}
			}
		}
		//입력
			
		int res = bfs();
		
		System.out.println(res);

	}
	
	static int bfs() {
		
		while( !que.isEmpty() ) {
			Minsiki now = que.poll();
			
			int r = now.r;
			int c = now.c;
			int keys= now.keys;
			int m = now.m;
			
			System.out.println("r " + r + " c "+ c+ " m "+ m);
			
			if(map[r][c] == '1') {//끝 가장 먼저 도착한경우이므로
				
				return m;	
			}
			
			
			
			//아니면 다음으로간다 벽이 아니고 범위내에있고, 문이라면 열쇠가 있어야 갈수 있다, 열쇠라면 이동가능, 열쇠를 얻는다. 방문전 일떄..
			for(int i=0;i<4;i++) {
				int row = r+dr[i];
				int col = c+dc[i];
				
				if(row>=0 && col >=0 && row <N && col <M && (map[row][col] != '#') ) {
					char n = map[row][col];
					//만약 열쇠라면 엍는다
					if('a' <= n && 'f' >=  n ) {
						keys |= (1 << (n-'a')) ;//새로운 키 추가
						
					}
					//만약 문이라면 열쇠가 있을떄만 이동가능하다.
					else if('A' <= n && 'F' >=  n ) {
						 if((keys & ( 1 << (n-'A') )) == 0) { //열쇠가 있다면
							 continue;
						 }
					}
					if(visit[row][col][keys]) continue; 
					//방문하지 않았다면
					
					visit[row][col][keys] = true;
					
					que.offer(new Minsiki(row,col,keys,m+1));		
					
				}
			}
		}
		return -1;
	
	}

}
