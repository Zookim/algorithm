package algo.wk11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_색종이붙이기_17136 {
//모두 덮는데 필요한 최소 색종이 수 
	//각 색종이는 5개씩
	// 매번 100개의 칸을 돌면서 확인한다.
	static int map[][] = new int [10][10];
	static int paper[] = {0,5,5,5,5,5};
	static int mins = 25;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int i=0;i<10;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//printmap();
		// 1. 맵 전체를 돌며 1의 값이 있는지 확인한다.
		// 2. 1을 찾으면 정사각형을 차례대로 비교한다. -> 하나 찾았다 -> 종이를 붙인다.-> 다음 열으로 이동 ->1을 찾는다....-> 종이를 뗀다. 다음 크기랑 비교한다.
		// 3. 정사각형의 수를 뺀다.
		// 4.
		dfs(0,0,0);
		
		if (mins == 25) { //끝까지 가지 못한경우
			System.out.println(-1);
		}else {
			System.out.println(mins);
		}
		

	}
	static void dfs(int r, int c,int num) {
		//System.out.println("r "+r+" c "+ c+" mins "+mins);
		//printmap();
		if(num > mins) {
			return;
		}
		//1을 찾는다.
		while(true) {
			
			if(c>=10) {r++;c=0;}
			if(r==10) {// 종료한다.
				mins = num;
				return;
				}
			else {
				if(map[r][c] == 1) break;
			}
			c++;
		}
		
		
		for(int i=5;i>0;i--) {
			if(paper[i] == 0) continue;
			
			if(r+i>10 || c+i>10) continue;
		
			if(check(r,c,i)) { //붙일수 있다.
				paper[i]--;
				attach(r,c,i);
				dfs(r,c+i,num+1);
				paper[i]++;
				detach(r,c,i);
				
			}
		}
		
		return;// 지금까지의 선택으로 붙이지 못하는 경우
		
	}
	static void attach(int r, int c, int paper) {
		for(int i=r;i<(r+paper);i++) {
			for(int j=c;j<(c+paper);j++) {
				map[i][j] = 0;
			}
		}
	}
	
	static void detach(int r, int c, int paper) {
		for(int i=r;i<(r+paper);i++) {
			for(int j=c;j<(c+paper);j++) {
				map[i][j] = 1;
			}
		}
	}
	
	static boolean check(int r, int c, int paper) {
		
		for(int i=r;i<(r+paper);i++) {
			for(int j=c;j<(c+paper);j++) {
				if(map[i][j] == 0) return false;
			}
		}
		return true;
	}
	
	static void printmap() {
		System.out.println(Arrays.toString(paper));

		for(int i[] : map) {
			System.out.println(Arrays.toString(i));
		}
		System.out.println();
	}

}
