package my.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
// 1. Ʈ�� 2. �迭
public class sw_������ȸ_1231 {

	static String [][] arr;
	static StringBuilder sb;
	static int N;
	public static void main(String[] args) throws Exception{
		BufferedReader b= new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st;
		for(int test_case =1;test_case<=10;test_case++) { //
			N = Integer.parseInt(b.readLine());
			arr = new String[N+1][];
			sb = new StringBuilder();
			
			for(int i=1;i<=N;i++) {
				arr[i] = b.readLine().split(" ");
				//System.out.println(Arrays.toString(arr[i]));
			}
			
			dfs(1);
			System.out.print("#"+test_case+" ");
			System.out.println(sb);
				
			
		}	


	}
	static void dfs(int index) { // �ǵ��� ���鼭 ���
		if(index >= N+1) return;
		
		dfs(index*2);
		sb.append(arr[index][1]);
		dfs(index*2+1);
	}

}
