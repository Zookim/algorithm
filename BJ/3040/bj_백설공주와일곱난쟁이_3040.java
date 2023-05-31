package algo.hw;

import java.util.Scanner;

public class bj_백설공주와일곱난쟁이_3040 {
	//합이 100이 되는 7개의 수 찾기 ,1-99
	//입력해주는 순서대로 출력
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int [] arr = new int [9];
		int sum =0;
		for(int i=0;i<9;i++) {
			arr[i] = sc.nextInt();
			sum+=arr[i];
		}
		int an = sum-100;
		
		for(int i=0;i<9;i++) {
			for(int j=(i+1);j<9;j++) {
				if(arr[i]+arr[j] == an) {
					arr[i]=0;
					arr[j]=0;
					i=9;
					break;
				}
			}
		}
		
		for(int a : arr) {
			if(a == 0) continue;
			System.out.println(a);
		}
	}
}
