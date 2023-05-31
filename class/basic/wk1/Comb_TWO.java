package basic.wk1;

import java.util.Arrays;

public class Comb_TWO {
	
	static int COUNT ;
	static int [] src = {1,2,3};
	static int [] tgt = new int[3];
	
	public static void main(String[] args) {
		comb(0,0); //src의 index, tgt의 인덱스
		System.out.println(COUNT);
		
	}
	//tgt의 인덱스 tgtidx의 자리에 src의 수를 고려, srcidx부터 고려한다.(이전에 나온걸 또 나오게 할 필요없다.)
	static void comb(int srcidx, int tgtidx) { // srcidx 조합의 원소값, tgtidx는 자릿수
		//기저 조건tgt
		if(tgtidx == tgt.length) { //기저 조건
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		//기저조건 src
		if(srcidx == src.length) return; //for문을 쓰지 않기위해, 범위를 넘지않도록한다
		tgt[tgtidx] = src[srcidx];
		comb(srcidx+1,tgtidx+1);// 1개를 미리 뽑아놓고(현재 선택된것 ),나머지를 뽑는경우의 수로 넘긴다.
		comb(srcidx+1,tgtidx); //1개를 제외해 놓고(현재 선택한것을 제외한다.), 남은 것중에서 뽑는다.
		//(선택가능한 대상(srcidx)은 줄었지만, 뽑아야하는 자릿수(tgtidx)는 줄어들지 않았다.)


	}
	


}
