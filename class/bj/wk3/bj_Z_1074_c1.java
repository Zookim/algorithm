package bj.wk3;

import java.util.Scanner;

public class bj_Z_1074_c1 {
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
		zzz(0,0);
		System.out.println(ans);
		

	}
	static void zzz(int y,int x) {
		if(N == 1) { //기저조건
			return;
		}
		N /= 2;
		
		//rc가 어느 영역에 속하느냐에 따라 계산
		if(R < y+N && C < x+N) { //왼쪽 위
			zzz(y,x); 
			
		}else if(R < y+N && C >= x+N) { //오른쪽 위
			ans += N*N;
			zzz(y,x+N); 
			
		}else if(R >= y+N && C < x+N) { //왼쪽 아래
			ans += N*N*2;
			zzz(y+N,x); 
			
		}else if(R >= y+N && C >= x+N) { //왼쪽 위
			ans += N*N*3;
			zzz(y+N,x+N); 
		}
	
		
		
	
	}

}
