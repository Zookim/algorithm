package algo.wk7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_야구_17281 {

	static int inning[][];
	static int arr[] = {0,1,2,3,4,5,6,7,8};
	static int player[] = new int[9];
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		N =Integer.parseInt(br.readLine());
		inning = new int[N][9];
		
		StringTokenizer st;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<9;j++) {
				inning[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		player[3] = 0;
		perm(1,0|(1<<3));//4번째는 선택하고 시작한다.
		//i를 선택 i는 0~9사이의 숫자 원하는 건,  
		System.out.println(max);
		
		
	}
	static int max = Integer.MIN_VALUE;
	static int res;
	static void perm(int index,int mask) {
		if(index==9) {//결국 9명선택하는 것은 똑같다.
			//System.out.println(Arrays.toString(player));
			res=0;
			
			game();
			
			max = Math.max(res,max);
		}
		
		for(int i=0;i<9;i++) {
			if((mask & (1<<i))!=0) continue;
			player[i] = arr[index];//0 번째 선수의 순서는 정해져있다.
			perm(index+1,mask | (1<<i));
		}
	}
	static void game() {//해당 선수 순서로 이닝 전체를 실행
		
		int p=0;
		
		for(int i=0;i<N;i++) {
			int out=0;
			int base =0;
			
			while(out <3) {
				//System.out.println("p "+p);
				int n = inning[i][player[p]];
				//System.out.println(n);
				if(n==0) {
					out++; //while 탈출
				}else {
					base = base << n;//각 수만큼 진루 시킨다.
					//득점확인
					res += ((base &(1<<6))  != 0) ? 1 : 0;// n==4라면 고려해야한다.
					res += ((base &(1<<5))  != 0) ? 1 : 0; // != 0으로 하면 답
					res += ((base &(1<<4))  != 0) ? 1 : 0;// ==1로하면 오답
					res += ((base &(1<<3))  != 0) ? 1 : 0;//????0이 아닌건 맞지만, 1은 아니다.자리수를 계산해 정수로나온다.
					
					
					//나간 부분 초기화 및 진루 주자추가
					base = base &(~(1<<6));
					base = base &(~(1<<5));
					base = base &(~(1<<4));
					base = base &(~(1<<3));
					
					if(n==4) {res++;}
					else {
						base = base | (1 << n-1);
					}
					
					
				}
				p++;
				if(p==9) {p=0;}
				
			}
			
			
		}
	}

}
