package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_�����̰�������ִ�����_2961_binarycounting {

	static int N;
	static boolean[] select;
	static int [][] src;
	static int min; //
	public static void main(String[] args) throws Exception {

		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(b.readLine());
		min = Integer.MAX_VALUE;
		src = new int[N][2];
		int mask=0;
		
		StringTokenizer st;
		for(int test_case = 0; test_case <N;test_case++) {
			
			st = new StringTokenizer(b.readLine());
			src[test_case][0] = Integer.parseInt(st.nextToken());
			src[test_case][1] = Integer.parseInt(st.nextToken());
			
		}
		
		int subsetCnt = 1 << src.length;
		
		for(int i=1;i<subsetCnt;i++) {// ��� �ϳ��� ����ϹǷ� 1���� �����Ѵ�.
			int sin =1;
			int ssn=0;
			int cnt=0;
			
			// int �� ��Ʈ�� �ڸ��� ��ü�� ������ �ִ� => long
			// ����ġ�Ⱑ �ȵȴ�. 
			
			for (int ij = 0; ij < N; ij++) {
				if((i & 1 << ij) != 0) { // �̸�
				sin *= src[ij][0];
				ssn += src[ij][1];
				cnt++;
				}
			}
			min = Math.min(min, Math.abs(sin-ssn));
		}
		System.out.println(min);
	}
	static void subset(int index,int mask) {
		
		if(index == N ) {
			int sin =1;
			int ssn=0;
			int cnt=0;
			
			for (int i = 0; i < N; i++) {
				if(select[i]) {
				sin *= src[i][0];
				ssn += src[i][1];
				cnt++;
				}
			}
			if(cnt >0) {
				min = Math.min(min, Math.abs(sin-ssn));
				
			}

			return;
		}
		
		subset(index+1,mask | 1 << index);
		subset(index+1,mask);
		
		
	}


}
