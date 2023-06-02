package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_최솟값과최댓값_2357_2 {

	static int arr[] ,smallTree[], bigTree[];
	
	public static void main(String [] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		int tree_size = (1 << ((int)Math.ceil( Math.log(N)/Math.log(2) )+1)); //log2(N)의올림의 +1
		//System.out.println(tree_size);
		smallTree = new int[tree_size+1];
		bigTree = new int[tree_size+1];
		
		for(int i=0; i<N;i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		initsmall(0,N-1,1);
		initbig(0,N-1,1);
		//System.out.println(Arrays.toString(smallTree));
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			
			int min = Integer.MAX_VALUE;
			int max = Integer.MIN_VALUE;
			
			int start = Integer.parseInt(st.nextToken()) - 1 ;
			int end = Integer.parseInt(st.nextToken()) - 1;
			
			min = findMin(0,N-1,start,end,1);
			max = findMax(0,N-1,start,end,1);
//			for(int j = start ; j <= end ; j++) {
//				int now = arr[j];
//				min = (min > now) ? now: min;
//				max = (max < now) ? now : max;
//			}
			sb.append(min).append(" ").append(max).append("\n");
			
		}
		
		System.out.println(sb);
		
	}
	//세그먼트 트리2개
	static public int initsmall(int start, int end, int index) {
		 if(start ==end) return smallTree[index] = arr[start];
		 
		 int mid = (start + end) /2;
		 return smallTree[index] = Math.min(initsmall(start,mid,index*2), initsmall(mid+1,end,index*2+1));
		 
	 }
	static public int findMin(int start, int end, int left, int right, int index){
		//완전히 밖일때
		if( end < left || start > right) {
			return Integer.MAX_VALUE;
		}
		//완전일치시
		if(left <= start && end <= right) {
			return smallTree[index];
		}
		
		int mid = (start + end )/2;
		return Math.min(findMin(start,mid,left,right,index*2), findMin(mid+1,end,left,right,index*2+1));
	}
	
	
	
	//
	static public int initbig(int start, int end, int index) {
		 if(start ==end) return bigTree[index] = arr[start];
		 
		 int mid = (start + end) /2;
		 return bigTree[index] = Math.max(initbig(start,mid,index*2), initbig(mid+1,end,index*2+1));
		 
	 }
	static public int findMax(int start, int end, int left, int right, int index){
		//완전히 밖일때
		if( end < left || start > right) {
			return Integer.MIN_VALUE;
		}
		//완전일치시
		if(left <= start && end <= right) {
			return bigTree[index];
		}
		
		int mid = (start + end )/2;
		return Math.max(findMax(start,mid,left,right,index*2), findMax(mid+1,end,left,right,index*2+1));
	}

}
