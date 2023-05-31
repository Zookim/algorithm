package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_햄버거다이어트_5215_c {

	//칼로리이하의 조합, 선호하는 조합
	//2가지 이상의 풀이
	static Item arr[];
	static int N,L,T;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			max=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //재료의수
			L = Integer.parseInt(st.nextToken()); //칼로리
			
			arr = new Item[N];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i] = new Item(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())); //맛

			}
			//부분 집합 
			subSet(0,0);
			System.out.println("#"+test+" "+max);

		}
	} //재귀, for
	static void subSet(int index,int mask) { 
		if(index == N) {
			//System.out.println(mask);//mask를 다시
			int cal=0;
			int point =0;
			
			for(int i=0;i<N;i++) {
				if((mask &(1<<i)) ==0) continue; //선택되지 않은것 무시
				cal += arr[i].c;
				point += arr[i].p;
			}
			if(cal <=L)max = Math.max(max,point);
			return;
		}
		subSet(index+1,(mask | (1<<index)));
		subSet(index+1,mask);
	}
		
	
	static class Item{
		int p,c;

		public Item(int p, int c) {
			super();
			this.p = p;
			this.c = c;
		}
		
		
	}
	
}


