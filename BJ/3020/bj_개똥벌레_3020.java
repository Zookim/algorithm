package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_개똥벌레_3020 {

	static int up[],down[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		up = new int[H+2];
		down = new int[H+2]; //편의를 위해 맨위에도 공백
		for(int i=1;i<=N;i++) {
			int a = Integer.parseInt(br.readLine());
			
			if(i%2 == 1) { //홀수 일때 바닥부터
				down[a]++;
			}else { //짝수 일때, 천장부터
				up[H+1-a]++;
			}
		}
		
		for(int i=1;i<=H;i++) { //누적합으로
			up[i] = up[i-1]+up[i];
			down[H-i+1] = down[H-i+2]+down[H-i+1];
		}
	
		int count=0;
		int min = N;
		for(int i=1;i<=H;i++) {
			int n = up[i] + down[i];
			if(n < min) {
				count =1;
				min=n;
				
			}else if(min == n) {count++;}
		}
		System.out.println(min + " "+count);

	}
}
