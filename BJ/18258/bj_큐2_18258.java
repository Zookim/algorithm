package algogo.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_ť2_18258 {

	static int que[] = new int[2000000];
	static int back =-1;
	static int front =-1;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int test=0;test<N;test++) {
			String str[] = br.readLine().split(" ");
			
			if(str[0].equals("push")) {
				que[++back] = Integer.parseInt(str[1]); 
			}else if(str[0].equals("pop")) {
				if(front == back ) {
					sb.append(-1).append("\n");
				}else {
					sb.append(que[++front]).append("\n");
				}
			}else if(str[0].equals("size")) {
				sb.append(back - front).append("\n");
			}else if(str[0].equals("empty")) {
				if(back - front == 0) {
					sb.append(1).append("\n");
				}else {
					sb.append(0).append("\n");
				}
			}else if(str[0].equals("front")) {
				if(back - front == 0) {
					sb.append(-1).append("\n");
				}else {
					sb.append(que[front+1]).append("\n");
				}
				
			}else if(str[0].equals("back")) {
				if(back - front == 0) {
					sb.append(-1).append("\n");
				}else {
					sb.append(que[back]).append("\n");
				}
				
			}
			
		}
		System.out.print(sb);
		

	}

}
