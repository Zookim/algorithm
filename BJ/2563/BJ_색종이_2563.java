package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_색종이_2563 {

	static boolean arr [][] = new boolean [100][100];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sb;
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0;i<N;i++) {
			sb = new StringTokenizer(br.readLine());
			int left = Integer.parseInt(sb.nextToken());
			int under = Integer.parseInt(sb.nextToken());
			save(left,under);
		}
		int count =0;
		for(int i=0;i<100;i++) {
			for(int j=0;j<100;j++) {
				if( arr[i][j]) count++;
			}
		}
		System.out.println(count);

	}
	static void save(int left, int under) {
		
		for(int i = (left-1);i<((left-1)+10);i++) {
			for(int j=(under-1);j<((under-1)+10);j++) {
				if(! arr[i][j]) {arr[i][j]=true;}
			}
		}
		
	}

}
