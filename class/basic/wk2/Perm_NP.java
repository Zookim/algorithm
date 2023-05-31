package basic.wk2;

import java.util.Arrays;

public class Perm_NP {

	static int[] src = {3,1,5,4,2};
	public static void main(String[] args) {
		//np로 모든 경우의 수를 만들려면 반드시 정렬을 통해 대상을 정렬해 오름차순으로
		// 가장작은 수로 만들고 시작
		Arrays.sort(src);
		
		//np()를 호출하면 '두'번째 순열이 생긴다.(첫번째 순열이 아니다.)
		
		while(true) {
			//처음 들어오는 입력부터가 순열이므로 바로처리
			System.out.println(Arrays.toString(src));
			
			
			if(!np()) break;
		}

	}
	static boolean np() { //true: 더 큰수를 만들 수 있다. false 더이상 큰수는 없다.
		int i= src.length -1;
	
		while(i>0 && src[i-1] >=src[i]) --i; // 내림차수이면 계속 앞으로 이동
		if(i ==0) return false;//만약 맨앞이면 ,더이상 없다.
		
		int j = src.length -1;
		while(src[i-1] >= src[j]) j--;//
		swap(i-1,j); // 앞에서 바꿀 값과 뒤에서 바꿀값을 찾았다.
		
		int k = src.length -1;
		while(i < k) {
			swap(i++,k--); //중앙으로 오는 방향
		}
		return true;
	}
	
	static void swap(int i,int j) {
		int temp = src[i];
		src[i] = src[j];
		src[j] =temp;
	}

}
