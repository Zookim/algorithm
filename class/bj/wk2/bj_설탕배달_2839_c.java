package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_설탕배달_2839_c {

	public static void main(String[] args) throws Exception{
		//3,5 ...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		int count=0;
		int N = Integer.parseInt(br.readLine());

		//5
		while(true) {
			if(N<0) {
				ans=-1;
				break;
				
			}
			if(N % 5 == 0) {
				ans+=N/5;
				break;
				}
			else {
				N-=3;
				count++;
				ans++;
				}
			
			
		}
		System.out.println(ans);

	}

}
