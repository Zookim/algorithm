package sw.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class sw_정사각형방_1861_c1 {

	static int [][] map;
	static int T,N,NO,COUNT;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		T = Integer.parseInt(br.readLine());
		
		for(int test_case =1;test_case <= T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			map = new int[N][N];

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

					dfs(i,j,map[i][j],1);

					}
				}
			System.out.println("#" +test_case+ " "+NO+" "+COUNT);
			}

	}

	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	static void dfs(int r,int c,int num,int cnt) { //그냥 map[][]의 값을 애초에 넘겨준다.num은 시작 방번호
		
		
		if(cnt > COUNT) {
			COUNT = cnt;
			NO = num;
		}else if(cnt == COUNT) {
			NO = (num <NO) ? num :NO;
		}
		
		for(int k=0;k<4;k++) {
			int row = r+dr[k]; //arr[row][col]
			int col = r+dc[k];
			if(row < 0|| row >= N|| col < 0 || col >= N || map[row][col] != map[r][c] + 1 )continue; 

			
			 dfs(row,col,num,cnt+1);
			 break;


		}

	}



}
