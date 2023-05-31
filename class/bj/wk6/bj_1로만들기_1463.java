package bj.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_1로만들기_1463 {

	
	static int m[];
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		if(N<3) {
			m = new int[4];
		}else {
			m = new int[N+1];
		}
		
		
		
		
		m[1]=0;
		m[2]=1;
		m[3]=1;
		
		//
		for(int i=4;i<N+1;i++) {
			int n = m[i-1]; 
			if(i%2==0) {
				n = (n < m[i/2]) ? n :  m[i/2]; 
			}if(i%3==0) {
				n =(n< m[i/3])?n:m[i/3]; 
			}
			
			
			m[i]=n+1;

		}
		System.out.println(m[N]);
		System.out.println(Arrays.toString(m));

}

}
