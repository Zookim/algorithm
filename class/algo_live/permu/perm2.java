package algo_live.permu;

import java.util.Arrays;
import java.util.Scanner;

public class perm2 {

	static int N,R;
	static int[] numbers,input;
	static boolean[]  isSelected;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N=sc.nextInt();
		R=sc.nextInt();

		
		numbers = new int[R];
		input = new int[N];
		isSelected = new boolean[N];
		
		for(int i=0; i<N;++i) {
			input[i] =sc.nextInt();
		}
		long start = System.currentTimeMillis();
		//perm2(0,0); //실행시간 : 1.233
		perm(0); //실행시간 : 1.112
		long end = System.currentTimeMillis();

		System.out.println("실행시간 : " + (end - start)/1000.0);
	}

	static void perm(int cnt) {
		if(cnt == R) {
			//System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0;i<N;i++) {
			if(isSelected[i]) continue;
			
			numbers[i] = input[i];
			isSelected[i] = true;
			perm(cnt+1);
			isSelected[i] = false;
		}
	}
	static void perm2(int cnt,int mask) {
		if(cnt == R) {
			//System.out.println(Arrays.toString(numbers));
			return;
		}
		for(int i=0;i<N;i++) {
			if(((mask & (1<<i)) !=0)) continue;
			
			numbers[cnt] = input[i];
			perm2(cnt+1,mask | (1<<i));

		}
	}
}
