package basic.wk1;


// 파라미터로 select 배열 =>  bitmask
// bit 연산자  : &,|, <<
//어떤 것 | 1 <<3 => 어떤 것의 3번째 비트를 1로 바꾼다.(원래 1 이든 0이든 )
// 어떤 것 & 1 <<3
//select [t,f,t,f,...] index 별로 2개의 값을 가지므로 숫자의 bit구조로 대체시킬수 있다.
// bit 표현이 0,1 두개값

public class SubSet_Param_BitMask {

	static int[] src = {1,2,3,4,5};
	static int COUNT;
	
	
	public static void main(String[] args) {
		//boolean[] select = new boolean[src.length];
		//위의 select는 처음에 모두 false
		//동일하게 bitMask 두 각자리의 bit가 모두 0인길로 시작 =>0
		System.out.println(Integer.toBinaryString(22));
		subset(0,0);
		System.out.println("COUNT " + COUNT);
//		System.out.println(2 | 5 );
//		System.out.println(2 & 5 );
//		System.out.println(1 << 3 );
//		System.out.println(5 & 5 );

	}
	static void subset(int srcIdx, int mask) {  // mask 값에 따라 선택하거나 말거나 한다.
		if(srcIdx == src.length) {// 기저조건
		printSubset(mask);
		COUNT++;
		return;
		}
		
		// 현재 srcIdx의 원소를 선택혹은 2가지 경우로 재귀호출을 이어간다.
		// 선택이란 select 배열의 srcIdx를true
		// 비선택이란 select 배열의 srcIdx를 false

	//	select[srcIdx] = true;

		subset(srcIdx +1,mask | 1 << srcIdx); // 넘겨받은 mask 에 srcIdx 번째 bit를 1로 변경
		
	//	select[srcIdx] = false; 
		subset(srcIdx +1,mask); // 넘겨받은 mask의 	변화 x
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
