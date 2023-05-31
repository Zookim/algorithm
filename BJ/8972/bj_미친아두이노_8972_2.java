package my.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_미친아두이노_8972 {
// 종수 -> 확인 -> 미친아두이노-> 확인(폭발, 종료)
	//최종상태 혹은 종료시간
	
	static int [] dr = {0,1,1,1,0,0,0,-1,-1,-1};//0번과 5번은 dummy
	static int [] dc = {0,-1,0,1,-1,0,1,-1,0,1};
	
	static int map[][];
	static int R,C;
	
	static List<int[]> clist = new ArrayList<>();
	static int myR,myC;
	static char[] move;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		clist.add(new int[] {-1,-1});
		for (int i = 0; i < R; i++) {
			
			char [] chars = br.readLine().toCharArray();
			for (int j = 0; j < C; j++) {
				if(chars[j] == 'I') map[i][j] = -1;
				else if(chars[j] == 'R') {
					clist.add(new int[] {i,j});
					map[i][j] = j+1;
					
				} 
			}
		}
		move = br.readLine().toCharArray();
		//입력 완료
		
		int res=0;
		// 종수 -> 확인 -> 미친아두이노-> 확인(폭발, 종료)
		for(int i=0;i < move.length;i++) {
			//종수의 이동 -> 겹치는지확인
			int nextr = myR + dr[move[i]-'0'];
			int nextc = myC + dc[move[i]-'0'];
			res++;
			print();
			if(map[nextr][nextc] != 0) {//확인 1.
				break;
			}else {// 빈칸 이었다면 이동한다.
				map[myR][myC] = 0;
				map[nextr][nextc] = -1;
				myC = nextc;
				myR = nextr;
			}
			
			for(int j=1;j<clist.size();j++) {// 아두이노가 이동한다.
				if(clist.get(j)[0] == -1) continue;// 이미 폭발
				if(!move(j)) {break;}
				
			}
			print();
			//이번 턴에서 폭발한 위치를 지운다.
			for(int j=1;j<clist.size();j++) {
				if(clist.get(j)[0] == -1) continue;// 이미 폭발
				map[clist.get(j)[0]][clist.get(j)[1]] = j;
				
			}
			
			//map[myR][myC] = -1;
			print();
			
		}
		StringBuilder sb = new StringBuilder();
		if(res ==  move.length) {
			for (int[] a : map) {
				for (int b : a) {
					if(b == -1) sb.append("I");
					else if(b == 0) sb.append(".");
					else sb.append("R");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			
		}else {
			System.out.println("kraj "+res);
		}
		
	}
	//static List<Integer> explode = new ArrayList<>();
	static boolean move(int index) { //맵도 옮기고, 가장 가까운곳으로 옮긴다.
		int r = clist.get(index)[0];
		int c = clist.get(index)[1];
		int mins = Integer.MAX_VALUE;
		int Rres =0;
		int Cres =0;
		for (int i = 0; i < dc.length; i++) {
			int row = r+dr[i];
			int col = c+dc[i];
			int n =(Math.abs(row-myR) + Math.abs(col-myC));
			if(n < mins) {
				mins =n;
				Rres = row;
				Cres = col;
			}
		}
		
		clist.get(index)[0] = Rres;
		clist.get(index)[1] = Cres;
		
		if(map[Rres][Cres] == 0) {
			System.out.println(Rres+ " "+Cres );
			map[Rres][Cres] = index;
			map[r][c] = 0;
			return true;
		}
		else if(map[Rres][Cres] == -1) {
			return false;
			
		}else {// 아두이노들이 겹치는 경우
			map[r][c] = 0;
			int n =map[Rres][Cres];
			clist.get(index)[0] = -1;//이후로 무시한다.
			clist.get(n)[0] = -1;
			return true;
			
		}
		
		
	}
	static void print() {
		StringBuilder sb = new StringBuilder();
			for (int[] a : map) {
				for (int b : a) {
					if(b == -1) sb.append("I");
					else if(b == 0) sb.append(".");
					else sb.append("R");
				}
				sb.append("\n");
			}
			System.out.println(sb);
			
		}
	
}
