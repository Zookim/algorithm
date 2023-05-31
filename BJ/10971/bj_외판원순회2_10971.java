package algo.wk9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_외판원순회2_10971 {

	static int N;
	static int map[][];
	static int res = Integer.MAX_VALUE;
	static boolean[] select;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		select = new boolean[N];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for (int j = 0; j < N; j++) {
			select[j] = true;
			perm(1,0,j,j);
			select[j] = false;
		}
		System.out.println(res);
		

	}
	
	
	static void perm(int index,int value,int pre,int start) {
		if(index == N) {
			int a = map[pre][start];
			if(a==0) return;
			value += a;
			//System.out.println(map[pre][start]);
			res = (res>value)?value:res;
			//System.out.println(value);
			//System.out.println();
			return;
		}
		
		for(int i=0;i<N;i++) {
			
			if(select[i]) continue;
			int w = map[pre][i];
			if(w==0) continue;
			select[i] = true;
			//System.out.println(index+" "+w);
			perm(index+1,value+w,i,start);
	
			select[i] = false;
		}
	}

}
