package basic.wk3;



import java.util.Arrays;

public class BinarySearchAPITest {
	//                        0  1  2   3   4
	static int[] values = {1, 5, 7, 10, 13};
	public static void main(String[] args) {
//		System.out.println(Arrays.binarySearch(values, 5));
//		System.out.println(Arrays.binarySearch(values, 13));
//		System.out.println(Arrays.binarySearch(values, 6));
//		
		//binarySearch(시작,끝,찾는값) , 값을 찾지 못하면 음수로 반환 
		
		// 1 3 2 5 4
		int[] memoi =new int[5];
		//0 ~ 0에 1의 값
		System.out.println(Arrays.binarySearch(memoi, 0,0,1)); //-1의 절대값에 -1 =0
		memoi[0] =1;
		//0 ~ 1에 3의 값
		System.out.println(Arrays.binarySearch(memoi, 0,1,3)); //-2의 절대값에 -1 =1
		memoi[1] =3;

		//0 ~ 2에 3의 값
		System.out.println(Arrays.binarySearch(memoi, 0,2,2)); //(-2의 절대값)에 -1 =1
		memoi[1] =2;

		//0 ~ 2에 3의 값
		System.out.println(Arrays.binarySearch(memoi, 0,3,5)); //(-2의 절대값)에 -1 =1
		memoi[1] =5;
		
		//0 ~ 2에 3의 값
		System.out.println(Arrays.binarySearch(memoi, 0,4,4)); //(-2의 절대값)에 -1 =1
		memoi[1] =4;

	}

}

