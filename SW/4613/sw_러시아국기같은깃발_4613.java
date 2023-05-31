package algo.wk8;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_러시아국기같은깃발_4613 {
	static int N,M;
	static int[][] arr;

	static int res;
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			
			arr = new int[N+1][3]; //w, b, r, 
			
			for(int i=1;i<=N;i++) {
				String str[] = br.readLine().split("");
				int w=0,b=0,r=0;
				for(int j=0;j<M;j++) {
					if(str[j].equals("W")) w++;//얘네가 최대인경우를 구한다.
					else if(str[j].equals("B")) b++;
					else r++;
				}
				arr[i][0]=arr[i-1][0]+b+r;
				arr[i][1] = arr[i-1][1]+w+r;
				arr[i][2]=arr[i-1][2]+b+w;
				//누적합으로 이후 b의 위치만을 구해도 되도록한다.
			}
			
//			for(int i=0;i<=N;i++){
//				System.out.println(arr[i][0] + " "+arr[i][1] + " "+arr[i][2] + " ");
//					}
//			
			res = Integer.MAX_VALUE;
			function();
			//res = M*N-res;
			//System.out.println("#"+test+" "+res);
			sb.append("#").append(test).append(" ").append(res).append("\n");
		}
		//int res = arr[1][0] + arr[N][2]-arr[N-1][2]; //양끝은 결정
		
		//b의 시작위치와 갯수를 반복해서 구하는 함수
		System.out.println(sb);
		
		

	}
	
	static void function() {
		int len = N-1;
		for(int i=2;i<=len;i++) {//양끝을 제외한 b를 시작할 위치를 정한다.
			
			//b의 갯수
			for(int j=0;j<=(len-i);j++) {
				int sum = arr[i-1][0]+ arr[i+j][1]-arr[i-1][1]+arr[N][2]-arr[i+j][2];
				//System.out.println(sum);
				res = (sum < res) ? sum : res;
			}
			
		}
		
	}

}
