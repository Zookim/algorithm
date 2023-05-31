package sw.wk1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class sw_암호생성기_1225_z {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		Deque<Integer> ad =new ArrayDeque<>();
		ad.clear();
		int n = 0;
		String ifNull = br.readLine();
		while( ifNull != null ) {
			ad.clear();
			int T = Integer.parseInt(ifNull);
			//
			st = new StringTokenizer(br.readLine());
			
			for(int i=0;i<8;i++) {
				ad.addLast(Integer.parseInt(st.nextToken())); 
			}
			//System.out.print(ad);
			
			int a=0;
			while(true) {
				a = (a+1) % 6;
				if(a==0) {a=1;}
				
				int now = ad.poll(); //앞자리를 출력
				now -= a;
				if(now <0) {now=0;}
				ad.addLast(now);
				if(now == 0) {break;}
				
			}
			
			System.out.print("#"+(n+1)+" ");
			for(int num : ad) {
				System.out.print(num+" ");
			}
			System.out.println();
			n++;
			
			ifNull = br.readLine();
		}
		

	}

}
