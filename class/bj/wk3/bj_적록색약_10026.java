package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//단 순 히 부분의 수를 합하거나 더하는 방식으로 푸는것은 배열이 어떻게 주어지느냐에 따라 틀린답을 도출한다.
public class bj_적록색약_10026 {
	//1. 배열원본을 수정하는 경우
	//G,R
	//상하좌우
	static int ans[][] ;
	static String arr[][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int N;
	static int num,nums;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//같으면 수를 같은수로...
		N = Integer.parseInt(st.nextToken());
		ans = new int [N][N];
		arr = new String[N][N];
		
		for(int i=0;i<N;i++) {
			Arrays.fill(ans[i],-1);
		}

		for(int i=0;i<N;i++) {
			String [] a = br.readLine().split("");
			for(int j=0;j<N;j++) {
				arr[i][j] = a[j]; 
				
			}
		}
		//입력
		num=0;
		nums=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				boolean t = find(i,j);
				if(t) {num++;}
				
				
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j].equals("R")) {
					arr[i][j] = "G";
				}
			}
		}
		for(int i=0;i<N;i++) {
			Arrays.fill(ans[i],-1);
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				boolean t = find(i,j);
				if(t) {nums++;}
				
				
			}
		}
		
		System.out.println(num + " "+nums);

	}
	
	static boolean find(int r,int c) {///짝 홀 G,R
		if(ans[r][c] != -1) return false; //이미 방문한경우 무시


		ans[r][c] = num;

		//인접한곳에 나와 같은 것이 있다면 큐에 넣고 이동한다.
		//값을 변경해준다.
		for(int i=0;i<4;i++) {
			int row = r+dr[i];
			int col = c+dc[i];

			if(row >= 0 && row <N && col >=0 && col <N && (arr[row][col].equals(arr[r][c]))) {
				find(row,col);
			}
			
		}

		return true; //더 이상 없을때
		
	}

}
