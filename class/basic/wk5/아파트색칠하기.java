package basic.wk5;

import java.util.Arrays;

public class 아파트색칠하기 {

	
	static int[] memoi = new int[11] ;//0dummy
	public static void main(String[] args) {
		
		memoi[1] = 2; //1��
		memoi[2] = 3; //2��
	
		
		//n�� = n-1���� ���� n-1���� �����
		//n�� = n-1���� ���� n-2���� ��
		
		for(int i=3; i<=10;i++) {
			
			memoi[i] = memoi[i-1] + memoi[i-2] ;
		}
		System.out.println(Arrays.toString(memoi));
	}

}




