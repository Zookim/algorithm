package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_요세푸스문제_1159_z {

	static boolean [] arr;
	static int [] ans;
	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(b.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N];
		ans = new int [N];
		
		int index=0;
		int count=K-1;
		int tcount=0;

		while(tcount < N) {

			if(count == 0 && arr[index] == false) {
				ans[tcount] = index+1;
				arr[index] = true;
				count = K-1;
				tcount++;
				continue;
			}
			if(arr[index] == false) {count--;}
			index++;
			if(index == N) {index=0;}

		}
		sb.append("<");
		for(int i=0;i< N-1;i++) {
			sb.append(ans[i]).append(", ");
		}
		sb.append(ans[N-1]).append(">");
		System.out.println(sb);

	}
}
