package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_주사위굴리기_14499 {
	//주사위의 상단에 있는 값들
//	  북3
//	서 2  동 1
//	  남 4
	
	
	//시작은모두 0으로 시작
	//주사위를 바깥으로 보내는 명령은 무시해야한다. 출력도하지 않는다.
	static int N,M,startr,startc,K;
	static int map[][];
	
	static int[] dice = new int[7];// dummy
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		startr = Integer.parseInt(st.nextToken()); //x ... 시작위치
		startc = Integer.parseInt(st.nextToken());//y
		K = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//초기값
		if(map[startr][startc] != 0) {
			dice[6] = map[startr][startc] ;
		}
			
		int nowr = startr;
		int nowc = startc;
		
		
		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) { // 각 명령을따르고 그결과를 바로 구한다.
			int command = Integer.parseInt(st.nextToken());
			// 지도 밖으로 넘어서는 지 검사한다.
			int [] next = check(nowr, nowc,command);
			
			if(next[0] == -1) continue;
			nowr = next[0];
			nowc = next[1];
			// 명령의 방향으로 주사위를 굴린다.
			int top = roll(nowr, nowc,command);
			sb.append(top).append("\n");
			
			
		}
		System.out.println(sb);
		

	}
	static int roll(int r, int c,int command ) { 
		//주사위를 굴리고 위 아래를 가리키는 포인터를 바꾸는 것 보다 주사위 전체 값을 바꾼다.
		//값의 복사여부를 확인
		// 위쪽은 항상 1번, 아래는 항상 6번
		//지도에 0이 있으면 주사위의 값이 지도에적힌다.
		// 지도가 0이아니면 주사윙 그값이 적힌다.
		int tmp;
		switch(command) {
		case 3://위
			tmp = dice[2];
			dice[2] = dice[1];
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = tmp;
			
			break;
		case 4://하
			tmp = dice[6];
			dice[6] = dice[5];
			dice[5] = dice[1];
			dice[1] = dice[2];
			dice[2] = tmp;

			break;
		case 2://좌
			tmp = dice[6];
			dice[6] = dice[4];
			dice[4] = dice[1];
			dice[1] = dice[3];
			dice[3] = tmp;
			break;
			
		case 1://우
			tmp = dice[6];
			dice[6] = dice[3];
			dice[3] = dice[1];
			dice[1] = dice[4];
			dice[4] = tmp;
			break;
			
		}
		
		if(map[r][c] == 0) {
			map[r][c] = dice[6];
		}else {
			dice[6] = map[r][c] ;
			map[r][c] =0;
		}
		return dice[1];
		
	}
	static int[] check(int r, int c,int command) { //명령에 따라  범위를 넘어서는지 확인한다.
	
		switch(command) {
		case 3://위
			r -= 1; 
			break;
		case 4://하
			r += 1; 
			break;
		case 2://좌
			c-=1;
			break;
		case 1://우
			c+= 1;
			break;
			
		}
		
		if(r < N && c < M && r >= 0 && c >= 0 ) { //범위 내에 있으면
			return new int[] {r,c};
		}
		
		
		return new int[] {-1,-1}; //-1이면 이후단계를 하지 않느다.
	} 

}
