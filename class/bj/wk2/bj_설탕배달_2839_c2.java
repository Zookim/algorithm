package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_�������_2839_c2 {

	
	static int[] dp;
	public static void main(String[] args) throws Exception{
		//3,5 ...
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		int count=0;
		int N = Integer.parseInt(br.readLine());

		if(N <=5) {
			if(N==3|| N==5)System.out.println(1);
			else System.out.println(-1);
			return;
		}
		dp = new int[N+1];
		//������ �ּҷ� ���
		// N kg�� ������ �������� 3kg ���� �Ǵ� 5kg ������ ���
		// �� �� �ּ� ����� �������� �Ǵ��ؼ� ���
		Arrays.fill(dp,5000);
		
		dp[3] =1; //3kg�� ����ϴµ� 1������ ����ߴ�. 
		dp[5] =1; //5kg�� ����ϴµ� 1������ ����ߴ�.
		
		for(int i=6; i<= N;i++) {
			dp[i] = Math.min(dp[i-3]+1,dp[i-5]+1); //���� �� ���� ��������.
		}
		
		if(dp[N] > 5000) System.out.println(-1);
		else System.out.println(dp[N]);
	//	System.out.println(dp[N]);
	}

}
