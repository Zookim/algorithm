package sw.wk1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class sw_암호생성기_1225 {

	
	static Queue<Integer> queue = new ArrayDeque<>();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		
		while(true) {
			String tc = br.readLine();
			if(tc == null || tc.length() == 0) break;
			
			queue.clear();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i <8; i++) {
				queue.offer(Integer.parseInt(st.nextToken()));
				
			}
			make();
			
			System.out.print("#"+tc+" ");
			for(int num : queue) {
				System.out.print(num+" ");
			}
			System.out.println();
			
		}


	}
	static void make() {
		
		int num =0;
		while(true) {
			for(int i=1;i<=5;i++) {
				num = queue.poll() - i; //꺼낸 수에서 i를 1~5로 증가해가며 빼준다.
				//0 이하인지 확인한다.
				
				if(num <=0) {
					queue.offer(0);
					return;
					
				}
				queue.offer(num);
			}
		}
	}

}
