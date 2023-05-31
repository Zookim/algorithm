package algo_live.permu;

import java.util.Arrays;
import java.util.Scanner;

public class nextperm {
//nPn만 가능 nPr은 구할 수 없다.
	//실행시간 : 0.118 N =11
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int R=sc.nextInt();
		int[] input =new int[N];

		
		for(int i=0; i<N;++i) {
			input[i] =sc.nextInt();
		}
		long start = System.currentTimeMillis();
		//전처리
		Arrays.sort(input);
		
		do {//순열을 만든다.
			//System.out.println(Arrays.toString(input));
		}while(np(input)); //다음 순열이 더이상 없으면 out 
		long end = System.currentTimeMillis();

		System.out.println("실행시간 : " + (end - start)/1000.0);
	}
	private static boolean np(int[] input) {
		int n=input.length;
		
		//1. 뒤쪽부터 꼭대기를 찾는다.
		int i =n-1;
		while(i>0 && input[i-1] >=input[i]) --i; //범위를 벗어났거나, 첫 고개를 넘으면 나온다.
		if(i==0)return false;
		//2.꼭대기 바로앞(i-1)자리에 교환할 값을 뒤쪽부터 찾는다.
		int j=n-1;
		while(input[i-1]>=input[j]) --j; // 뒤쪽부터 나(i-1)보다 큰값을 찾으면 나온다.(꼭대기가 될 수 도 있다.)
	
		//3. 꼭대기 바로 앞(i-1)자리와 그 자리값보다 한단계 큰 자리(j) 수와 교환
		swap(input,i-1,j);
		
		//4. 꼭대기 부터 맨뒤까지 오름차순으로 정렬
		int k=n-1;
		while(i<k) {
			swap(input,i++,k--);
		}
		return true;

	
	}

	private static void swap(int[] input,int i,int j) {
		int temp = input[i];
		input[i] =input[j];
		input[j] = temp;
	}
}
