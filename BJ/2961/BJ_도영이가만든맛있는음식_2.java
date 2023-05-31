package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_도영이가만든맛있는음식 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int in [][] = new int [T][2];
		
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			in[i][0] = Integer.parseInt(st.nextToken());
			in[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		// 부분합을 구하며 최소차를 구한다.
		int min = Integer.MAX_VALUE;
		for(int i=1;i<(1<<T);i++) { // 0인경우는 제외
			int ssum =1;
			int bsum=0;
			for(int j=0;j < T;j++ ) { //이제 각자리수를 확인한다.
				if((i & (1<<j)) != 0) { // 해당 자리수가 1라면 선택한다.
					ssum *= in[j][0]; 
					bsum += in[j][1]; 
				}
		
			}
			min = Math.min(min, Math.abs(ssum-bsum));
			
			
			
		}
		System.out.println(min);
		
		

	}

}
