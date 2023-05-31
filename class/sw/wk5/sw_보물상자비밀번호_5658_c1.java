package sw.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class sw_보물상자비밀번호_5658_c1 {

	static int N,K;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			
			st = new StringTokenizer(br.readLine());
			N =Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); //k번째자리 숫자
			
			list.clear();
			String hexNums = br.readLine();
			
			int oneSize = N/4;
//제시된 문제 처럼 풀이
	
			for(int i=0;i<oneSize;i++) {
				int start = 0;
				int end = oneSize;
				for(int j=0;j<4;j++) {
					String hex =hexNums.substring(start,end); 
					int num = Integer.parseInt(hex,16); //16진수에서 변환한다.
					if(!list.contains(num)) list.add(num);
					start =end;
					end += oneSize; //한 면만큼 이동
				}
				// 한바퀴를 돌았다.
				//한글자를 이동시켜준다.
				char c = hexNums.charAt(N-1);//마지막글자를 맨앞으로 이동시킨다.
				hexNums = c+hexNums.substring(0,N-1);
			}
			
			Collections.sort(list);
		
			System.out.println("#"+test+" "+list.get(list.size()-K));
			


		
		}

	}

}
