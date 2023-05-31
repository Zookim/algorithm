package algo.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_DNA비밀번호_12891 {
	// A C G T
	static String [] str;
	static int [][] strcount;
	

	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(b.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		// 각 위치의 누적값을 저장해 놓는다.
		str = b.readLine().split("");
		strcount = new int[N+1][4]; //첫자리는 그냥 버린다.
		for (int i = 1; i <= N; i++) {
			
			strcount[i][0] = strcount[i-1][0];
			strcount[i][1] = strcount[i-1][1];
			strcount[i][2] = strcount[i-1][2];
			strcount[i][3] = strcount[i-1][3];
			
			if(str[i-1].equals("A")) strcount[i][0] += 1;
			else if(str[i-1].equals("C")) strcount[i][1] += 1;
			else if(str[i-1].equals("G")) strcount[i][2] += 1;
			else if(str[i-1].equals("T")) strcount[i][3] += 1;
			
			//System.out.println(Arrays.toString(strcount[i]));
		}
	
		
		st = new StringTokenizer(b.readLine());
		int a = Integer.parseInt(st.nextToken());
		int c= Integer.parseInt(st.nextToken());
		int g = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());
		
		//System.out.println(Arrays.toString(str));
		int ans =0;
		for(int i=1;i<=(N-M+1);i++) {
			
			ans += check(i,a,c,g,t,M);
		}
		System.out.println(ans);


	}
	static int check(int start,int a,int c,int g,int t,int M) {
		int res=0;
		
		int aa=(strcount[start+M-1][0]-strcount[start-1][0]);//) >= a);
		int cc=(strcount[start+M-1][1]-strcount[start-1][1]);
		int gg=(strcount[start+M-1][2]-strcount[start-1][2]);
		int tt=(strcount[start+M-1][3]-strcount[start-1][3]);

		//System.out.println("aa "+aa+" cc "+cc+" gg "+g+" tt "+t);
		if(aa >= a && cc>=c && gg>=g && tt>=t ) {
			res=1;
		}
		//System.out.println(res);
		return res;
	}

}
