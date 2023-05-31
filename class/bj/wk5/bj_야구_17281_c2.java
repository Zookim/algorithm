package bj.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_야구_17281_c2 {

	static int N, ans;
	static int[][] inning;
	static int[] src = { 0, 1, 2, 3, 4, 5, 6, 7, 8 }; // 1 ~ 9 타자의 index
	static int[] tgt = new int[9];
	static boolean[] select = new boolean[9];


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());// inning 수

		inning = new int[N][9];
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 순열 + mask
		// tgt[3] 4번타자를 고정
		tgt[3] = 0; // 4번타자는 0번 index  로 고정

		perm(1, 1 << 3 ); // 9! -> 8! // 앞의 1은 이미 사용한 src 의 index를 의미
//mask | 1<<3 즉 4번째자리는 선택하고 시작한다.
		System.out.println(ans);
	}

	// 순열을 완선하는 과정에서 재귀호출이 src index 를 늘려가면서 처리
	// for 문에서는 tgt index 를 사요
	static void perm(int srcIdx, int mask ) {
		// 기저조건
		if( srcIdx == 9 ) {
			// complete code
			// 타순 하나가 완성
			game();
			return;
		}

		// i 가 tgt 인덱스
		for (int i = 0; i < 9; i++) {
			if ( (mask & 1 << i) != 0 ) continue;

			tgt[i] = src[srcIdx];
			perm( srcIdx + 1, mask | 1 << i ); // i 번째 선택 masking 추가
		}
	}

	static void game() {
		int score = 0; // 점수
		int player = 0; // 게임 시작 선수 index

		// inning 수 만큼 진행
		for (int i = 0; i < N; i++) {

			int base = 0; // bit mask  101 ( 3루, 1루 )
			int out = 0; // 아웃 카운트

			// 타순별로 진행
			for (int j = player; j < 9; j++) {
				int num = inning[i][ tgt[j] ];

				if( num == 0 ) { // 아웃
					out++;
					if( out == 3 ) { // 이닝 종료
						player = j + 1; // 마지막 타자 다음 index 로 
						if( player == 9 ) player = 0; // 9 다음 1 탄자로
						break;
					}
				}else { // 1, 2, 3, 4
					base = base << num;  //이전 주자 이동   0 0 0 0 0 1 1 1 => 2 루타 => 0 0 0 1 1 1 0 0
					base = base | 1 << num - 1; // 0 0 0 1 1 1 0 0 => 0 0 0 1 1 1 1 0
					score += score(base);

					// 점수 bit 자리를 초기화
					base = base & ( ~(1 << 3)); // 0 0 0 0 1 0 0 0 => 1 1 1 1 0 1 1 1
					base = base & ( ~(1 << 4));
					base = base & ( ~(1 << 5));
					base = base & ( ~(1 << 6));
				}

				// 마지막 타자까지 와서 out < 3 
				if( j == 8 ) j = -1;
			}

		}

		ans = Math.max(ans, score);
	}

	static int score(int base) {
		int sum = 0;
		sum += ( base & 1 << 3 ) != 0 ? 1 : 0;
		sum += ( base & 1 << 4 ) != 0 ? 1 : 0;
		sum += ( base & 1 << 5 ) != 0 ? 1 : 0;
		sum += ( base & 1 << 6 ) != 0 ? 1 : 0;
		return sum;
	}
}