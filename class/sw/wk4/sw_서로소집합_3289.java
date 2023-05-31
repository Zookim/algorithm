package sw.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_서로소집합_3289 {

	static int N,M;
	static StringBuilder sb;
	static int arr[];
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			sb =  new StringBuilder(); 
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
				int num =  Integer.parseInt(st.nextToken());
				int a =  Integer.parseInt(st.nextToken());
				int b =  Integer.parseInt(st.nextToken());
				
				
				if(num ==1) { //확인하고 결과를 넣는다.
					if(findSet(a) == findSet(b)) {//부모가 같으면
						sb.append(1);
					}else {
						sb.append(0);
					}
					
				}else {// 
					union(a,b);
				}
				//System.out.println(Arrays.toString(arr));
				
			}
			System.out.println("#"+test_case+" "+sb);
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
			return arr[i] = findSet(arr[i]); //Path Compression // i를 올라가면서 부모들도 같이 부모를 변경한다.
		}
	}
	

}
