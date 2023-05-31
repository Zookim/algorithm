package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_DNA_12891_z {

	
	public static void main(String[] args) throws Exception {
		// 문자열에 사용되는 문자 종류가 일정수 이상
		int [] N = new int[2];
		int [] ACGT = new int [4];
		int count=0;
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(b.readLine());
		for(int i=0;i<2;i++) {
			N[i] = Integer.parseInt(st.nextToken());
		}
		
		String ans = b.readLine();
		
		st = new StringTokenizer(b.readLine());
		for(int i=0;i<2;i++) {
			ACGT[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0;i<=(ans.length()-N[1]);i++) {
			int sum=0;
			sum = getsum(int A,int C,int G,int T,i)
			
			if (sum == 0) {count++;}
			System.out.println(Arrays.toString(ACGT));
			
			
		}
		System.out.println(count);
		
		
		
	}
	static int getsum(int A,int C,int G,int T,int i) {
		
		
		for(int j = i;j<(i+N[1]); j++) {
			System.out.println(ans.charAt(j));
			switch(ans.charAt(j)) {
			case 'A':
				A--;
				break;
			case 'C':
				C--;
				break;
			case 'G':
				G--;
				break;
			case 'T':
				T--;
				break;
			}


		}
		return A+C+G+T;
	}

	
}
