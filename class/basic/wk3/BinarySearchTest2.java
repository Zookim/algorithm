package basic.wk3;

import java.util.Arrays;

public class BinarySearchTest2 {


	static int values[] = {1,5,7,10,13}; 
	public static void main(String[] args) {
		//값이 있다면 그곳의 인덱스를 반환한다.
		System.out.println(Arrays.binarySearch(values, 5));
		System.out.println(Arrays.binarySearch(values, 13)); // 값이 이

		// 값이 없다면 원래 들어가야 할자리를 1부터시작해서 알려준다(단, -마이너스를 붙여알려준다.)
		System.out.println(Arrays.binarySearch(values, 0));
		System.out.println(Arrays.binarySearch(values, 2));
		System.out.println(Arrays.binarySearch(values, 3));
		System.out.println(Arrays.binarySearch(values, 8));
	}
}
