package basic.wk2;

import java.util.Arrays;

public class Comb_NP {

	static int[] src ={1,2,3,4,5,6}; //�������� ���
	static int[] tgt = new int[3];
	static int[] index = new int[src.length];
	public static void main(String[] args) {
		// 0 0 0 1 1 1 -> ����������
		// ...
		// 1 1 1 0 0 0 -> ����ū��
		
		//tgt ����ŭ index �迭�� ������ ä���.
		for (int i = src.length-1; i >= src.length - tgt.length; i--) {
			index[i] =1;
		}
		System.out.println(Arrays.toString(index));
		
		while(true) {
			int tgtindex =0;
			for (int i = 0; i < index.length; i++) {
				if(index[i] ==1){
					tgt[tgtindex++] = src[i];
				}
			}
			System.out.println(Arrays.toString(index)+ " "+ Arrays.toString(tgt));
			if(!np(index)) break;
		}


	}
	static boolean np(int[] array) { //true: �� ū���� ���� �� �ִ�. false ���̻� ū���� ����.
		int i = array.length-1;
		while(i > 0 && array[i-1] >= array[i])i--; //���ڸ��� �� Ŭ������ �̵�
		if(i==0) return false;

		int j = array.length-1;
		while(array[i-1] >= array[j]) j--;

		swap(array,i-1,j);
		
		int k = array.length-1;
		if(i<k) {
			swap(array,i++,k--);
		}
		return true;
		

	}

	static void swap(int[] array,int i,int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] =temp;
	}

}
