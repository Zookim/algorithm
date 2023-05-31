package algo.wk6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_나무높이_14510 {

	static int arr[];
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1; test_case<=T;test_case++) {
			
			int N = Integer.parseInt(br.readLine());
			arr = new int[N];
			st = new StringTokenizer(br.readLine());
			int len=0;
			for (int i = 0; i <N; i++) {
				int a= Integer.parseInt(st.nextToken());
				arr[i] =a;
				if(a> len) {
					len = a;
				}
			}
			
			//
			int count=0;
			int even=0;
			int odd=0;
			
			for (int i = 0; i <N; i++) {
				int a= len - arr[i];
				even += a/2;
				odd += a%2;
			}
			while(true) {
				if(even-odd>1) {
					even-- ;
					odd += 2;
				}else if(odd-even>1){
					even++ ;
					odd -= 2;
				}else {
					break;
				}
			}
			
			if(even >= odd ) {
				System.out.println("#"+test_case+" "+even*2);
			}else {
				System.out.println("#"+test_case+" "+(even*2+1));
			}
			
			
			
		}

	}

}
