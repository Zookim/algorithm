package algo_live.permu;

import java.util.Arrays;
// total 중에 N개를 뽑는 순열
public class TESt2 {

	public static void main(String[] args) {
		
		perm(N);
		System.out.println(count);
		

	}
	static int N=3; //total 중에서 몇개의 자릿수를 뽑을 것인지
	static int [] total = {11,12,13,14,15}; // 이중에서 N개를 뽑는다.
	
	static int [] numbers = new int [N];
	static boolean [] isSelected = new boolean[total.length];
	static int count =0;
	
	

	static void perm(int n){
		//System.out.println(n);
		if(n==0){
			System.out.println(Arrays.toString(numbers));
			count++;
			return;} //기저조건
		else{
			for(int i=0;i<total.length;i++){ // 현 위치의 값을 고른다.
				if(isSelected[i] == true) continue;// 이전에 중복되는 값이 있는지 확인, 있으면 다른값 선택
				numbers[n-1] = total[i];
				isSelected[i] = true; //i는 지금 사용한다.
				perm(n-1); // 다음 자릿값으로 이동한다
				isSelected[i] = false;
				// 시도가 모두 끝나면 이전에 호출된 상태로 돌아간다.
				//돌아가기전에 현재 변경한 값(isSelected)을 다시 되돌려 준다. 
			}
		}
	}

}
