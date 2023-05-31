package basic.wk2;

import java.util.Arrays;

public class Comb_NP {

	static int[] src ={1,2,3,4,5,6}; //조합으로 사용
	static int[] tgt = new int[3];
	static int[] index = new int[src.length];
	public static void main(String[] args) {
		// 0 0 0 1 1 1 -> 가장작은수
		// ...
		// 1 1 1 0 0 0 -> 가장큰수
		
		//tgt 수만큼 index 배열의 뒤쪽을 채운다.
		for (int i = src.length-1; i >= src.length - tgt.length; i--) {
			index[i] =1;
		}
		System.out.println(Arrays.toString(index));
		
		while(true) {
			int tgtindex =0;
			for (int i = 0; i < index.length; i++) {
				if(index[i] ==1){
					tgt[tgtindex++] = src[i];
				}
			}
			System.out.println(Arrays.toString(index)+ " "+ Arrays.toString(tgt));
			if(!np(index)) break;
		}


	}
	static boolean np(int[] array) { //true: 더 큰수를 만들 수 있다. false 더이상 큰수는 없다.
		int i = array.length-1;
		while(i > 0 && array[i-1] >= array[i])i--; //앞자리가 더 클때까지 이동
		if(i==0) return false;

		int j = array.length-1;
		while(array[i-1] >= array[j]) j--;

		swap(array,i-1,j);
		
		int k = array.length-1;
		if(i<k) {
			swap(array,i++,k--);
		}
		return true;
		

	}

	static void swap(int[] array,int i,int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] =temp;
	}

}
