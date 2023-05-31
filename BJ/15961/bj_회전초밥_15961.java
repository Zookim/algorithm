package algo.wk9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_회전초밥_15961 {
	
//	원래 회전 초밥은 손님이 마음대로 초밥을  고르고, 먹은 초밥만큼 식대를 계산하지만
//	벨트의 임의의 한 위치부터 
	//k개의 접시를 연속해서 먹을 경우 할인된 정액 가격으로 제공한다. 
	
	// 초밥의 종류 하나가 쓰인 쿠폰 ->쿠폰에 적혀진 종류의 초밥 하나를 추가로 무료로 제공
	// 현재 벨트 위에 없을 경우, 요리사가 제공
	
	
	
	// 가짓수의 최대값
	static int N,d,k,c;
	static int map[];
	static int select[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		// 1 2 3 4,1 2 3 k-1개 가 더 필요하다.
		map =  new int[N+k]; // 1 dummy
		select =  new int[d+1];//dummy
		
		int num=0;
		int max=0;
		for (int i = 1; i <= N; i++) {
			int input = Integer.parseInt(br.readLine());
			map[i] = input;
			//k개가 될때까지 select에 체크한다.num에 가짓수를 저장한다.
			//k개 이후 부터 select를 참고해 num의 수를 구하고 이 수중에서 Max 값을 구한다. 단 c의 번호를 고려해 각 숫간의 최대값을 고려한다.
			
			if(i > k) { //앞부분을 빼준다.
				int n = map[i-k];
				select[n]--;
				if(select[n] == 0)num--;// 

			}// 현재값을 더한다.
			if(select[input]==0) num++;
			select[input]++;
			
			if(select[c]==0) {
				max = max < (num+1) ? (num+1) :max;
			}else {
				max = max < num ? num :max;
			}
			//System.out.println("i "+i+" "+max);
		}
		
		int index =1;
		//범위를 넘어갔을 경우 !!!!!!!!!!!여기부터
		for (int i = N+1; i <N+k; i++) {
			
			map[i] = map[index++];
			int input = map[i];

			//if(i > k) { //앞부분을 빼준다.
				int n = map[i-k];
				select[n]--;
				if(select[n] == 0)num--;// 

			//}// 현재값을 더한다.
			if(select[input]==0) num++;
			select[input]++;
			
			if(select[c]==0) {
				max = max < (num+1) ? (num+1) :max;
			}else {
				max = max < num ? num :max;
			}
			//System.out.println("i "+i+" "+max);
		}
		
		
		System.out.println(max);

	}

}
