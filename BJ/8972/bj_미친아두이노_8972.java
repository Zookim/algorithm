package algo.wk10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_미친아두이노_8972 {
	static int R,C;
	static char [][] map;
	static char[] go;
	static List<int []> arduino = new ArrayList<>();
	
	static int myR,myC;
	
	static int [] dr = {0,1,1,1,0,0,0,-1,-1,-1};//0번과 5번은 dummy
	static int [] dc = {0,-1,0,1,-1,0,1,-1,0,1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char [R][C];
		for(int i=0;i<R;i++) {
			char [] a = br.readLine().toCharArray();
			for(int j=0;j<C;j++) {
				char n = a[j];
				map[i][j] = n;
				if(n == 'R') {arduino.add(new int[]{i,j,1});}
				else if(n == 'I') {myR = i;myC=j;}
			}
		}
		go = br.readLine().toCharArray();
		
		//입력 완료
		
		//종수의 이동
		int moveNum;
		for(moveNum=0;moveNum<go.length;moveNum++) {
			
			if(!Mymove((int)go[moveNum]-'0')) break;
			//아두이노가 이동한다
			
			if(!moveArduino())break;
			
			// 겹치는 놈들은 제거한다.
			for(int i=0;i<arduino.size();i++) {
				if(arduino.get(i)[2] == 0) continue;
				if(map[arduino.get(i)[0]][arduino.get(i)[1]] == 'X') {
					map[arduino.get(i)[0]][arduino.get(i)[1]] = '.';
					arduino.get(i)[2]=0;
				}
			}
			
		}
		if(moveNum == go.length) {
			printMap();
		}else {
			System.out.println("kraj "+ (moveNum+1));
		}
		
		
	}
	static boolean moveArduino() {
		
		for(int i=0;i<arduino.size();i++) {
			if(arduino.get(i)[2] == 0) continue;
			if(!moveTo(i)) return false;
		}
		return true;
		
	}
	static boolean moveTo(int n) {
		int r = arduino.get(n)[0];
		int c = arduino.get(n)[1];

		int r2=r,c2=c;
		int maxdis = Integer.MAX_VALUE;
		for(int i=0;i<dr.length;i++) {
			int row = r+dr[i];
			int col = c+dc[i];
			if(row >= R|| col >=C||col < 0||row<0) continue;
			int m = Math.abs(row-myR) +  Math.abs(col-myC);
			if(m<maxdis) {
				maxdis = m;
				r2 = row;
				c2 = col;
			}
		}

		// 폭발하는 경우
		// 종수와 만나는 경우
		if(map[r2][c2]=='R') {
			arduino.get(n)[2]=0; //죽음
			map[r2][c2]='X';
		}else if(map[r2][c2]=='X') {
			arduino.get(n)[2]=0; //죽음
		}else if(r2 == myR && c2 == myC){
			return false;
		}else {
			map[r2][c2]='R';
			arduino.get(n)[0] = r2;
			arduino.get(n)[1] = c2;
			
		}
		return true;
		
	}
	static boolean Mymove(int moveNum) {
		myR = myR + dr[moveNum];
		myC = myC + dc[moveNum];
		
		if(map[myR][myC]=='R') {
			return false;
		}
		
		for(int i=0;i<R;i++) {
			Arrays.fill(map[i],'.');
		}
		map[myR][myC]='I';
		return true;
	}
	static void printMap() {
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				sb.append(map[i][j]);
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}


}
