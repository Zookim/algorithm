package swtest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import javax.swing.plaf.synth.SynthSeparatorUI;

//경로를 선택하므로 -> 배열복사, 물고기도 경로에따라 다른 값을 가지므로 배열 복사
//오타
public class bj_청소년상어_19236 {
	//각 물고기는 번호와 방향 1~16, 8방
	
	// 청소년 상어는 (0, 0)에 있는 물고기를 먹고, (0, 0)에 들어가게 된다. 상어의 방향은 (0, 0)에 있던 물고기의 방향과 같다. 이후 물고기가 이동한다
	
	//번호가 작은 물고기부터 순서대로 이동
	//1칸씩
	
	
	// 이동할 수 있는 칸이 없으면 이동을 하지 않는다
	// 물고기간의 이동:서로의 위치를 바꾸는 방식으로 이동
	
	// 물고기 이동후, 상어의 이동

	//상어가 먹을 수 있는 물고기 번호의 최대는?
	static int max =0;
	//---
	
	//방향 // 45도 반시계 회전 탐색, index를 줄이는 방향으로
  	// 2,1,8
	// 3, ,7
	// 4,5,6
	// 최대값...이므로 모든 경우를 고려.
                   //  0 1  2  3 4 5 6 7 8	
	static int dr[] = {0,-1,-1,0,1,1,1,0,-1};
	static int dc[] = {0,0,-1,-1,-1,0,1,1,1};
	
	//배열에 물고기 저장 배열을 돌며 각 물고기의 위치와 방향을 수정한다.
	//두 물고기가 같은 번호를 갖는 경우는 없다
	static int fish[][][] = new int[17][17][3]; //dummy, 방향,r,c,
	// 상어는 맵에 기록된 물고기를 보고 물고기를 선택한다.
	static int map[][][]=new int[17][4][4];//dummy
	//static int map1[][]=new int[4][4];
	//맵에는 물고기의 번호, 가 저장되있다.
	public static void main(String[] args) throws Exception {
		//입력
		//상어가 들어감
		// 작은 순서대로 물고기들이 서로 이동(반시계방향으로 탐색하며 반드시 이동한다. 마지막 방향으로 저장된다.)
		//(상어가 떠난 자리는 빈칸이 된다.)
		//상어는 이동가능하다면 그 방향에서 가장 큰값을 가지는 물고기위치로 이동한다.
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0;i<4;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 4; j++) {
				int fishnum = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				fish[0][fishnum][0] = d;
				fish[0][fishnum][1] = i;
				fish[0][fishnum][2] = j;
				map[0][i][j] =  fishnum;
				
			}
		}
		
		
		//입력
		int s = fish[0][map[0][0][0]][0]; 
		int res = map[0][0][0]; //초기값
		map[0][0][0] = -1;
		fish[0][res][0] = -1;//없어짐
		dfs(1,s,0,0,res); //  시작시 상어의  방향
		
		
		System.out.println(max);
		
		

	}

	static void dfs(int index,int sharkD,int srow, int scol,int res) {
		//printmap();
		//상어의 방향이 존재- -1:상어의 위치,빈칸은0으로 돌려준다.
		//물고기 배열 순회 -> 상어의 다음 탐색을 위해 맵에 다시 기록 -> 상어의 이동
		
		copyMap(index);
		copyfish(index);
		
		
		//System.out.println(index+" sharkD "+sharkD +" srow "+ srow+" scol "+scol);
		//printmap(index); 
		//System.out.println("before");
		//printmap(index); 
		if(res > max) max = res;
		
		for (int i = 1; i <= 16; i++) { //빈칸일 경우
			// 이동가능 한 방향을 찾는다.
			int d =  fish[index][i][0];
			if(d==-1)continue;
			
			int row =  fish[index][i][1];
			int col =  fish[index][i][2];
			for(int j=0;j<8;j++) {//빈칸, 다른 물고기가 있는 칸으로 이동 가능, 상어가 있으면 x
				int r = row + dr[d];
				int c = col + dc[d];
				d++;
				if(d >8) {d=1;}
				
				if(r <0 || c<0|| r>=4||c>=4 ||map[index][r][c]==-1) {continue;}
				//찾으면
				else{//범위 내에있고 상어의 위치가 아니라면
					if(map[index][r][c]==0) {
						map[index][r][c] = i;
						fish[index][i][1] = r;
						fish[index][i][2] = c;
						map[index][row][col] =0;
					}else {
						int chaneFishNum = map[index][r][c];
						fishswap(index,i,chaneFishNum);

					}
					d--;
					if(d ==0) {
						d=8;
					}
					fish[index][i][0] = d;
					break;
				}


			}// 방향탐색
			//

		}
		//System.out.println("after");
		//
		//printmap(index); 
		//이동할 칸이없으면 종료
		//상어의 이동
		int sr = srow;
		int sc = scol;
		while(true) {
			sr += dr[sharkD];
			sc += dc[sharkD];
			if(sr < 0 || sc<0 || sr >=4 ||sc>=4) {
				//map
				return;
			}//범위를 벗어나면 종료
			int n = map[index][sr][sc];// 이동할 위치
			//System.out.println(sr+" "+sc);
			
			
			if(n != 0) {// 물고기가 있는 곳으로 만 이동 가능
				
				int tmp = fish[index][n][0];//먹는 물고기의 방향
				fish[index][n][0] = -1;//죽은 물고기
				map[index][sr][sc] = -1;//상어의 이동
				map[index][srow][scol] = 0;
				// 지도 , 바꿀 방향, r,c,지금까지의 값
				
				dfs(index+1,tmp,sr, sc,res + n);
				 
				fish[index][n][0] = tmp;//물고기를 되살린다.
				map[index][sr][sc] = n;//상어가 이동하기 전으로 되돌린다.
				map[index][srow][scol] = -1; // 상어의 원래 위치

			}
			
			
		}







	}
	static void copyfish(int index) {//index-1을 index로 복사한다.
		for(int i=0;i<17;i++) {
			for(int j=0;j<3;j++) {
				fish[index][i][j] = fish[index-1][i][j];
			}
		}
	}
	static void copyMap(int index) {//index-1을 index로 복사한다.
		for(int i=0;i<4;i++) {
			for(int j=0;j<4;j++) {
				map[index][i][j] = map[index-1][i][j];
			}
		}
	}
	static void fishswap(int index,int n1,int n2) { //map의 상태와, fish배열의 r,C를 수정
		int r = fish[index][n1][1];
		int c = fish[index][n1][2];
		
		int r2 = fish[index][n2][1];
		int c2 = fish[index][n2][2];
		
		fish[index][n1][1] = r2;
		fish[index][n1][2] = c2;
		
		fish[index][n2][1] = r;
		fish[index][n2][2] = c;
		
		map[index][r][c] = n2;
		map[index][r2][c2] =n1;
		
	}
	static void printmap(int index) {
		System.out.println(index);
		for(int a[]:map[index]) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}

}
