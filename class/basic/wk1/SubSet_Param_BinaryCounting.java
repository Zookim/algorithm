package basic.wk1;


// �Ķ���ͷ� select �迭 =>  bitmask
// bit ������  : &,|, <<
//� �� | 1 <<3 => � ���� 3��° ��Ʈ�� 1�� �ٲ۴�.(���� 1 �̵� 0�̵� )
// � �� & 1 <<3
//select [t,f,t,f,...] index ���� 2���� ���� �����Ƿ� ������ bit������ ��ü��ų�� �ִ�.
// bit ǥ���� 0,1 �ΰ���

public class SubSet_Param_BinaryCounting {

	static int[] src = {1,2,3,4,5};
	public static void main(String[] args) {
		int subsetCnt = 1 << src.length;
		
		for (int i = 0; i < subsetCnt; i++) { // 0~�κ������� �Ѽ� - 1����
			// i�� bit ����ũ�� �ȴ�.
			//j�� src�� �ε���
			
			for (int j = 0; j < src.length; j++) {
				if((i & 1 << j) !=0) System.out.print(src[j]+" "); //��� ����� ���� ��Ÿ���� i�� ������ �κ� ������ ���Ѵ�.
			}	
			System.out.println();
			
		}


	}
	static void subset(int srcIdx, int mask) {  // mask ���� ���� �����ϰų� ���ų� �Ѵ�.
		if(srcIdx == src.length) {// ��������
		printSubset(mask);
		return;
		}
		
	}
	static void printSubset( int mask) {
		
		for (int i = 0; i < src.length; i++) {
			if((mask & 1 << i) !=0) System.out.print(src[i]+" ");
			
			
		}	
		System.out.println();
	}

}
