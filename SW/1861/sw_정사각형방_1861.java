package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class sw_정사각형방_1861 {
	static int N;
	static int arr[][];
	static int dp[];
	static int dr[] = {-1,1,0,0};//상하좌우
	static int dc[] = {0,0,-1,1};//상하좌우
	
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case =1;test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			dp = new int[N*N+1];
			arr = new int[N+1][N+1];
			
			Arrays.fill(dp,-1);
			
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<N;j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			//입력
			int max = Integer.MIN_VALUE;
			int num=N*N;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) { //dfs한다.
					int n = arr[i][j];
					int now = dfs(i,j,n);//각위치의 값을 반환한다.//사실안해줘도됨
					//함수에서 뭘 구할것인지 확실하게 결정
					
					if(now > max) {//최대인곳을 저장
						num = n;
						max = now;	
					}else if(now == max) {
						num = n;
					}
				}
			}
			
			
			
			System.out.println("#"+test_case+" "+num+" "+max);
			//System.out.println(Arrays.toString(dp));
			
			
			
		}

	}
	//각 위치에서 갈수 있는 최대값을 저장한다
	//자기 방향으로 오는 경우

	static int dfs(int r,int c,int num) {
		//기저조건 ,이미 구한값인 경우 이후 출력안함
		if(dp[num] != -1) return dp[num];
		
		
		//사방탐색, 있으면간다
		//없으면 그대로 나오고, 해당위치는 값은 1이된다,
		for(int i=0;i<4;i++) {
			int row = r+dr[i];
			int col = c+dc[i];//범위내에 있고, 1만큼 크다면간다.
			if(row >= 0 && row <N && col >=0 && col<N && ((num+1) == arr[row][col])) { 
				dp[num] = dfs(row,col,arr[row][col])+1;//1을 추가
				return dp[num] ;
			}
			
		}
		//조건이 맞지 않거나,->값은 1이다 
		//재귀 했다 끝난경우, -> 돌아나올때 , dp저장 및반환
		//어차피 다른경로는 없으므로 return으로 끝낸다.->돌아나오지 못하게한다.
		dp[num] = 1;
		return 1; //가장 끝의 값
		
	}
	
}
