package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_1로만들기_1463c {

	
	static int m[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		m = new int[N+1];
		m[1]=0;
		
		for (int i = 2; i <= N; i++) {
			//1빼기
			m[i] = m[i-1] +1;
			//2로 나누기
			if(i % 2==0) m[i]=Math.min(m[i], m[i/2]+1);
			//3으로 나누기
			if(i % 3==0) m[i]=Math.min(m[i], m[i/3]+1);
		}
	
		System.out.println(m[N]);
		System.out.println(Arrays.toString(m));

}

}
