package bj.wk3;

import java.util.Scanner;

public class bj_Z_1074_c2 {
	//4등분 한것을 재귀적으로 푼다
	// 아
	static int R;
	static int C,N;
	static int ans;
	

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		
		N = 1<<(N);

		//탐색의 시작점
		int y=0; int x=0;
		while(true) {
			
			if(N == 1) break;
			
			
			N /= 2;
			//rc가 어느 영역에 속하느냐에 따라 계산
			if(R < y+N && C < x+N) { //왼쪽 위
				; 
				
			}else if(R < y+N && C >= x+N) { //오른쪽 위
				ans += N*N;
				x += N; 
				
			}else if(R >= y+N && C < x+N) { //왼쪽 아래
				ans += N*N*2;
				y += N; 
				
			}else if(R >= y+N && C >= x+N) { //왼쪽 위
				ans += N*N*3;
				y += N;
				x += N; 

			}
			//N이 1일때 각 자리수
		}
		

		System.out.println(ans);
		

	}
	

}
