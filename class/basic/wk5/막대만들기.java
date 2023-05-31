package basic.wk5;

import java.util.Arrays;

public class 막대만들기 {

	
	static int[] memoi = new int[7] ;//0dummy
	public static void main(String[] args) {
		
		memoi[1] = 2; //1��
		memoi[2] = 5; //2��
	
		
		//i ���̸� ����� ����� ����
		// ���� 1��¥���� �����ؼ� i���̸� ����� ���A + ���� 2¥���� �̿��� i���̸� ����� ����� ��A
		// ���� 1¥���� �����ؼ� i���̸� ����� ����� ��A => ���� i-1�� ����� ����� �� *2
		// ���� 2¥���� �����ؼ� i���̸� ����� ����� ��B => ���� i-2�� ����� ����� �� 
		
		for(int i=3; i<=6;i++) {			
			memoi[i] = 2*memoi[i-1] + memoi[i-2] ;
		}
		System.out.println(Arrays.toString(memoi));
	}
	


}




