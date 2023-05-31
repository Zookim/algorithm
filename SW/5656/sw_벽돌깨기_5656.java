package algo.wk6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw_벽돌깨기_5656 {

	//입력
	//전체벽돌의수
	
	//한턴이 끝나면 리셋
	
	static int N,T,W,H;
	static int [][][] arr;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		
		for(int test_case =1;test_case <= T;test_case++) {
			st = new StringTokenizer(br.readLine());
			
			min = Integer.MAX_VALUE;
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken()); //열
			H = Integer.parseInt(st.nextToken()); //행
			arr = new int[N+1][H][W];//
			
			for(int i=0;i<H;i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0;j<W;j++) {
					arr[0][i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			//입력 끝
			//dfs로 모든 경우를 돌며 최소값을 구한다.
			perm(0);
			System.out.println("#"+test_case+" "+min);
			
		}
		                                                 
		                                                
	}
	static int min;
	static void perm(int index) { //매 반복마다 새로운 맵을 사용하여 되돌아 올때 추가연산을 방지
		if(index == N) { 
			//남은 벽돌의 수를 세서 저장한다.
			int res = count();
//			if(min > res) {
//				print2(N);
//			}
			min = min >res ? res:min;
			//System.out.println();
			return;
		}
		
		
		//아직 턴이 남았으면 다음 위치에 블럭을 맞춘다.->중복 순열
		for(int i=0;i<W;i++) {
			arrayCopy(index+1);//매번 초기화
			//System.out.println(i+"shoot");
			shoot(i,index+1); //i위치를 맞추고 그부분을 제거한다,index를 활용해, index+1의 배열에 저장한다
			//print2(index+1);//
			reset(index+1); //모두 바닥으로 내린다.index+1번째에 저장한다.
			
			perm(index+1);
		}
		
		
		
	}
	static void print2(int n) {
		
			for(int a[]: arr[n]) {
				System.out.println(Arrays.toString(a));
			}
			
		
		
	}
	static void print() {
		for(int i=1;i<=N;i++) {
			for(int a[]: arr[i]) {
				System.out.println(Arrays.toString(a));
			}
			System.out.println();
		}
		
	}
	static void arrayCopy(int now) {
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				arr[now][i][j] = arr[now-1][i][j];
			}
		}
	}
	static class Loc{
		int r,c,range;

		public Loc(int r, int c,int range) {
			super();
			this.r = r;
			this.c = c;
			this.range= range;
		}
		
	}
	static Queue<Loc> que= new ArrayDeque<>();
	static void shoot(int shootpoint,int mapNumber ) {
		// 처음 부딪힌 값을 가져오고 
		for(int i=0;i<H;i++) {
			int a = arr[mapNumber][i][shootpoint];//
			if(a != 0) {
				que.offer(new Loc(i,shootpoint,a));
				
				break;
			}
		}
		
		
		while(!que.isEmpty()) {
			Loc now = que.poll();
			int row = now.r;
			int col = now.c;
			int range = now.range-1;
			//행을 돈다, 세로
			for(int i=(row - range);i<=(row + range);i++ ) {
				
				if(i>=0 && i<H) {//배열 범위내에 있으면
					
					int a = arr[mapNumber][i][col]; 
					
					if(a > 1) {que.offer(new Loc(i,col,a));}
					//사라져야한다.
					arr[mapNumber][i][col] = 0;

				}
			}

			//열을돈다, 가로
			for(int i=(col - range);i<=(col + range);i++ ) { //복붙
				if(i>=0 && i<W) {//배열 범위내에 있으면
					int a = arr[mapNumber][row][i];
					
					if(a > 1) {que.offer(new Loc(row,i,a));}//사라져야한다.
					arr[mapNumber][row][i] = 0;
				}
			}
			

		}
		// 연쇄되는 값이  2이상인 경우 큐에 저장하고, 큐가 빌때까지 블록을 계속제거한다.
	}
	static void reset(int mapNumber) {//더 줄일수 있다.
		//세로로 돈다
		for(int c=0;c<W;c++) {
			for(int r=(H-1);r>=0;r--) {
				if(arr[mapNumber][r][c] == 0) { //빈칸이 있으면
					//
					for(int i=(r-1);i>=0;i--) {
						int a = arr[mapNumber][i][c];
						if( a != 0) {  //0이 아닌 값을 가져온다.
							arr[mapNumber][r][c] = a;
							arr[mapNumber][i][c] =0;
							break; //1개씩만
						}
					}
					//
				}
			}
		}
	}
	static int count(){
		int count=0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<W;j++) {
				if(arr[N][i][j] != 0) {
					count++;
				}
			}
		}
		return count;
	}

}
