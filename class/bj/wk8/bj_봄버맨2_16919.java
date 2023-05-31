package bj.wk8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_봄버맨2_16919 {
// 모든칸이 터지는 경우
	static String map[][][];
	static int R,C,N;
	static int dr[] = {-1,1,0,0};
	static int dc[] = {0,0,-1,1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new String[4][R][C];
		
		for (int i = 0; i <R; i++) {
			//for (int j = 0; j <C; j++) {
				map[0][i] = br.readLine().split("");
			//}
		}
		
		for (int i = 0; i <R; i++) {
			for (int j = 0; j <C; j++) {
				map[1][i][j] = "O";
			}
		}
		//
		for (int i = 0; i <R; i++) {
			for (int j = 0; j <C; j++) {
				if(map[0][i][j].equals(".")) { 
					map[2][i][j] = "O";
				}else { //얘의 사방도 .
					map[2][i][j] = ".";
				}
				
			}
		}	
		int count=0;
		for (int i = 0; i <R; i++) {
			for (int j = 0; j <C; j++) {
				if(map[0][i][j].equals("O")) { 
					count++;
					for(int k=0;k<4;k++) {
						int r = i + dr[k];
						int c = j + dc[k];
						if(r<0 || c<0|| c>=C || r>=R) continue;
						map[2][r][c] = ".";
					}
				}
				
			}
		}	
		
		// 두번째
		for (int i = 0; i <R; i++) {
			for (int j = 0; j <C; j++) {
				if(map[2][i][j].equals(".")) { 
					map[3][i][j] = "O";
				}else { //얘의 사방도 .
					map[3][i][j] = ".";
				}
				
			}
		}	
		for (int i = 0; i <R; i++) {
			for (int j = 0; j <C; j++) {
				if(map[2][i][j].equals("O")) { 
					for(int k=0;k<4;k++) {
						int r = i + dr[k];
						int c = j + dc[k];
						if(r<0 || c<0|| c>=C || r>=R) continue;
						map[3][r][c] = ".";
					}
				}
				
			}
		}	
		
		//print();
		
		//     짝, ,짝
		// 1:0,/ 2:1, 3:2, 4:1, 5:3
		//               1    2    3    4   
		//System.out.println(N);
		if( count ==0) {
			if(N==1) {
				outprint(0);
			}else if(N==2){
				outprint(1);
			}else if((N-2) % 3==0) {
				outprint(2);
			}else{
				outprint(1);
			}
		}else {
			if(N==1) {
				outprint(0);
			}else if(N % 2==0) {
				outprint(1);
			}else if((N -1)% 4 ==2){
				outprint(2);
			}else if((N-1) % 4 ==0) {
				outprint(3);
			}else {
				System.out.println(N);
			}
		}
		System.out.println(sb);



	}
	static void outprint(int index) {
		
		for (int i = 0; i <R; i++) {
			for (int j = 0; j <C; j++) {
				sb.append(map[index][i][j]);
			}
			sb.append("\n");
		}
		
		
	}
	
	static void print() {
		for(int s=0;s<4;s++) {
			
			for (int i = 0; i <R; i++) {
				System.out.println(Arrays.toString(map[s][i]));
				
			}
			System.out.println();
			
			
		}
	}

}
