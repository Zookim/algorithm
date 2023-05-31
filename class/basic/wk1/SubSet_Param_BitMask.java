package basic.wk1;


// �Ķ���ͷ� select �迭 =>  bitmask
// bit ������  : &,|, <<
//� �� | 1 <<3 => � ���� 3��° ��Ʈ�� 1�� �ٲ۴�.(���� 1 �̵� 0�̵� )
// � �� & 1 <<3
//select [t,f,t,f,...] index ���� 2���� ���� �����Ƿ� ������ bit������ ��ü��ų�� �ִ�.
// bit ǥ���� 0,1 �ΰ���

public class SubSet_Param_BitMask {

	static int[] src = {1,2,3,4,5};
	static int COUNT;
	
	
	public static void main(String[] args) {
		//boolean[] select = new boolean[src.length];
		//���� select�� ó���� ��� false
		//�����ϰ� bitMask �� ���ڸ��� bit�� ��� 0�α�� ���� =>0
		System.out.println(Integer.toBinaryString(22));
		subset(0,0);
		System.out.println("COUNT " + COUNT);
//		System.out.println(2 | 5 );
//		System.out.println(2 & 5 );
//		System.out.println(1 << 3 );
//		System.out.println(5 & 5 );

	}
	static void subset(int srcIdx, int mask) {  // mask ���� ���� �����ϰų� ���ų� �Ѵ�.
		if(srcIdx == src.length) {// ��������
		printSubset(mask);
		COUNT++;
		return;
		}
		
		// ���� srcIdx�� ���Ҹ� ����Ȥ�� 2���� ���� ���ȣ���� �̾��.
		// �����̶� select �迭�� srcIdx��true
		// �����̶� select �迭�� srcIdx�� false

	//	select[srcIdx] = true;

		subset(srcIdx +1,mask | 1 << srcIdx); // �Ѱܹ��� mask �� srcIdx ��° bit�� 1�� ����
		
	//	select[srcIdx] = false; 
		subset(srcIdx +1,mask); // �Ѱܹ��� mask�� 	��ȭ x
		//
		
		
	}
	static void printSubset( int mask) {
		
		
		for (int i = 0; i < src.length; i++) {
			if((mask & 1 << i) !=0) System.out.print(src[i]+" ");
			
			
		}	
		System.out.println("mask " +mask);
		System.out.println();
	}

}
