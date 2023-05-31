package basic.wk1;

import java.util.Arrays;

public class Comb_FOR {
	
	static int COUNT ;
	static int [] src = {1,2,3,4,5};
	static int [] tgt = new int[3];
	
	public static void main(String[] args) {
		comb(0,0); //src의 index, tgt의 인덱스
		System.out.println(COUNT);
		
	}
	//tgt의 인덱스 tgtidx의 자리에 src의 수를 고려, srcidx부터 고려한다.(이전에 나온걸 또 나오게 할 필요없다.)
	static void comb(int srcidx, int tgtidx) { // srcidx 조합의 원소값, tgtidx는 자릿수
		
		if(tgtidx == tgt.length) { //기저 조건
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		for(int i=srcidx;i<src.length;i++) { //
			tgt[tgtidx] = src[i];
			comb(i+1,tgtidx+1);
		}


	}
	static void comb2(int srcidx, int tgtidx) { // srcidx 조합의 원소값, tgtidx는 자릿수

		if(tgtidx == tgt.length) { //기저 조건
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
