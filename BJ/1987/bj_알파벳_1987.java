package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_알파벳_1987 {
	
	static int [] dr = {-1,1,0,0};
	static int [] dc = {0,0,-1,1};
	static int count=1;
	static int R;
	static int C;
	static boolean alphabet[] =new boolean[26];
	static String map [][];
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new String[R][C];
		for(int i=0;i<R;i++) {
			map[i] = br.readLine().split("");
		}

		alphabet[map[0][0].charAt(0)-'A'] = true;
		dfs(0,0);
		System.out.println(max);
	}
	
	static void dfs(int r,int c){ 
		//상하좌우 기저 조건 모든 곳이 방문 불가
		//System.out.println(Arrays.toString(alphabet));
		max = max >count ?max:count;
		for(int i=0;i<4;i++) {
			int row =r+dr[i];
			int col = c+dc[i];
			if(row >=0 && row <R && col >=0 && col <C) {
				char now = map[row][col].charAt(0);
				if(alphabet[now-'A'])continue;
				else {
					alphabet[now-'A'] = true;
					count++;
					dfs(row,col);
					alphabet[now-'A'] = false;
					count--;
					
				}
			}
	
		}
	}

}
