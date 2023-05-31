package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_스네이크버드_16435 {
	//최대 길이 
	//1. 정렬되면, 같거나,작은것을
	
	static int [] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		int count=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		count = M;
		for(int i=0;i<N;i++) {
			if (count>=arr[i]) {
				count++;
			}else break;
		}
		
		System.out.println(count);
	

	}


}
