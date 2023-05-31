package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_햄버거다이어트_5215_3 {

	//칼로리이하의 조합, 선호하는 조합
	//2가지 이상의 풀이
	static int arr[][];
	static int N,L;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			max=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //재료의수
			L = Integer.parseInt(st.nextToken()); //칼로리
			arr = new int[N][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); //맛
				arr[i][1] = Integer.parseInt(st.nextToken()); //칼로리
			}
			//부분 집합 
			subSet(0,0,0);
			System.out.println("#"+test+" "+max);

		}
	} //재귀, for
	static void subSet(int index,int calsum,int tsum) { 
		if(index == N) {
			System.out.println(tsum);
			max = (max > tsum) ? max:tsum;
			return;
		}
		
		if(calsum > L) {return;}
		
		subSet(index+1,calsum,tsum); //선택하지 않는경우
		
		calsum += arr[index][1];
		tsum += arr[index][0];
		subSet(index+1,calsum,tsum);//선택
		calsum -= arr[index][1];
		tsum -= arr[index][0];

	}
//	static void cal(int mask) {
//		int tsum=0;
//		int calsum=0;
//		for(int i=0;i<N;i++) {
//			if((mask &(1<<i)) !=0) {
//				calsum += arr[i][1];
//				tsum += arr[i][0];
//			}
//		}
//		
//		//System.out.println(tsum);
//		if(calsum <= L) {
//			System.out.println("맛 " +tsum+"칼로리 "+calsum);
//			max = (max > tsum) ? max:tsum;
//		}
//		
//	}
	
}


