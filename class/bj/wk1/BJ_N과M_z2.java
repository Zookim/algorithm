package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
// �Ѳ����� ���
public class BJ_N��M_z2 {
	
	static StringBuilder sb;

	public static void main(String[] args) throws Exception {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		String [] arr = b.readLine().split(" ");
		
		// N ���� M ��
		int [] ans = new int [Integer.parseInt(arr[1])];
		boolean select[] = new boolean[Integer.parseInt(arr[0])]; 
		sb = new StringBuilder();
		
		//1 3
		perm(Integer.parseInt(arr[1]),ans,Integer.parseInt(arr[0]),select);
		System.out.println(sb);
		
		
		
		
		

	}

	static void perm(int N, int [] ans,int M, boolean [] select) {
		//System.out.println(N);
		if(N ==0) {
			for (int an : ans) {
				sb.append(an).append(" ");
			}
			sb.append("\n");
			//System.out.println(Arrays.toString(ans));
			return;
			}
		else {
			
			for(int i=0;i<M;i++) {
				if(select[i])continue;
				ans[N-1] =i+1;
				select[i] = true;
				perm(N-1,ans,M,select);
				select[i] = false;
			}
			
		}
	}

}
