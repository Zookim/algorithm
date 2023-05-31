package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_월드컵_6987 {
//  w d l /w d l /w d l /w d l /w d l /w d l
//	5 0 0 /3 0 2 /2 0 3 /0 0 5 /4 0 1 /1 0 4
//가능한 게임의 경우를 찾는다.

	static int arr[] = new int[18]; 
	static int[] win,lose,draw;
	static int res;
	
	static int[][] game;
	//서로 경기하는 경우의 수 
	// 0 0 0 0 0 1 1 1 1 2 2 2 3 3 4
	// 1 2 3 4 5 2 3 4 5 3 4 5 4 5 5
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		win = new int[6];
		lose = new int[6];
		draw = new int[6];
		
		game  = new int[15][2]; // 하드코딩가능
		
		int g =0;
		for (int i = 0; i < 5; i++) {
			for (int j = i+1; j <= 5; j++) { //6-j>0
				game[g][0] = i;
				game[g][1] = j;
				g++;
			}
		}
//		for() {
//			
//		}
//		System.out.println(Arrays.toString(game));
		for(int i=0;i<4;i++) {
			int sum =0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<6;j++) {
				sum += win[j] = Integer.parseInt(st.nextToken());
				sum += draw[j] = Integer.parseInt(st.nextToken());
				sum += lose[j] = Integer.parseInt(st.nextToken());
			}
			if(sum != 30) {
				System.out.print("0 ");
				continue;
			}
			
			//dfs
			//0번째 시합 부터 계속 다음 시합으로 재귀 호출하면서 결과 자료구조를 검증할 예정
			// 끝까지 가서 결과 자료구조가 유효하면 1출력
			if(dfs(0)) System.out.print("1 ");
			else System.out.print("0 ");
		}
		
		
	}
	 static boolean dfs(int index) {
		 if(index == 15) { //가능한 경우의 수에 도달, 검증됨
			 return true;
		 }
		 
		 
		int teamA = game[index][0]; 
		int teamB = game[index][1];
		
		//a팀이 승리,b 팀 패배
		if(win[teamA] > 0 && lose[teamB]>0 ) { //가지치기 코드
			win[teamA]--; 
			lose[teamB]--;
			if(dfs(index +1))return true;
			//dfs가 실패하면 다시 원래 값으로 돌려준다.
			win[teamA]++; 
			lose[teamB]++;
		}

		//b팀이 승리,a 팀 패배
		if(win[teamB] > 0 && lose[teamA]>0 ) { //가지치기 코드
			win[teamB]--; 
			lose[teamA]--;
			if(dfs(index +1))return true;
			//dfs가 실패하면 다시 원래 값으로 돌려준다.
			win[teamB]++; 
			lose[teamA]++;
		}
		//b무승부인 경우
		if(draw[teamB] > 0 && draw[teamA]>0 ) { //가지치기 코드
			draw[teamB]--; 
			draw[teamA]--;
			if(dfs(index +1))return true;
			//dfs가 실패하면 다시 원래 값으로 돌려준다.
			draw[teamB]++; 
			draw[teamA]++;
		}
		return false;
	 }
}
