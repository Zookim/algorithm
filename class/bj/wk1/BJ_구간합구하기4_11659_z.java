package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;





public class BJ_�����ձ��ϱ�4_11659_z {
	static int [] n_arr;

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] N_M = br.readLine().split(" ");
		int N = Integer.parseInt(N_M[0]);
		int M = Integer.parseInt(N_M[1]);
		StringTokenizer sb = new StringTokenizer(br.readLine());
		n_arr = new int[N+1]; // ���Ŀ� ó������ ���Ұ�� 0�� �̿��ؾ��Ѵ�.
		
		//n_arr[0] = Integer.parseInt(sb.nextToken());
		for(int i=1;i<=N;i++) {
			n_arr[i] = Integer.parseInt(sb.nextToken()) + n_arr[i-1]; //�������� �־�д�.
		}
		//System.out.println(Arrays.toString(n_arr));
		String [][] M_arr = new String[M][2];
		for(int i=0;i<M;i++) {
			M_arr[i] = br.readLine().split(" ");
			int start = Integer.parseInt(M_arr[i][0]);
			int end = Integer.parseInt(M_arr[i][1]);
			int sum = n_arr[end] - n_arr[start-1];
//			for(int j=(start-1);j<end;j++) {
//				sum += n_arr[j];
//			}
			System.out.println(sum);
		}
		

	}

}
