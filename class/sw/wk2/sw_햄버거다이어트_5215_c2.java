package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_햄버거다이어트_5215_c2 {

	//칼로리이하의 조합, 선호하는 조합
	//2가지 이상의 풀이
	static int arr[][];
	static int N,L,T;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			max=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //재료의수
			L = Integer.parseInt(st.nextToken()); //칼로리
			
			arr = new int [N][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] =Integer.parseInt(st.nextToken()); //맛
				arr[i][1] = Integer.parseInt(st.nextToken());
				
			}
			//부분 집합 
			subSet(0,0,0);
			System.out.println("#"+test+" "+max);

		}
	} //재귀, for
	static void subSet(int index,int point,int cal) {
		if(cal > L) {return;}
		if(index == N) {

			max = Math.max(max,point);
			return;
		}
		subSet(index+1,point+arr[index][0],cal+arr[index][1]);
		subSet(index+1,point,cal);
		
		
	}
	
}


