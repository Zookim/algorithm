package sw.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_무산충전_5644_c {

	static int T, M, A, ans;
	static int[] pathA, pathB;
	static BC[] bcArray;
	
	static int ay, ax, by, bx;
	static int[] dy = {0, -1, 0, 1, 0};
	static int[] dx = {0,  0, 1, 0,-1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			A = Integer.parseInt(st.nextToken());
			
			// path
			pathA = new int[M];
			pathB = new int[M];
			
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				pathA[i] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < M; i++) {
				pathB[i] = Integer.parseInt(st.nextToken());
			}
			
			// BC
			bcArray = new BC[A];
			for (int i = 0; i < A; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int p = Integer.parseInt(st.nextToken());
				bcArray[i] = new BC(y, x, c, p);
			}
			
			// 시뮬레이션 시작
			ans = 0;
			
			// 시작 위치
			ay = 1;
			ax = 1;
			by = 10;
			bx = 10;
			
			// 시작할 때 충전 시도
			charge();
						
			// 이동할 때 마다 충전 시도
			// 이동하는 A, B 의 경로  pathA, pathB 에 방향으로 기록
			for (int i = 0; i < M; i++) {
				ay += dy[ pathA[i] ];
				ax += dx[ pathA[i] ];
				by += dy[ pathB[i] ];
				bx += dx[ pathB[i] ];
				charge();
			}
			
			System.out.println("#" + t + " " + ans);
		}

	}
	
	// 두 사람이 이동할 때 마다 충전을 시도해서 충전이 가능하면 ans 누적
	static void charge() {
		int max = 0;
		// 모든 BC 고려 for x for
		for (int i = 0; i < A; i++) {
			for (int j = 0; j < A; j++) {
				int sum = 0;
				int aPower = getPower(bcArray[i], ay, ax);
				int bPower = getPower(bcArray[j], by, bx);
				
				if( aPower == 0 && bPower == 0 ) continue;
				
				// 충전할 게 있다.
				if( i != j ) {
					sum = aPower + bPower;
				}else {
					sum = Math.max(aPower, bPower);
				}
				
				max = Math.max(max, sum);
			}
		}
		
		ans += max;
	}
	
	static int getPower(BC bc, int y, int x) {
		if( Math.abs(bc.y - y) + Math.abs(bc.x - x) <= bc.c ) return bc.p;
		return 0;
	}
	static class BC{
		int y, x, c, p;
		BC( int y, int x, int c, int p ){
			this.y = y;
			this.x = x;
			this.c = c;
			this.p = p;
		}
	}
}