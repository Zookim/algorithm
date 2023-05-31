package basic.wk1;

public class SubSet_Param {

	static int[] src = {1,2,3,4,5};
	static int COUNT;
	
	
	public static void main(String[] args) {
		boolean[] select = new boolean[src.length];
		subset(0,select);
		System.out.println("COUNT " + COUNT);

	}
	static void subset(int srcIdx, boolean [] select) {
		if(srcIdx == src.length) {// ��������
		printSubset(select);
		COUNT++;
		return;
		}
		
		// ���� srcIdx�� ���Ҹ� ����Ȥ�� 2���� ���� ���ȣ���� �̾��.
		// �����̶� select �迭�� srcIdx��true
		// �����̶� select �迭�� srcIdx�� false
		
		select[srcIdx] = true;
		subset(srcIdx +1,select);
		select[srcIdx] = false;
		subset(srcIdx +1,select);
		//
		
		
	}
	static void printSubset( boolean [] select) {
		for (int i = 0; i < select.length; i++) {
			if(select[i]) System.out.print(src[i]+" ");
		}		
		System.out.println();
	}

}
