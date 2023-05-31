package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;
//일렬로 되는 경우가 있는지 없는지, 5명

public class bj_감시_15683 {
	//가능한 넓은 방향으로
	static int N,M;
	static int num=0;
	
	
	static int arr[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//같으면 수를 같은수로...
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken()); 
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				arr[i][j] =Integer.parseInt(st.nextToken()); 
			}
		}
		
		
		
		
		
	}
	
	
	
}
