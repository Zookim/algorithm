package sw.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_창용마을무리의개수_7465 {

	static int N,M;
	static StringBuilder sb;
	static int arr[];
	//집합의 갯수
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		sb =  new StringBuilder(); 
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			//집합 생성
			arr = new int[N+1]; //dummy
			arr[0] = 0;
			for(int i=1;i<=N;i++) {
				makeSet(i);
			}
			
			
			//1은 확인
			for(int i = 0;i<M;i++) {
				st = new StringTokenizer(br.readLine());
				int a =  Integer.parseInt(st.nextToken());
				int b =  Integer.parseInt(st.nextToken());
				
				union(a,b);
				
				//System.out.println(Arrays.toString(arr));
				
			}
			int num=0;
			for(int i=1;i<=N;i++) {

				if(arr[i] ==i ) {
					num++;
				}
			}
			
			
			System.out.println("#"+test_case+" "+num);
		}
		
		
		
	}
	static void union(int a,int b) {
		int ap = findSet(a);
		int bp = findSet(b);
		
		arr[ap] =bp;
		
	}
	static void makeSet(int i) {
		arr[i] = i;
	}
	static int findSet(int i) {
		if(arr[i] ==i) {
			return i;
		}else {
			//return findSet(arr[i]); //시간초과
			return arr[i] = findSet(arr[i]); //Path Compression 
			// i의 조상들도 모두 부모로 최종 조상을 갖도록한다.
		}
	}
	

}
