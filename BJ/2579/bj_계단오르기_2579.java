package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_계단오르기_2579 {

	//처음 값이 작아지는 동안 왼쪽 자손으로 입력한다.
	//값이 커지고, 루트보다 커질때까지 오른 자손으로 입력한다.
	//다시작아지면 왼자손, 커지면 오른자손
	static int arr[];
	static boolean visit[];
	static int sum =0;
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		visit = new boolean[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		sum = arr[N-1];
		visit[N-1] = true;
		
		
		
	
			
	}

}
