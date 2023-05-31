package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_내려가기_2096_2 {
static int arr[];
static int arr_tmp[];
static int N;
static int [] now;
static int max;
static int min;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		min = Integer.MAX_VALUE;
		max = Integer.MIN_VALUE;
		N = Integer.parseInt(br.readLine());
		arr = new int [6]; //
		arr_tmp = new int[6];
		now = new int [N];
		
		st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		arr[0] = a;arr[1] = a;
		a = Integer.parseInt(st.nextToken());
		arr[2] = a;arr[3] = a;
		a = Integer.parseInt(st.nextToken());
		arr[4] = a;arr[5] = a;
		
		
		for(int i=1;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			a = Integer.parseInt(st.nextToken());
			arr_tmp[0] = Math.min(arr[0]+a, arr[2]+a);
			arr_tmp[1] = Math.max(arr[1]+a, arr[3]+a);
			
			a = Integer.parseInt(st.nextToken());
			arr_tmp[2] =  Math.min(Math.min(arr[0]+a, arr[2]+a),arr[4]+a);
			arr_tmp[3] =  Math.max(Math.max(arr[1]+a, arr[3]+a),arr[5]+a);
			
			a = Integer.parseInt(st.nextToken());
			arr_tmp[4] = Math.min(arr[2]+a, arr[4]+a);
			arr_tmp[5] = Math.max(arr[3]+a, arr[5]+a);
			
			for(int j=0;j<6;j++) {
				arr[j] = arr_tmp[j];
			}
			
		}
		//perm(0,0);
		max = Math.max(Math.max(arr[1], arr[3]),arr[5]);
		min =  Math.min(Math.min(arr[0], arr[2]),arr[4]);
		
		System.out.println(max+ " "+min);

	}
	
}
