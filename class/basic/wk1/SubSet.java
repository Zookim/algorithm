package basic.wk1;

public class SubSet {

	static int[] src = {1,2,3,4,5};
	static int COUNT;
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		subset(0);
		System.out.println("COUNT " + COUNT);

	}
	static void subset(int srcIdx) {
		if(srcIdx == src.length) {// 기저조건
		printSubset();
		COUNT++;
		return;
		}
		
		// 현재 srcIdx의 원소를 선택혹은 2가지 경우로 재귀호출을 이어간다.
		// 선택이란 select 배열의 srcIdx를true
		// 비선택이란 select 배열의 srcIdx를 false
		
		select[srcIdx] = true;
		subset(srcIdx +1);
		select[srcIdx] = false;
		subset(srcIdx +1);
		//
		
		
	}
	static void printSubset() {
		for (int i = 0; i < select.length; i++) {
			if(select[i]) System.out.print(src[i]+" ");
		}		
		System.out.println();
	}

}
