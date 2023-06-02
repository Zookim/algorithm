package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_히스토그램_1725 {

	static int N,M,K;
	static int [] histogram;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine()); 

		histogram = new int[N+2];
		histogram[0] = 0;
		histogram[N+1] =0;
		
		int maxs=0;
		stack.push(0);
		for(int i=1;i<=N;i++) {
			// 초기 값을 세팅한다.
			histogram[i] = Integer.parseInt(br.readLine()); //높이를 저장
			
			while(!stack.isEmpty() && histogram[stack.peek()] > histogram[i]) { 
				//현재 들어오는 값이 직전 값보다 작다면 pop하면서 최너 너비를 구한다.
				int index = stack.pop();
				int now = (histogram[index]*(i-stack.peek()-1));
				//(현재 제외 - stack에 최상위값이 가진 index직전까지가 이 최대값이 유지되는 기간이므로)
				maxs = (maxs > now )?maxs:now;
				System.out.println(now);
			}
			stack.push(i);
			
			
			
		}
		
		while(!stack.isEmpty() && histogram[stack.peek()] > histogram[N+1]) { 
			//현재 들어오는 값이 직전 값보다 작다면 pop하면서 최너 너비를 구한다.
			int index = stack.pop();
			int now = (histogram[index]*((N+1)-stack.peek()-1));
			//(현재 제외 - stack에 최상위값이 가진 index직전까지가 이 최대값이 유지되는 기간이므로)
			maxs = (maxs > now )?maxs:now;
			//System.out.println(now);
		}
		
		System.out.println(maxs);
	
		
		
	}

}
