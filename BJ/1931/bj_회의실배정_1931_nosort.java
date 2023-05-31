package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_회의실배정_1931_nosort {
//k원을 만드는데 필요한 동전의 최소 수
	//아직안됨
	static int [][] arr;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int small=Integer.MAX_VALUE;
		int next=0;
		
		arr = new int[N][2];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			if(arr[i][1] < small) {
				small =arr[i][1];
				next=i;
			}
		}
		
		//Arrays.sort(arr,(n1,n2) ->{ return n1[1]==n2[1] ?n1[0]-n2[0] :n1[1] - n2[1];});
		
		int count =1;
		int next2=next;

		while(true) {
			int end = Integer.MAX_VALUE; //각 
			for(int i=0;i<N;i++) {
				if(i==next || i == next2) continue;
				if(arr[i][0] >= small ) { //시작시간이 크거나 같으면
					
					if(arr[i][1] <= end) { //그중 끝나는 시간이 제일 짧은 것을 선택
						next2 =i;
						end = arr[i][1];
					}
					
				}
				
			}
			if(next != next2) {
				count++;
				next = next2;
				small = arr[next][0];
			}
			else {break;}
		}
		
		System.out.println(count);
		
	}

}
