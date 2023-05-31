package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_고층빌딩_1328 {

	//R,L은 1이상이다.
	//N1이면 R==1,L==1
	///N이 2이상이면 R+L은 3이상
	static int N,L,R;
	static long count;
	static long X = 1_000_000_007;//1_000_000_007 
	static boolean select[];
	public static void main(String[] args) throws Exception{
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		select= new boolean[N+1];
		//System.out.println(X);
		comb(0,1,0,0);

	}//조합인데, 특정개수 이상이 되면 가지치기
	static void comb(int index,int start) {
		if(index == N) {
			count++;
			return;
		}
		
		
		for(int i=start;i<=N;i++) {
			
			
			
			
		}
		
	}
	
	static void comb2(int index,int start,int left,int right) {
		if(index == N) {
			count++;
			return;
		}
		
		
		for(int i=start;i<=N;i++) {
			
			
			
			
		}
		
	}
	
	
	
	//이전메만든 조합에 대한 갯수저장
	

}
