package algo.wk8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//2번 돌면서 횟수를 구한다.
//첫 순횟시엔 주변에 이뢰가 없는 것을 찿아 visit를 체크하고 그횟수를 구한다.(dfs)
//둘째 순회시엔 남은 것의 수를 구한다
//첫순회로 먼저 걸러져야할 요소들이 있으므로 각 순회를 따로 실시한다.
public class sw_파핑파핑지뢰찾기_1868 {
	static int N;
	static int[][] arr;
	
	static int[] dr = {-1,1,0,0,-1,-1,1,1};
	static int[] dc = {0,0,-1,1,-1,1,-1,1};
	static boolean[][] visit;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			N = Integer.parseInt(br.readLine()); //최대 300
			arr = new int[N][N];
			visit = new boolean[N][N];
			
			for(int i=0;i<N;i++) {
				String [] str = br.readLine().split("");
				for(int j=0;j<N;j++) {
					if(str[j].equals("*")) {
						for(int k=0;k<8;k++) {
							int row = i+dr[k];
							int col = j+dc[k];
							if(row < N && row >=0 && col <N && col >=0 &&arr[row][col] !=-1) {
								arr[row][col]++;
							}
						}
						
						
						arr[i][j]=-1;
						visit[i][j] = true;// 이후 카운팅하지 말아야하므로
						
					}
					
				}
				//우선 인접한 지뢰의 수를 표시
			}
			
//			for(int i=0;i<N;i++) {
//				System.out.println(Arrays.toString(arr[i]));
//			}
			
			//dfs로 1이상의 수로 둘러싸인 영역의 수를 구한다.
			int res=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(visit[i][j] == false && arr[i][j]==0) {//방문전이고 주변에 지뢰가 없는 경우
						res= res + dfs(i,j);
					}
					
				}
			}
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(visit[i][j] == false) {//방문전이고 주변에 지뢰가 없는 경우
						res++;
					}
					
				}
			}
			
			
			System.out.println("#"+test+" "+res);
			
		}//end testcase

	}
	static int dfs(int r, int c) {
		//내가 0이면 주변을 true로해준다
		//그과정에 또0이 있으면 dfs
		visit[r][c]=true;
		
		for(int k=0;k<8;k++) {
			int row = r+dr[k];
			int col = c+dc[k];
			if(row < N && row >=0 && col <N && col >=0 && visit[row][col] == false) {
				if(arr[row][col]==0 ) {
					dfs(row,col);
				}else {
					visit[row][col]=true;
				}
					
				
			}
		}
		return 1;
		
		
	}

}
