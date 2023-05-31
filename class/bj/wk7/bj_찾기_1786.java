package bj.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class bj_찾기_1786 {
	// 
	
	static String  T;
	static String  P;
	static int pi[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = br.readLine();
		P = br.readLine();
		
//		System.out.println(Arrays.toString(T));
//		System.out.println(Arrays.toString(P));
		pi = getPi(P);
		System.out.println(Arrays.toString(pi));
		//T와 P의 값을 비교한다. 
		char[] t = T.toCharArray();
		char[] p = P.toCharArray();
		
		int j=0;
		int cnt=0;

		for (int i = 0; i < t.length; i++) {

			while(j>0 && t[i] != p[j]) {j = pi[j-1];} // 일치하지 않았을때는 현재위치이전의 값부터 확인해야하므로 j-1로 돌아간다.\\\
			if(t[i] == p[j]) { //일치한자면 그갯수와, 시작하는 위치를 반환한다.
				if(j == p.length-1) {
					cnt++;
					sb.append(i-j+1).append("\n"); //시작하는 
					j = pi[j];
				}else {// 일치하지만 아직 전부완성은 아닌 상태
					j++;
				}

			}
		}
		System.out.println(cnt);
		System.out.println(sb);


		
		
		
	}
	static int[] getPi(String pattern) {
		int [] pi = new int[pattern.length()];
		char[] Array = pattern.toCharArray();
		
		// 
		int j=0;
		for(int i=1;i<pattern.length();i++) {// pattern을 돈다.
			
			while(j > 0 && Array[i] != Array[j]) {j = pi[j-1];}// 일치하는 것이 없다면 이전값으로 돌아간다.
			if(Array[i] == Array[j]) {pi[i] = ++j;} //일치하는 값이 있다면 pi에 j를 넣어준다.
			//여기서 j값의 의미는 j번째의 문자와 i번째의 문자가 일치하므로, 이후엔 j+1의 값부터 확인하도롣 한다이다.
			
		}
		
		
		return pi;
	}

}
