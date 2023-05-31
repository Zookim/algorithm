package algo_live.permu;

import java.util.Arrays;
import java.util.Scanner;

public class nextperm {
//nPn�� ���� nPr�� ���� �� ����.
	//����ð� : 0.118 N =11
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N=sc.nextInt();
		int R=sc.nextInt();
		int[] input =new int[N];

		
		for(int i=0; i<N;++i) {
			input[i] =sc.nextInt();
		}
		long start = System.currentTimeMillis();
		//��ó��
		Arrays.sort(input);
		
		do {//������ �����.
			//System.out.println(Arrays.toString(input));
		}while(np(input)); //���� ������ ���̻� ������ out 
		long end = System.currentTimeMillis();

		System.out.println("����ð� : " + (end - start)/1000.0);
	}
	private static boolean np(int[] input) {
		int n=input.length;
		
		//1. ���ʺ��� ����⸦ ã�´�.
		int i =n-1;
		while(i>0 && input[i-1] >=input[i]) --i; //������ ����ų�, ù ���� ������ ���´�.
		if(i==0)return false;
		//2.����� �ٷξ�(i-1)�ڸ��� ��ȯ�� ���� ���ʺ��� ã�´�.
		int j=n-1;
		while(input[i-1]>=input[j]) --j; // ���ʺ��� ��(i-1)���� ū���� ã���� ���´�.(����Ⱑ �� �� �� �ִ�.)
	
		//3. ����� �ٷ� ��(i-1)�ڸ��� �� �ڸ������� �Ѵܰ� ū �ڸ�(j) ���� ��ȯ
		swap(input,i-1,j);
		
		//4. ����� ���� �ǵڱ��� ������������ ����
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
