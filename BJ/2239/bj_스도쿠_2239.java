package algo.wk9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class bj_스도쿠_2239 {
// 81자리수가 최소인것
	//가로,세로,자신의 범위에서 중복조건을 만족하는지 확인한다.
	static int map [][] = new int[9][9];
	static int center[][] = {{1,1},{1,4},{1,7},{4,1},{4,4},{4,7},{7,1},{7,4},{7,7}}; 
	static int[] dr = {0,-1,-1,-1,0,0,0,1,1,1};
	static int[] dc = {0,-1,0,1,-1,0,1,-1,0,1};
	static List<int[]> zero = new ArrayList<>();
	static int zeroCount=0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i=0;i<9;i++) {
		String str[] = br.readLine().split("");
			for(int j=0;j<9;j++) {
				int n = Integer.parseInt(str[j]);
				map[i][j] = n;
				if(n==0) {
					zero.add(new int[] {i,j});
					zeroCount++;
				}
			}
		}
		//입력
		//System.out.println(zeroCount);
		//
		StringBuilder sb = new StringBuilder();
		int c = dfs(0);
		//System.out.println("c "+c);
		for(int a[]: map) {
			for(int b : a) {
				sb.append(b);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);

	}
	static int dfs(int index) {
		
		//기저조건
		if(index == zeroCount) {
			
			return 1;
		}
		
		int r = zero.get(index)[0];
		int c = zero.get(index)[1];
		
		int centerR=0, centerC=0;
		boolean select[] = new boolean[10];
		//가로,세로 확인
		for (int i = 0; i < 9; i++) {
			select[map[r][i]] = true;
			select[map[i][c]] = true;
			if(Math.max( Math.abs(r-center[i][0]),Math.abs(c-center[i][1]) )<=1) {
				centerR = center[i][0];
				centerC = center[i][1];
			}
		}
		
		for (int i = 0; i <9; i++) {//중심값을 찾고, 그값의 주변을 탐색한다.
			select[ map[ centerR+dr[i] ][ centerC+dc[i] ] ]=true;
		}
		//System.out.println(index + " " + Arrays.toString(select));
		for (int i = 1; i <= 9; i++) {
			if(select[i]) continue;
			map[r][c] = i;// 첫값으로 선택한다.
			 int n = dfs(index+1);
			 if(n==1) {return 1;}
			 map[r][c] = 0;//꼭 되돌려 주어야한다.
		}
		
		return 0;
		
		
	}

}
