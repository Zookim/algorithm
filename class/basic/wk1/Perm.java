package basic.wk1;

import java.util.Arrays;

//����
//�̹� ���� index�� �������� �ʱ� ���� ������ �ڷᱸ�� : select

public class Perm {

	static int[] src = {1,2,3,4,5};
	static int tgt[] = new int[3];
	static int COUNT;
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 0 <- �ڸ����� �ǹ�, �Ǿտ��� ���� ����
		// 0 <- tgt�� �ڸ���
		// tgt�� ù��° �ڸ����� ä�������ڴ�.
		
		perm2(0);
		System.out.println(COUNT); //��ü ����� ��
		
		

	}
	//tgtIdx�� �ڸ��� ���ϳ��� �����ϰ� ��� ���� tgt �� ä�������ڴ�.
	// ��� ȣ�� �����̹Ƿ� �������� �ʿ�
	
	static void perm(int tgtIdx) {
		
		//��������: 0->1->2->3; 3�̸� �Ϸ�
		if(tgtIdx == tgt.length) {
			//complete code
			//����� ���� �Ѱ����� �ϼ��� ����
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		// �ڱ� �ڸ��� � �ڸ��� ������ �����ϰ� 
		//�����ڸ����� ���� �ڽ��� �ٽ�ȣ���Ѵ�.
		//�ٽ� ��ȯ�ϱ����� ���� ���¸� Ǯ�ش�.
		for(int i=0; i< src.length;i++) { //���� �ڸ��� �ü� �ִ� ����
			//�̹� ���� ���� ����
			if(select[i]) continue;
			//selcet[i] �� false�̹Ƿ� ���� ������ ���� �� �̴�.
			tgt[tgtIdx] = src[i];
			select[i] = true;
			
			perm(tgtIdx+1); // ���� �ڸ����� ��������
			//������ ���� �ϳ��� ������ �ϼ��ȴ�.
			// ��ȯ�� �ٽ� ���� ������ ����ϹǷ�
			// ����for���� ������ �ʾ��� ��, select�� �����Ͽ�
			// ���� �����ϼ��ǵ����Ѵ�.
			select[i] = false;
			
			
		}
		
		

	}
	static void perm2(int tgtIdx) { //�ߺ��� ����ϴ� ���


		if(tgtIdx == tgt.length) {

			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}


		for(int i=0; i< src.length;i++) { //���� �ڸ��� �ü� �ִ� ����
			//�̹� ���� ���� ����
	
			//selcet[i] �� false�̹Ƿ� ���� ������ ���� �� �̴�.
			tgt[tgtIdx] = src[i];
	

			perm2(tgtIdx+1); // ���� �ڸ����� ��������
			//������ ���� �ϳ��� ������ �ϼ��ȴ�.
			// ��ȯ�� �ٽ� ���� ������ ����ϹǷ�
			// ����for���� ������ �ʾ��� ��, select�� �����Ͽ�
			// ���� �����ϼ��ǵ����Ѵ�.



		}



	}

}
