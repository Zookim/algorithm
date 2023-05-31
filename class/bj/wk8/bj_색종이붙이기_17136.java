package bj.wk8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class bj_색종이붙이기_17136 {
	//색종이의 크기는 1×1, 2×2, 3×3, 4×4, 5×5로 총 다섯 종류가 있으며, 각 종류의 색종이는 5개씩
	//visit
	static int map[][];
	static int visit[][];
	static int min;
	static int paper[] = {0,5,5,5,5,5};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		map = new int[10][10];
		visit = new int[10][10];
		min = Integer.MAX_VALUE;
		
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//print(0);
		dfs(0,0,0);
		// 현재 위치에서 붙일 수 있는 색종이를 가장 큰것부터 고려해나간다, 수가 이전 보다 크거나 더이상 붙일 수 없는 경우가 생긴다면
		// 현재위치에 붙일 색종이를 더 작은 것으로 바꾸어준다. 
		// dfs 한턴이 값이 1인 위치
		// 재귀호출시 각 위치(index)를 기억하고 있으므로 복원이 가능해 map을 하나만 사용가능하다.

		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
		

	}
	static void dfs(int cnt, int r, int c) {
		
		
		//if(r == 9 && c==10) { 
		if(r == 9 && c > 9) { // 넘어간 직후
			min = cnt;
			return;
		}
		
		if(cnt >= min) { // 더이상 고려하지 않는다.
			//System.out.println(cnt);
			return;
		}

		if(c > 9) {
			r++; //다음줄로 이동한다.
			c=0;
		}
		
		if(map[r][c] == 1) { 

			// 5,4,3,2,1개중 가능한 것으로 덮는다.
			boolean flag = true;
			for(int k = 5 ; k >= 1; k--) {
				if(paper[k] == 0) continue;
				if(check(r,c,k)) { //찾았으면
					paper[k]--;
					dfs(cnt+1,r,c+1);
					uncheck(r,c,k);
					paper[k]++;
					flag = false;
				}
			}
			if(flag) {// 이번턴에선 구할 수 없다., 되돌아간다.
				return;
			}
		}else {// 1아니라면 옆칸으로 이동한다.
			dfs(cnt,r,c+1); 
		}


	
	}
	static boolean check(int r,int c,int size) {
		// size만큼의 정사각형이 있는지 확인하고 ,있으면 지운다.
		if((r+size-1) >= 10 || (c+size-1) >= 10) return false;
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				if(map[r+i][c+j] != 1) {
					return false;
				}
			}
		}
		
		
		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				map[r+i][c+j] = 0;
			}
		}
		return true;

	}
	
	static void uncheck(int r,int c,int size) {
		// size만큼의 정사각형이 있는지 확인하고 ,있으면 지운다.
	

		for(int i=0;i<size;i++) {
			for(int j=0;j<size;j++) {
				map[r+i][c+j] = 1;
			}
		}


	}
	
	
	
	
	static void print() {
		for(int a[] : map) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println();
	}

}
