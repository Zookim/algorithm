package bj.wk3;

import java.util.Scanner;

public class bj_Z_1074_z2 {
	//4등분 한것을 재귀적으로 푼다
	// 아
	static int R;
	static int C;
	static int num;
	static int sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		R = sc.nextInt();
		C = sc.nextInt();
		
		int size = 1<<(N);
		//System.out.println(size);
		zzz(0,0,size);
		System.out.println(sum);
		

	}
	static void zzz(int r,int c,int s) {
		
		if(s==2) { // 이 안에 있다.
			if(r <= R && R<=(r+s-1) && c <= C && C<=(c+s-1)) {
			
				if(r == R) {
					num += (c==C)? 0 :1;
				}else {
					num += (c==C)? 2 :3;
				}
				sum = num;
				return;
			}
			else {
				num+=4;
				return;
			}
		}
		
		if(r <= R && R<=(r+s-1) && c <= C && C<=(c+s-1)) {
			//범위내에 있므면 분할해서 생각
			//System.out.println(R+" "+C);
			int h=s/2;
			zzz(r,c,h);
			zzz(r,c+h,h);
			zzz(r+h,c,h);
			zzz(r+h,c+h,h);
		}else {
			//System.out.println("Asd");
			//범위내에 없으면, 그냥 현재 크기만 반환
			num += s*s;
			return;
		}
		
		
	
	}

}