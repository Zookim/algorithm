package basic.wk5;

import java.util.Arrays;

public class LIS {

	
	static int[] intArray = { 2,3,4,2,5,1,7,3,2,9,10,3,12,8,21,37,12,35,40 };
	static int N= intArray.length;
	static int[] LIS = new int[N];
	
	public static void main(String[] args) {
		for (int i = 0; i < N; i++) {
			//i번째를 따질때, 항상 초기값을 1로 설정
			LIS[i] = 1;
			
			//맨 앞에서 부터 i전까지 비교해서 작은 수가 나오면
			// 그 수의 LIS + 1 값과 자신의 LIS 값을 비교해서 큰값을 선택
			
			for (int j = 0; j <i; j++) {
				//나보다 작으면서 LIS값이 더 큰값이라면 그값+1을 가진다.
				if(intArray[j] < intArray[i] && LIS[j] >= LIS[i]) {
					LIS[i] = LIS[j] + 1;
				}
			}
		}
		
		System.out.println(Arrays.toString(LIS));
		
	}

}
