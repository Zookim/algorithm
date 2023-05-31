package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_내려가기_2096 {
static int arr[][];
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
		arr = new int [N][3];
		now = new int [N];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		perm(0,0);
		
		System.out.println(max+ " "+min);

	}
	static void perm(int index,int sum) { //중복 순열
		if(index == N) {
			min = Math.min(min,sum);
			max = Math.max(max,sum);
			//System.out.println(Arrays.toString(now)+" "+sum);
			return;
		}
		
		for(int i=0;i<3;i++) {
			now[index] = i;
			if(index >= 1 && Math.abs(now[index-1]-i) > 1) {continue;}
			sum += arr[index][i];
			perm(index+1,sum);
			sum -= arr[index][i];
		}
		
	}

}
