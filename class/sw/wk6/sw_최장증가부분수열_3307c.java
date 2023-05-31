package sw.wk6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_최장증가부분수열_3307c {

	static int memoi[];
	static int input[];
	static int T,N,len;
	//같은 lis값을 가지는 수라면 값이 작은 것이 더 긴 수열을 만드는것에 유리하다.
	
	//최장 증가수열을 길이1 (인덱스 0) 부터 2,3,4, ... 각길이를 만드는 가장 작은 수를 memoi에 관리
	//memoi[4] = 7의 의미는 input 배열 즁에서 길이 4를 만드는 가장작은 수가 7이다.
	
	// 1 3 2 5 4에서
	// 1 => memoi[0] = 1; 현재 0번째 길이를 가지는 최소값이 1이므로
	// 3 => memoi[1] = 3
	// 2 => memoi[1] = 2; 2가 3보다 작지만 뒤에 위치하므로 3과 같은 순서에 만 위치할 수 있다. 또 2,3중에서 2가 더작으므로 3은 버리고 2를가진다.
	
	
	//새로 필요한 기능은 3 => 1, 2=> 1을 만들아주는 무언가 필요 <= Arrays.binarySearch()
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			memoi = new int[N];
			input = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			
			for (int i = 0; i < N; i++) {
				input[i] = Integer.parseInt(st.nextToken());
			}
			
			//풀이
			len =0;
			for (int i = 0; i < N; i++) {
				int pos = Arrays.binarySearch(memoi, 0,len,input[i]);
				if(pos >= 0) continue; 
				
				//결과 값이 음수 이면
				pos = Math.abs(pos) -1;
				memoi[pos] = input[i];
				
				if(len == pos) {
					len++; //pos값이 증가하면 이진 탐색해야할 범위가 증가하기 때문에
				}	
			}
			System.out.println("#"+test_case+" "+ len);
			//
		}
	}
}
