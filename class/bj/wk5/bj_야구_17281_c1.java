package bj.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//시간초과
public class bj_야구_17281_c1 {
	// 가장많은 득점을 하는 타순시 그 득점 구하기
	//1번 선수는 4번타자
	//각 이닝에서 아웃은 최소한명
	// 모든 경우의 수에서 득점을 구한다.
	// 타순은 매번 동일한다.
	
	static int N,ans;
	static int inning[][];
	static int src[] = {0,1,2,3,4,5,6,7,8};
	static int tgt[] = new int[9];
	static boolean[]select = new boolean[9];
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		inning = new int [N][9];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		
		
		perm(0,0);
		System.out.println(ans);
		
		

	}
	static void perm(int tgtIdx,int mask) {
		if(tgtIdx ==9) {
			game();
			return;
		}
		
		for (int i = 1; i < 9; i++) {
			if((mask & (1<<i)) !=0) continue;
			
			if(tgtIdx == 3) {//4번째자리에 오면
				tgt[3] =0;
				perm(tgtIdx+1,mask);
			}else {
				tgt[tgtIdx] =src[i];
				perm(tgtIdx+1,mask | 1<< i);//i번째를 선택했다.4번째를 선택하는 경우가 계산되고있다
				//처음부터 해당위치를 선택해두지 않았기때문에
			}
		}
		
	}
	static void game() {
		int score=0;
		int player=0; //게임 시작 선수
		
		//inning수 만큼진행
		for(int i=0;i<N;i++) {
			int base =0;//bit mask 101 (1루와 2루가 있는경우)
			int out=0;
			
			//타순별로 진행
			for (int j = player; j < 9; j++) 
			{
				int num = inning[i][tgt[j]];
				if(num ==0) 
				{
					if(++out ==3) //이닝 종료
					{
						player =j+1;
						if(player ==9) player=0;
						break;
					}
				}else {//아웃이 아닌경우 
					base = base <<num;//우선 기존 선수들을 진루시킨다.
					base = base |1<<(num-1);//
					
					//점수가져오기
					score += score(base);
					
					//점수 비트를 초기화
					base = base & (~(1<<3));
					base = base & (~(1<<4));
					base = base & (~(1<<5));
					base = base & (~(1<<6));
				}
				
				if(j ==8) j=-1;
			}
		}
		ans = Math.max(ans,score);
	}
	static int score(int base) {
		int sum = 0;
		
		sum +=(base & 1<<3) !=0 ?1:0;
		sum +=(base & 1<<4) !=0 ?1:0;
		sum +=(base & 1<<5) !=0 ?1:0;
		sum +=(base & 1<<6) !=0 ?1:0;
		return sum;
	}

}
