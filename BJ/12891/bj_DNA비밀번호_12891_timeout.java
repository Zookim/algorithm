package algo.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_DNA비밀번호_12891_timeout {
	// A C G T
	//시간초과
	static String [] str;
	

	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(b.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		str = b.readLine().split("");
		
		st = new StringTokenizer(b.readLine());
		int a = Integer.parseInt(st.nextToken());
		int c= Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		//System.out.println(Arrays.toString(str));
		int ans =0;
		for(int i=0;i<=(N-M);i++) {
			ans += check(i,a,c,g,t,M);
		}
		System.out.println(ans);


	}
	static int check(int start,int a,int c,int g,int t,int M) {
		int res=0;
		for(int i=start ;i < start + M;i++) {
			if(str[i].equals("A")) a--;
			else if(str[i].equals("C")) c--;
			else if(str[i].equals("G")) g--;
			else if(str[i].equals("T")) t--;
		}
		
		if(a==0 && c==0 && g==0 && t==0 ) {
			res=1;
		}
		//System.out.println(res);
		return res;
	}

}
