package basic.wk1;

import java.util.Arrays;

//순열
//이미 사용된 index를 재사용하지 않기 위해 별도의 자료구조 : select

public class Perm {

	static int[] src = {1,2,3,4,5};
	static int tgt[] = new int[3];
	static int COUNT;
	static boolean[] select = new boolean[src.length];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 0 <- 자리수를 의미, 맨앞에서 부터 시작
		// 0 <- tgt의 자릿수
		// tgt의 첫번째 자리부터 채워나가겠다.
		
		perm2(0);
		System.out.println(COUNT); //전체 경우의 수
		
		

	}
	//tgtIdx의 자리에 수하나를 선택하고 계속 다음 tgt 를 채워나가겠다.
	// 재귀 호출 구조이므로 기저조건 필요
	
	static void perm(int tgtIdx) {
		
		//기저조건: 0->1->2->3; 3이면 완료
		if(tgtIdx == tgt.length) {
			//complete code
			//경우의 수중 한가지가 완성된 상태
			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}
		
		// 자기 자리에 어떤 자리를 넣을지 결정하고 
		//다음자리수를 위해 자신을 다시호출한다.
		//다시 귀환하기위해 현재 상태를 풀준다.
		for(int i=0; i< src.length;i++) { //현재 자리에 올수 있는 수들
			//이미 사용된 수는 제외
			if(select[i]) continue;
			//selcet[i] 가 false이므로 아직 사용되지 않은 수 이다.
			tgt[tgtIdx] = src[i];
			select[i] = true;
			
			perm(tgtIdx+1); // 다음 자리수를 고르러간다
			//끝까지 가면 하나의 순열이 완성된다.
			// 귀환후 다시 다음 순열을 고려하므로
			// 아직for문이 끝나지 않았을 때, select를 해제하여
			// 다음 순열완성되도록한다.
			select[i] = false;
			
			
		}
		
		

	}
	static void perm2(int tgtIdx) { //중복을 허용하는 경우


		if(tgtIdx == tgt.length) {

			System.out.println(Arrays.toString(tgt));
			COUNT++;
			return;
		}


		for(int i=0; i< src.length;i++) { //현재 자리에 올수 있는 수들
			//이미 사용된 수는 제외
	
			//selcet[i] 가 false이므로 아직 사용되지 않은 수 이다.
			tgt[tgtIdx] = src[i];
	

			perm2(tgtIdx+1); // 다음 자리수를 고르러간다
			//끝까지 가면 하나의 순열이 완성된다.
			// 귀환후 다시 다음 순열을 고려하므로
			// 아직for문이 끝나지 않았을 때, select를 해제하여
			// 다음 순열완성되도록한다.



		}



	}

}
