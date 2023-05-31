package sw.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sw_보물상자비밀번호_5658 {

	static int N,K;
	static char ch[];
	
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test = 1; test <= T; test++) {
			PriorityQueue<Integer> que = new PriorityQueue<>((n1,n2)->n2-n1);
			st = new StringTokenizer(br.readLine());
			N =Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken()); //k번째자리 숫자
			
			ch = new char[N+(N/4-1)];
			char[] ch1 = br.readLine().toCharArray();
			
			for(int i=0;i<N;i++) {
				ch[i] = ch1[i];
			}
			for(int i=0;i<(N/4-1);i++) {
				ch[i+N] = ch1[i];
			}
			
			
			//System.out.println(Arrays.toString(ch));

			
			//N/4-1회 반복
			for(int j=0;j<(N/4);j++) {
				for(int i=j;i<N;i+=N/4) {
					//i는 시작위치
					int n = check(i);//각 자리수 반환
					//System.out.println("i "+i+" "+n);
					que.offer(n);
				}
			}
			
			//System.out.println(que.size());
			
			int pre=-1;
			int now=0;
			int index=1;
			while(index <= K && !que.isEmpty()) {
				now = que.poll();
				if(now != pre) {index++;}
				pre = now;
			}
			//System.out.println(index);
			System.out.println("#"+test+" "+now);
			


		
		}

	}
	static int check(int n) {
		int sum=0;
		int in=(N/4)-1;
		for(int i=0;i<(N/4) ;i++) {
			sum += tonum(ch[n+i]) * Math.pow(16,in--);
			//System.out.println(sum);
		}
		return sum;
		
	}
	static int tonum(char n) {
		int res;
//		switch(n) {
//		case
//		}
		if(n=='A') {
			res = 10;
		}else if(n=='B'){ res = 11;}
		else if(n=='C'){ res = 12;}
		else if(n=='D'){ res = 13;}
		else if(n=='E'){ res = 14;}
		else if(n=='F'){ res = 15;}
		else {res = n-'0';}
		return res;
	}

}
