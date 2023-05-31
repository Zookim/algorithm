package algo_live.KMP;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

// KMP 알고리즘(Knuth–Morris–Pratt Algorithm) 
// O(N+M)
/**
 * @author taeheekim
 */
public class String_KMPTest {
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		char[] text = in.readLine().toCharArray();
		char[] pattern = in.readLine().toCharArray();
		
		int tLength = text.length, pLength = pattern.length;
		
		// 부분일치테이블 만들기 : KMP의 아이디어를 똑같이 적용, W에서 W를 찾는 듯한 행위를 해서...
		int[] pi = new int[pLength];
	    for(int i=1, j=0; i<pLength; i++){// i:접미사 포인터(i=1부터 시작: 우리는 부분일치테이블를 만드는게 목적이므로 첫글자 틀리면 0위치로 가야하므로.), j:접두사 포인터
	        while(j > 0 && pattern[i] != pattern[j]) j = pi[j-1]; // 일치하지 않는다면 앞의 것을 참조한다.
	        
	        if(pattern[i] == pattern[j]) pi[i] = ++j;
	        else pi[i] = 0;
	    }
		
		int cnt = 0;
		ArrayList<Integer> list = new ArrayList<Integer>();
		// i : 텍스트 포인터 , j: 패턴 포인터 
		for(int i=0,j=0; i<tLength; ++i) { 
			
			while(j>0 && text[i] != pattern[j]) j = pi[j-1]; // 불일치하면 j의 값이 되돌아가는 것이 동일하다.
			
			if(text[i] == pattern[j]) { //두 글자 일치
				if(j == pLength-1) { // j가 패턴의 마지막 인덱스라면 -> 완전히 일치한다.
					cnt++; // 카운트 증가, 이두줄은 일치하는 문자열에 대한 정보를 나타낸다.
					list.add(i-j);  //일치하는 곳의 시작위치 반환
					j=pi[j]; // 마지막문자가 다음 첫문자와 일치할수도 있으므로 이렇게 넘겨준다.
				}else { 
					j++;
				}
			}
			
		}
		
		System.out.println(cnt);
		if(cnt>0) {
			System.out.println(list);
		}
	}
}