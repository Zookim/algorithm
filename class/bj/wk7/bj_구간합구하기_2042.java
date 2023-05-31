package bj.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_구간합구하기_2042 {

	static int N,K,M;
	static long[] nums, tree;
	public static void main(String[] args) throws IOException {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		nums = new long[N+1]; //dummy
		tree = new long[N+1];
		
		for (int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			nums[i] = Long.parseLong(st.nextToken());
		}
		//펜윅트리를 구성
		for (int i = 1; i <=N; i++) {
			update(i,nums[i]); //최소 tree생성시에는 배열이 0이므로 값을 그대로 전달하면 그것이 diff
		}
		
		//변경 또는 합을 구한다.
		for (int i = 0; i <M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			
			if(a ==1) { //b번째 수를 c로 변경
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				long temp = nums[b];
				nums[b] = c; //원본 배열의 b자리를 c로 변경
				update(b,c-temp);
			}else if(a==2){ //b~c 수의 합을 구한다.
				int b = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				long s =  sum(b,c);
				System.out.println(s);
			}
		}
		
		//System.out.println();
	}
	static long sum(int i) {
		long result =0;
		while( i> 0) {
			result += tree[i];
			i -= (i & -i);
		}
		return result;
	}
	static long sum (int i,int j) {
		return sum(j) - sum(i-1); // 두구간을 합해야하므로
	}
	static void update(int i,long diff) {	
		while(i<N+1) {
			tree[i] += diff;
			i += (i & -i);// 마지막 자리의 비트를 더한만큼의 수를 가진 index의 값들을 모두 갱신한다.
		}
		
	}

}
