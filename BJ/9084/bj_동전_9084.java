package algo.wk7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_동전_9084 {

	static int R;
	static int C;
	static int map[][];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		st = new StringTokenizer(br.readLine());
		
		R =Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new int[R+1][C+1];
		for(int i=1;i<R+1;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<C+1;j++) {
				map[i][j] = map[i-1][j] + map[i][j-1] + Integer.parseInt(st.nextToken()) - map[i-1][j-1];
				
			}
		}
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		int startr,startc,endr,endc;
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			startr=Integer.parseInt(st.nextToken());
			startc=Integer.parseInt(st.nextToken());
			endr=Integer.parseInt(st.nextToken());
			endc=Integer.parseInt(st.nextToken());
			sb.append(map[endr][endc]-map[startr-1][endc]-map[endr][startc-1]+map[startr-1][startc-1]).append("\n");
			
		}
		System.out.println(sb);

	}

}
