package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_구간합_2042 {

	static int N,M,K;
	static long [] arr, tree;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); //1_000_000
		M = Integer.parseInt(st.nextToken()); //10_000
		K = Integer.parseInt(st.nextToken()); //10_000
		
		
		arr = new long[N];
		
		int tree_size = (1 << ((int)Math.ceil( Math.log(N)/Math.log(2) )+1)); //log2(N)의올림의 +1
		//System.out.println(tree_size);
		tree = new long[tree_size+1];
		
		for(int i=0;i<N;i++) {
			// 초기 값을 세팅한다.
			arr[i] = Long.parseLong(br.readLine());
			
		}
		//System.out.println();
		init(0,N-1,1); //1~N까지의 값을 세팅해 놓는다.
		//System.out.println(Arrays.toString(tree));
		
		for(int i=0;i<(M+K);i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			if(n == 1) {//값을 수정한다.
				int b = Integer.parseInt(st.nextToken());
				long c = Long.parseLong(st.nextToken());
				update(0,N-1,1,b-1,c);
				
			}else { //값을 더한다.
				int b = Integer.parseInt(st.nextToken())-1;
				int c = Integer.parseInt(st.nextToken())-1;
				
				sb.append(sum(0,N-1,b,c,1)).append("\n");
			}
			//System.out.println(Arrays.toString(tree));
			
			
		}
		System.out.println(sb);
		
		
	}
	static public long update(int start, int end,int index, int new_index,long data) {
		//값이 변하지 않는 영역인 경우
		if(new_index < start || new_index > end) {
			return tree[index];
		}
		//수정해야하는 leaf인 경우
		if(start == new_index && end == new_index) {
			return tree[index] = data;
		}
		int mid = (start+end)/2;
		return tree[index] = update(start,mid,index*2,new_index,data) + update(mid+1,end,index*2+1,new_index,data);
	}
	
	
	static public long sum(int start, int end, int left, int right, int index) {
		//아예 범위 밖에 있는 경우
		if(left > end || right < start) {
			return 0;
		}
		if(left <= start && end <= right) {
			return tree[index];
		}
		
		int mid = (start+end)/2;
		return sum(start,mid,left,right,index*2) + sum(mid+1,end,left,right ,index*2+1);
	}
	static public long init(int start, int end, int index) {
		//System.out.println(index +" "+ start +" "+end );
		if(start == end) {return tree[index] = arr[start];}
		int mid = (start+end) / 2;
		return tree[index] = init(start,mid,index*2) + init(mid+1,end,index*2+1);
		//왼자식과 오른자식의 합으로 구한다.
	
	}

}
