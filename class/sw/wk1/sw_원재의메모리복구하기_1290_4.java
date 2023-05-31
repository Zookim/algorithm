package sw.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//재귀 호출
public class sw_원재의메모리복구하기_1290_4 {

	static int T,count;
	static char[] input;


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++) {
			count =0;
			input = br.readLine().toCharArray(); 
			int cnt = input.length;
			
	
			//입력 완료
			char current ='0';
			next(cnt,0,current);
			System.out.println(count);
		}
		
		br.close();
		
		
		
//        sc.nextLine();
//	
//		for(int test_case = 1; test_case <= T; test_case++)
//		{
//			String str = sc.nextLine();
//            strs(str,0);
//		}

	}
//	static void next(String in,int n) {
//		if(n == in.length())return;
//		
//		if(in.charAt(n) == pre) {
//			
//		}
//		strs(in,n+1);
//
//	}
	static void next(int cnt,int idx, char current) {
		//기저 조건
		if(idx == cnt)return;
		char ch = input[idx];
		if(ch != current) count++;
		
		next(cnt,idx+1,ch);
	}

}
