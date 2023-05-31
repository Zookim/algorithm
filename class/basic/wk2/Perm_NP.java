package basic.wk2;

import java.util.Arrays;

public class Perm_NP {

	static int[] src = {3,1,5,4,2};
	public static void main(String[] args) {
		//np�� ��� ����� ���� ������� �ݵ�� ������ ���� ����� ������ ������������
		// �������� ���� ����� ����
		Arrays.sort(src);
		
		//np()�� ȣ���ϸ� '��'��° ������ �����.(ù��° ������ �ƴϴ�.)
		
		while(true) {
			//ó�� ������ �Էº��Ͱ� �����̹Ƿ� �ٷ�ó��
			System.out.println(Arrays.toString(src));
			
			
			if(!np()) break;
		}

	}
	static boolean np() { //true: �� ū���� ���� �� �ִ�. false ���̻� ū���� ����.
		int i= src.length -1;
	
		while(i>0 && src[i-1] >=src[i]) --i; // ���������̸� ��� ������ �̵�
		if(i ==0) return false;//���� �Ǿ��̸� ,���̻� ����.
		
		int j = src.length -1;
		while(src[i-1] >= src[j]) j--;//
		swap(i-1,j); // �տ��� �ٲ� ���� �ڿ��� �ٲܰ��� ã�Ҵ�.
		
		int k = src.length -1;
		while(i < k) {
			swap(i++,k--); //�߾����� ���� ����
		}
		return true;
	}
	
	static void swap(int i,int j) {
		int temp = src[i];
		src[i] = src[j];
		src[j] =temp;
	}

}
