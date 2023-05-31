package sw.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class sw_정사각형방_1861_c2 {

	static int [][] map;
	static int T,N,NO,COUNT;
	static int dp[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int test_case =1;test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];
			dp = new int[N][N];

			for(int i=0;i<N;i++) {
				st= new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			
			NO=0;
			COUNT=1;
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {

					int cnt = dfs(i,j);
					int num = map[i][j];
					
					if(cnt > COUNT) {
						COUNT = cnt;
						NO = num;
					}else if(cnt == COUNT) {
						NO = (num <NO) ? num :NO;
					}

					}
				}
			System.out.println("#" +test_case+ " "+NO+" "+COUNT);
			}

	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	//조건에 맞으면 계속하다가
	//dp완성
	//가장 깊은 곳을 1로하고 ++해간다.
	static int dfs(int r,int c) { //그냥 map[][]의 값을 애초에 넘겨준다.num은 시작 방번호
	
		if(dp[r][c] != 0) return dp[r][c]; //이미 다른  dfs에 의해 완성되었을 경우
		//for문을 통해서 계속 갈 수 있으면 가고, 갈 수 없으면 거기서부터 시작 , 1을 리턴
		for(int k=0;k<4;k++) {
			int row = r+dr[k]; //arr[row][col]
			int col = r+dc[k];
			if(row >= 0 && row < N && col >= 0 && col < N && map[row][col] == map[r][c] +1 ) { //범위내에 있다면

				return dp[r][c] = dfs(row,col)+1;


			}
		}
		//더이상 갈 수 있는 길이 없다.
		return dp[r][c] = 1 ;
	}
}
