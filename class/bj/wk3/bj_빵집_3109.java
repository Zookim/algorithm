package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_빵집_3109 {
	//마지막에 도달했을때, 카운트한다.

	//오른쪽으로만 이동,대각,옆
	static String map [][];
	static int C,R,count;
	static boolean complete;
	public static void main(String[] args) throws Exception {
		StringTokenizer st;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		R =Integer.parseInt(st.nextToken());
		C =Integer.parseInt(st.nextToken());
		
		
		map = new String [R][C];
		
		
		for (int i = 0; i < R; i++) {
			map[i] = br.readLine().split("");
		}
		
		for(int i=0;i<R;i++) {
			complete = false;
			find(i,0);
			for(String [] a : map) {
				System.out.println(Arrays.toString(a));
			}
			System.out.println();
		}
		System.out.println(count);
		//find(0);
		


	}
	static void find(int row,int col) { //해당 출발점에서 끝에 도달 할 수 있는지 확인
		if((col+1) == C) { //모든 출발점을 확인했다.
			complete = true;
			count++;
			return;
		}

		
		for(int i=-1;i<2;i++) {
			if((row+i) >= 0 && (row+i) < R && map[row+i][col+1].equals(".")) {
				map[row][col] = "O"; 
				find(row+i,col+1); //만약 갈수 있다면 가본다.
				
				if(complete) {
					return;	
				}
				
			}
			
			
			
		}
		//시간초과 : 만약 지금 내가 못간다면 다른 애들도 여기를 통과하지 못한다.
		//map[row][col] = "."; //쓸데 없이


		
		
	}
	
	

}
