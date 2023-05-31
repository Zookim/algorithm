package sw.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_최적경로_1247 {
	//N명의 고객 방문
	//2-10, 이동경로가 가장짧은
	//짧은 거리 찾기
	static int loc[][];
	static int arr[][];
	static int N;
	static boolean []select;
	static int array[];
	static int work[] = {0,0};
	static int home[] = {0,0};
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception  {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case =1;test_case <= T; test_case++) {
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(br.readLine());
			select = new boolean[N];
			array = new int[N];
			arr = new int[N][N];
			
			
			
			//회사,집,고객들
			loc = new int[N][2]; //0은 시작점, 1은 도착점
			st = new StringTokenizer(br.readLine());
			work[0] = Integer.parseInt(st.nextToken());
			work[1] = Integer.parseInt(st.nextToken());
			home[0] = Integer.parseInt(st.nextToken());
			home[1] = Integer.parseInt(st.nextToken());
			
			for (int i = 0; i < N; i++) {
				loc[i][0] = Integer.parseInt(st.nextToken());
				loc[i][1] = Integer.parseInt(st.nextToken());
				
			}
			
			//입력
			//모든거리
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) { //
					

					arr[i][j] = arr[j][i] ==0 ? Math.abs(loc[j][0]-loc[i][0]) +Math.abs(loc[j][1]-loc[i][1]):
						arr[j][i];
				}
			}


			perm(0);
			System.out.println("#"+test_case+" "+min);


			 
		}

	}
	static void perm(int index) {
		if (index == N) {
			// 계산한다. 최솟값을 저장해놓는다.
			//System.out.println(Arrays.toString(array));
			int sum=0;
			for(int i=0;i<(N-1);i++) {
				
				sum += arr[array[i]][array[i+1]]; //array는 0 - 2
			}
			sum += Math.abs(work[0]-loc[array[0]][0]) +Math.abs(work[1]-loc[array[0]][1]);
			sum += Math.abs(home[0]-loc[array[N-1]][0]) +Math.abs(home[1]-loc[array[N-1]][1]);
			//System.out.println(sum);
			
			min = min > sum ? sum:min;
			return;
		}
		
		for(int i=0;i<N;i++) {
			if(select[i]) continue;
			select[i] =true;
			//System.out.println(i+" "+index);
			array[index] = i; 
			perm(index+1);
			select[i] =false;
		}
		
	}

}
