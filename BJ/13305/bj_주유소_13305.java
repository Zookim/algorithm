package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_주유소_13305 {
	//키로당 1리터 사용
	//처음엔 꼭 충전필요
	//최대 십만개의 도시

	static int dis [];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		dis = new int [N-1];
		
		
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N-1;i++) { //거리정보
			dis[i] = Integer.parseInt(st.nextToken());
		}
		
		long price=0;
		long sum_dis =0;
		long cost=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) { //리터당 가격
			int city = Integer.parseInt(st.nextToken());
			
			if(i==0) {price = city;}
			else {
				sum_dis += dis[i-1];
				if(price > city || i==(N-1) ) {
					cost += sum_dis*price;
					price = city;
					sum_dis =0;
				}
			}
		}

		
			
		System.out.println(cost);
	}
}
