package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_º≥≈¡πË¥ﬁ_2839 {

	public static void main(String[] args) throws Exception{
		//3,5 ...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		int count=0;
		int N = Integer.parseInt(br.readLine());

		//5
		while(true) {
			
			if(N % 5 == 0) {
				ans+=N/5;
				break;
				}
			else {
				N-=3;
				count++;
				ans++;
				}
			
			if(count == 5 | (N < 3 & N>0)) {
				ans=-1;
				break;
				
			}
		}
		System.out.println(ans);

	}

}
