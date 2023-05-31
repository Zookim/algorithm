package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_감시_15683 {
	// 0은 빈 칸, 6은 벽, 1~5는 CCTV의 번호
	//CCTV는 벽을 통과할 수 없다
	//CCTV는 CCTV를 통과할 수 있다
	
	// 각 cctv들을 순서대로 가능한 방향으로 감시하고 -> 사각지대의 최소수를 구한다.(매순간 사각지대의 수를 알고 있어야한다.)
	static int N,M,blank;
	static int map[][];
	static int tmpmap[][][];
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	
	static int dr2[] = {-1,0, 0,1, 1,0, 0,-1};//상우,우하,하좌,좌상
	static int dc2[] = {0,1,  1,0,  0,-1, -1,0};
	//5,4,3,2,1
	//9 는 감시하는 부분
	static List<int[]> cctv = new ArrayList<int[]>();
	static List<int[]> cctv5 = new ArrayList<int[]>();
	static int cnum;
	static int count;
	static int max = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		
		
		cctv.add(new int[] {0,0,0});//dummy
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				 int n= Integer.parseInt(st.nextToken());
				 map[i][j] = n;
				 if(n==0) { //감시할영역의 수를 구한다.
					 blank++;
				 }else if(n<=4) { 
					 cctv.add(new int[] {i,j,n});//1,2,3,4
				 }else if(n==5) {
					 cctv5.add(new int[] {i,j});//5
				 }
			}
		}
		
		cnum = cctv.size(); //dummy 포함
		tmpmap = new int[cnum][N][M];
		//System.out.println(cnum);
		//CCTV는 벽을 통과할 수 없다
		//CCTV는 CCTV를 통과할 수 있다
		// CCTV,map 완성
		// 5는 확정이므로 이를 지도에바로 표시해준다.
		for(int[] list :cctv5 ) {
			for(int k=0;k<4;k++) {
				int row = list[0];
				int col = list[1];
				int r =dr[k];
				int c= dc[k];
				while(true) { //벽을 만날때 까지 ,cctv는 통과하면서 #
					row+=r;
					col+=c;
					if(row >= N || row <0 || col >= M || col <0 || map[row][col] == 6)break;
					if( map[row][col] >= 0 && map[row][col] <= 5) {
						if(map[row][col]==0) {
							map[row][col] = 9; //감시하는 부분
							 blank--;
						}//아니면 cctv가 있는 것이므로 체크하지 않늕다.
					}
				}//while
			}
		}
		// 첫복사
		
		
		//모든 4번의 방향을 고려한다 -> 모든 3번의 방향을 고려한다. -> 모든 2번의 방향을 고려한다. -> 모든 1번을 고려한다
		// 사각지대의 값을 구하고
		// 어떤 번호를 고려하더라도 제외되는 경우는 ...
		
		copymap(); //0번째 맵을 복사.
		
		dfs(1);
		System.out.println(max);
		//print();
		
		
		
	}
	//count는 감시가능한 영역의 수이므로 최대가 되어야한다.
	static void dfs(int index) { // index는 몇번째 cctv의 방향을 결겅하고 있는지를 나타낸다.
		//System.out.println(index + " "+cnum);
		
		if(index == cnum) {
			count=0;
			//print(index-1);
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(tmpmap[index-1][i][j]==0) {
						count++;
					}
				}
			}
			//System.out.println(count);
			max = count < max? count:max;
			return;
		}
		
	
		
		// 어느티비
		int nowtv[] = cctv.get(index);
		switch(nowtv[2]) {
		case 1://1번 이면 4가지 경우를 고려해야한다.
			for(int k=0;k<4;k++) {

				copymap(index);// 현재 index번째 맵에서 수정하므로
				int row = nowtv[0];
				int col = nowtv[1];
				int r =dr[k];
				int c= dc[k];
				while(true) { //벽을 만날때 까지 ,cctv는 통과하면서 #
					row+=r;
					col+=c;
					if(row >= N || row <0 || col >= M || col <0 || tmpmap[index][row][col] == 6)break;
					if( tmpmap[index][row][col] >= 0 && tmpmap[index][row][col] <= 5) {
						if(tmpmap[index][row][col]==0) {
							tmpmap[index][row][col] = 9; //감시하는 부분

						}//아니면 cctv가 있는 것이므로 체크하지 않늕다.
					}
				}//while, 1번 이므로 한방향으로 다 그렸으면 다음으로 넘겨준다.

				dfs(index+1);

				
			}
			break;
			
		case 2://2가지 경우를 고려
			for(int k2=0;k2<4;k2=k2+2) {

				copymap(index);// 현재 index번째 맵에서 수정하므로
				for(int k=0;k<2;k++) {
					//System.out.println(k);
					int row = nowtv[0];
					int col = nowtv[1];
					int r =dr[k2+k];
					int c= dc[k2+k];
					while(true) { //벽을 만날때 까지 ,cctv는 통과하면서 #
						//System.out.println(k);
						row+=r;
						col+=c;
						if(row >= N || row <0 || col >= M || col <0 || tmpmap[index][row][col] == 6)break;
						if( tmpmap[index][row][col] >= 0 && tmpmap[index][row][col] <= 5) {
							//print(index);
							if(tmpmap[index][row][col]==0) {
								//System.out.println(row+" "+col);
								tmpmap[index][row][col] = 9; //감시하는 부분
		
							}//아니면 cctv가 있는 것이므로 체크하지 않늕다.
							//print(index);
						}
					}//while, 2번 이므로 한방향으로 다 그렸으면 다음으로 넘겨준다.
				}
	
				dfs(index+1);


			}
			break;

		case 3: //4가지 경우를 고려
			for(int k=0;k<8;k+=2) {
				copymap(index);// 현재 index번째 맵에서 수정하므로
				for(int k2=0;k2<2;k2++) {
					
					int row = nowtv[0];
					int col = nowtv[1];
					int r =dr2[k+k2];
					int c= dc2[k+k2];
					while(true) { //벽을 만날때 까지 ,cctv는 통과하면서 #
						row+=r;
						col+=c;
						if(row >= N || row <0 || col >= M || col <0 || tmpmap[index][row][col] == 6)break;
						if( tmpmap[index][row][col] >= 0 && tmpmap[index][row][col] <= 5) {
							if(tmpmap[index][row][col]==0) {
								tmpmap[index][row][col] = 9; //감시하는 부분
					
							}//아니면 cctv가 있는 것이므로 체크하지 않늕다.
						}
					}//while, 1번 이므로 한방향으로 다 그렸으면 다음으로 넘겨준다.

				}

				dfs(index+1);


			}
			break;



		case 4:// 4가지 경우를 고려 
			for(int k=0;k<4;k++) { //4이므로 하나를 제외하고 그리는 경우

				copymap(index);// 현재 index번째 맵에서 수정하므로
				for(int k2 =0;k2<4;k2++) {
					if(k==k2) continue;
					int row = nowtv[0];
					int col = nowtv[1];
					int r =dr[k2];
					int c= dc[k2];
					while(true) { //벽을 만날때 까지 ,cctv는 통과하면서 #
						row+=r;
						col+=c;
						if(row >= N || row <0 || col >= M || col <0 || tmpmap[index][row][col] == 6)break;
						if( tmpmap[index][row][col] >= 0 && tmpmap[index][row][col] <= 5) {
							if(tmpmap[index][row][col]==0) {
								tmpmap[index][row][col] = 9; //감시하는 부분

							}//아니면 cctv가 있는 것이므로 체크하지 않늕다.
						}
					}//while, 

				}//한턴이 끝났다.

				dfs(index+1);

				
			}
			break;
		}

		// 사각지대의수를 구한다.
		// 다음 index로 넘기기
		
		
		
		
		
	}
	static void copymap() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmpmap[0][i][j] = map[i][j];
			}
		}
		
	}
	static void copymap(int n) {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				tmpmap[n][i][j] = tmpmap[n-1][i][j];
			}
		}
		
	}
	static void print(int n) {
		for(int a[] :tmpmap[n]) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}

}
