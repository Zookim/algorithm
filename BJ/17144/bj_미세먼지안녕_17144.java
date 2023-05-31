package my.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_미세먼지안녕_17144 {
	//반으로 쪼갠다.
	//T초마다 배열 돌리기
	
	//1. 미세먼지 확산\
	//2. 배열돌리기
	//쪼갠후 돌리고
	//다시 합친다
	//2-2사라지는 먼지
	
	//총 미세먼지양을 출력
	
	static int R,C,T;
	static int map[][];
	static int machine;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static int newmap[][];// 매번 초기화해서 사용
	public static void main(String[] args) throws Exception {
		BufferedReader br  = new BufferedReader(new InputStreamReader (System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<C;j++) {
				map[i][j] =  Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {//기계의 아래쪽 위치 저장
					machine = i;

					
				}
			}
		}
		
		//입력 완료
		
		
		for(int test=0;test<T;test++) { //T초간 진행
			//1.미세먼지의 확산
			
			wide();
			
			//2.배열을 돌린다, 미세먼지를 제거한다.
			//각각 복사해서 돌리고
			//이후에map에 저장한다.
			for(int i=0;i<R;i++) {
				for(int j=0;j<C;j++) {
					//System.out.println(i+" "+j);
					if((i== machine ||i== (machine-1)) && j == 0) {//사라지는 먼지
						map[i][j] = -1;//이전 값은 사라진다.
					}else if((i== machine ||i== (machine-1)) && j ==1){// 나오는 공기
						map[i][j] = 0;
					}
					
					else if(i<machine) {//위쪽
						map[i][j] = upcircle(i,j);
						
					}else {
						map[i][j] = downcircle(i,j);
					}
					
				}
			}
			
			print();
			
	
		}
		
		
		int sum=0;
		//먼지의 수
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(map[i][j] >=0) {
					sum+= map[i][j];
				}
			}
		}
		
		System.out.println(sum);
		
		
		
		
	}

	static int upcircle(int r,int c) { //반시계방향으로 돌린다.이전것에서 들고오므로 시계방향 한칸으로생각
		int layer = Math.min(Math.min(Math.abs(0-r), Math.abs((machine-1)-r)), Math.min( Math.abs(0-c), Math.abs((C-1)-c)));
		if(layer ==0) {
			if(r == 0+layer && (c!=C-layer-1) ) {//윗층이고, 오른쪽은 아닐때
				return newmap[r][c+1];
			}
			
			else if(r == (machine-1-layer) && (c!=layer+0)) { //아래이고왼쪽은 아닐때
				return newmap[r][c-1];//상,,상좌
				
			}else if(c==0+layer && r != layer+0) { //왼쪽이고, 위는 아닐때
				return newmap[r-1][c];//우, 상우
				
			}else if(c==C-1-layer && r != machine-1-layer) { //오른쪽이고 아래는 아닐때
				return newmap[r+1][c];//하,좌,,좌
				
			}
		}
		
		return newmap[r][c];
	}

	static int downcircle(int r, int c) {

		int layer = Math.min(Math.min(Math.abs(machine-r), Math.abs((R-1)-r)), Math.min( Math.abs(0-c), Math.abs((C-1)-c)));
		if(layer == 0) {
			if(r == machine+layer && (c!=layer+0) ) {//윗층이고,  왼쪽은 아닐때
				return newmap[r][c-1];
			}

			else if(r == (R-1-layer) && (c!=C-1-layer)) { //아래이고 오른쪽은 아닐때
				return newmap[r][c+1];//상,,상좌

			}else if(c== 0+layer&& r != R-1-layer) { //왼쪽이고, 아래는 아닐때
				return newmap[r+1][c];//우, 상우

			}else if(c== C-1-layer&& r != machine+layer) { //오른쪽이고 위는 아닐때
				return newmap[r-1][c];//하,좌,,좌

			}
		}
		
		return newmap[r][c];



	}


	
	
	static void print() {
		for(int a[] : map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
		
		
	}
	static void wide() {
		newmap = new int[R][C];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) { 
				//
				if(map[i][j] != 0 && map[i][j] != -1 ) {	// 0이나 -1이 아닐때, 
					int m =map[i][j];//이 값들은 마지막에 변경된다.
					int c=0;
					for(int k=0;k<4;k++) {
						int row = i+dr[k];
						int col = j+dc[k];
						if(col >=0 && col <C && row >=0 && row <R && map[row][col] != -1) { //범위내에있으면
							newmap[row][col]+= m/5;
							c++;
						}

					}
					
					newmap[i][j] += m-(int)(m/5)*c;//소수점 버리고
					
				}
				//
			}
		}
		
		for(int a[] : newmap) {
		System.out.println(Arrays.toString(a));
	}
	System.out.println();

	}

}
