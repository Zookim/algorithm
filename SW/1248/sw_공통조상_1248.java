package my.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//분할정복 이진 탐색 병합정렬

public class sw_공통조상_1248 {

	static int arr[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		for (int test = 0; test < T; test++) {
			//정점은 항상 1번이다.
			st = new StringTokenizer(br.readLine());
			
			
			int V = Integer.parseInt(st.nextToken()); //빈칸이 있는데
			int E = Integer.parseInt(st.nextToken());
			int c1 = Integer.parseInt(st.nextToken()); //자식1
			int c2 = Integer.parseInt(st.nextToken()); //자식2
			
			arr = new int[V+1]; //0번은 버린다.
			arr[1] =1; //root
			//다 넣은후 탐색, but 빈칸이 있을 수 있다.
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < args.length; i++) {
				int pnum = Integer.parseInt(st.nextToken());
				int cnum = Integer.parseInt(st.nextToken());
				
				if(arr[pnum*2] ==0) {arr[pnum*2] = cnum;}
				else {arr[pnum*2+1] = cnum;}
			}
			
			
			
			
		}

	}

}
