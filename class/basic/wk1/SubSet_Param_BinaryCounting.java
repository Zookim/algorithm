package basic.wk1;


// 파라미터로 select 배열 =>  bitmask
// bit 연산자  : &,|, <<
//어떤 것 | 1 <<3 => 어떤 것의 3번째 비트를 1로 바꾼다.(원래 1 이든 0이든 )
// 어떤 것 & 1 <<3
//select [t,f,t,f,...] index 별로 2개의 값을 가지므로 숫자의 bit구조로 대체시킬수 있다.
// bit 표현이 0,1 두개값

public class SubSet_Param_BinaryCounting {

	static int[] src = {1,2,3,4,5};
	public static void main(String[] args) {
		int subsetCnt = 1 << src.length;
		
		for (int i = 0; i < subsetCnt; i++) { // 0~부분집합의 총수 - 1까지
			// i가 bit 마스크가 된다.
			//j는 src의 인덱스
			
			for (int j = 0; j < src.length; j++) {
				if((i & 1 << j) !=0) System.out.print(src[j]+" "); //모든 경우의 수를 나타내는 i를 가지고 부분 집합을 구한다.
			}	
			System.out.println();
			
		}


	}
	static void subset(int srcIdx, int mask) {  // mask 값에 따라 선택하거나 말거나 한다.
		if(srcIdx == src.length) {// 기저조건
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
