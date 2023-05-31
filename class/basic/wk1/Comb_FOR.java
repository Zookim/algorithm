package basic.wk1;

import java.util.Arrays;

public class Comb_FOR {
	
	static int COUNT ;
	static int [] src = {1,2,3,4,5};
	static int [] tgt = new int[3];
	
	public static void main(String[] args) {
		comb(0,0); //src�� index, tgt�� �ε���
		System.out.println(COUNT);
		
	}
	//tgt�� �ε��� tgtidx�� �ڸ��� src�� ���� ���, srcidx���� ����Ѵ�.(������ ���°� �� ������ �� �ʿ����.)
	static void comb(int srcidx, int tgtidx) { // srcidx ������ ���Ұ�, tgtidx�� �ڸ���
		
		if(tgtidx == tgt.length) { //���� ����
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		for(int i=srcidx;i<src.length;i++) { //
			tgt[tgtidx] = src[i];
			comb(i+1,tgtidx+1);
		}


	}
	static void comb2(int srcidx, int tgtidx) { // srcidx ������ ���Ұ�, tgtidx�� �ڸ���

		if(tgtidx == tgt.length) { //���� ����
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}

		for(int i=srcidx;i<src.length;i++) { //
			tgt[tgtidx] = src[i];
			comb2(i,tgtidx+1);
		}


	}


}
