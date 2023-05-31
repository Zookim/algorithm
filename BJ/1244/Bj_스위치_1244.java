package algo.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Bj_스위치_1244 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int [] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int num = Integer.parseInt(br.readLine());
		String []std = new String[2];
		for(int i=0;i<num;i++) {
			std = br.readLine().split(" ");
			if(Integer.parseInt(std[0]) == 1) {
				boy(arr,Integer.parseInt(std[1]),N);
				//System.out.println(Arrays.toString(arr));
				}
			
			else if(Integer.parseInt(std[0]) == 2) {
				
				girl(arr,Integer.parseInt(std[1])-1,N);
				//System.out.println(Arrays.toString(arr));
			}
	
		}
		
		for(int i=0;i<N;i++) {
			System.out.printf("%d ",arr[i]);
			if((i+1)%20 ==0) {System.out.println();}
		}
		
		
		

	}
	static void tog(int [] arr,int n) {
		if(arr[n] == 0) {
			arr[n] =1;
		}else {
			arr[n] =0;
		}
	}
	static void boy(int [] arr, int n,int N) {
		
		for(int i=1;i<=N;i++) {
			if(n*i <= N) {
				tog(arr,n*i-1);
			}else {return;}
		}

	}
	static void girl(int [] arr, int n,int N) {
		tog(arr,n);
		for(int i=1;i<=N/2;i++) {
			if((n-i )>=0 && (n+i) < N) {
				if(arr[n-i] == arr[n+i]) {
					tog(arr,n-i);
					tog(arr,n+i);
				}
				else {return;}
				
			}
		}

	}

}
