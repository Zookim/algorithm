package basic.wk2;

public class CircleArray {
	public static void main(String[] args) {
		normal();
		curcular();
		//normal : 494181900
		//normal : 6747285500
	}
	static void normal() { //얘가 더빠르다.
		
		long start = System.nanoTime();
		
		int idx = 0;
		int idxMax = 99999999;
		
		int cnt = 0;
		while(true) {
			if(cnt == 999999999) break;
			idx++;cnt++;
			if(idx == idxMax)idx =0;
		}

		long end = System.nanoTime();
		System.out.println("normal : "+(end-start));
	}
	static void curcular() {

		long start = System.nanoTime();

		int idx = 0;
		int idxMax = 99999999;

		int cnt = 0;
		while(true) {
			if(cnt == 999999999) break;
			idx++;cnt++;
			idx = idx %idxMax+1;
		}

		long end = System.nanoTime();
		System.out.println("normal : "+(end-start));
	}

}

