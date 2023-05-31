package basic.wk6;

import java.util.Arrays;

//접두사, 접미사가 일치하는지지 대칭하는지가 아니다.
// a      0
// ab     0
// aba    1
// abaab  2
// ababab 2
// abaaba 3
// ababa  3

public class KMP_PI {

	public static void main(String[] args) {
		String pattern = "abcbcacbc"; //"abacaaba"abcdabcaba
		// 위 패턴 문자열로 검색 대상이 되는 텍스트들을 검색하다가 불일치하는 경우, 다시 검색을 해야하는데
		//대상이 되는 텍스트는 index를 뒤로 이동하지 않고 
		//패턴의 index를 조정해서 다시 검색을 진행한다.
		// 이를 위해 검색실패시 이동할 위치 결정에 참조할 배열 PI를 만든다.
		System.out.println(Arrays.toString(getPI(pattern)));
	}
	static int[] getPI(String p) {
		int[] pi =  new int[p.length()]; //0으로 초기화
		char [] pArray = p.toCharArray(); //문자열을 char배열로
		
		int j=0;//패턴의 앞에서 부터 움직이는 index
		for (int i = 1; i < pArray.length; i++) { // i는 패턴 index: 텍스트 처럼 계속 증가하는 형태
			//i는 1부터 시작해야한다.
			
			// 패턴에서 j번째 까지 비교해서 실패하면 바로 이전 pi[j-1]로 돌아가서, 그 위치부터 다시 검토한다.
			//while문을 벗어나려면 j ==0 또는 두 비교값이 같을 경우 
			while( j > 0 && pArray[j] != pArray[i]) j = pi[j-1];
			// 같지 않다면 같은 것을 찾을때까지, 되돌아간다. -> 되돌아가는 방법은 pi[j-1]이 2라면 2번째 자리로 가서
			// 그자리부터 일치하는지 다시 확인한다.
			if( pArray[j] == pArray[i] ) pi[i] = ++j;
		}
		
		return pi;
	}

}

// i == 1일때
//if( pArray[j] == pArray[i] ) pi[i] = ++j; 에서 같지 않으므로 그대로 0이다.

// i==2일때
//while( j > 0 && pArray[j] != pArray[i]) j = pi[j-1];
//같다 -> 
//if( pArray[j] == pArray[i] ) pi[i] = ++j;
// p[1]=1이 된다.

//i==3일때(j는 1인상태)
//"a(b:j)a(c:i)aaba" 다르므로
//while( j > 0 && pArray[j] != pArray[i]) j = pi[j-1];
//j = pi[j-1]를 통해 j값이 이전 값으로 되돌아간다.
// ... 계속 일치하는 것이 없다. -> pi[3]은 그냥 0으로 남는다.



