package basic.wk1;

import java.util.Arrays;

public class Comb_TWO {
	
	static int COUNT ;
	static int [] src = {1,2,3};
	static int [] tgt = new int[3];
	
	public static void main(String[] args) {
		comb(0,0); //src�� index, tgt�� �ε���
		System.out.println(COUNT);
		
	}
	//tgt�� �ε��� tgtidx�� �ڸ��� src�� ���� ���, srcidx���� ����Ѵ�.(������ ���°� �� ������ �� �ʿ����.)
	static void comb(int srcidx, int tgtidx) { // srcidx ������ ���Ұ�, tgtidx�� �ڸ���
		//���� ����tgt
		if(tgtidx == tgt.length) { //���� ����
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		//�������� src
		if(srcidx == src.length) return; //for���� ���� �ʱ�����, ������ �����ʵ����Ѵ�
		tgt[tgtidx] = src[srcidx];
		comb(srcidx+1,tgtidx+1);// 1���� �̸� �̾Ƴ���(���� ���õȰ� ),�������� �̴°���� ���� �ѱ��.
		comb(srcidx+1,tgtidx); //1���� ������ ����(���� �����Ѱ��� �����Ѵ�.), ���� ���߿��� �̴´�.
		//(���ð����� ���(srcidx)�� �پ�����, �̾ƾ��ϴ� �ڸ���(tgtidx)�� �پ���� �ʾҴ�.)


	}
	


}
