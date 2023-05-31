package sw.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_원점으로집합_8458 {
	static int N,max;
	static int dis[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		StringBuilder sb =  new StringBuilder();
		for(int test_case=1;test_case<=T;test_case++) {
			N = Integer.parseInt(br.readLine());
			dis = new int[N];
			max=0;
			for(int i=0;i<N;i++) {
				st =  new StringTokenizer(br.readLine());
				
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				
				 int a= Math.abs(n) +  Math.abs(m);
				 dis[i] = a;
				 if(a>max) {max =a;} 

			}
			
			//입력 끝
			if(check()) {
				
				int num=0;// 각 턴까지의 누적이동수
				int index = 0;
				
				while(true) {
					num +=index;
					if(max <= num) { // max를 포함하는 첫 인덱스를 구한다.
						if((num - max)%2==0) {//짝수 이면 이번 턴에서 도착
							sb.append("#").append(test_case).append(" ").append(index).append("\n");
							break;
						}else {//다음턴에서 도착
							num+=index+1;
							if((num - max)%2==0) {
								sb.append("#").append(test_case).append(" ").append(index+1).append("\n");
								break;
							}else {
								sb.append("#").append(test_case).append(" ").append(index+2).append("\n");
								break;
							}
							
						}
					}
					index++;
				}
				
				
			}else {//실패한경우
				sb.append("#").append(test_case).append(" ").append(-1).append("\n");
			}
			
			
			
			
			
		}//test_case
		System.out.println(sb);
	
	}
	static boolean check() {
		boolean f=true;
		for(int i=0;i<N;i++) { //만날수는 있는지 확인
			if((max - dis[i])%2 != 0) return false;
		}
		return true;
	}

}
