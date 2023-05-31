package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;



public class sw_�丮��_4012 {

	static int arr [][];
	static int N;
	static int min;
	static int [] ans;
	static boolean [] select;
	static int count;
	static int arrA[];
	static int arrB[];
	
	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine()); //������ ���ϰ� , �� ������ �� �������� �ó����� �ּҰ��� ���Ѵ�.
			select = new boolean [N];
			arr = new int[N][N];
			arrA = new int[N/2];
			arrB = new int[N/2];
			
			
			
			StringTokenizer st;
			for(int i=0;i<N;i++ ){
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken());
				arr[i][1] = Integer.parseInt(st.nextToken());
				arr[i][2] = Integer.parseInt(st.nextToken());
				arr[i][3] = Integer.parseInt(st.nextToken());
			}
			ans = new int[N/2];
			min = Integer.MAX_VALUE;
			//System.out.println(N);
			comb(0,0);
			
			
		}
		
	}
	static void comb(int index,int start) {
		count++;
		if(index == N/2) { // ������ �ϼ��Ǹ� �ó����� ���ϰ�, �ּҰ��� ���Ѵ�.
			check();
			System.out.println(Arrays.toString(select));
			//int A_sin = arr[ans[0]][ans[1]] + arr[ans[1]][ans[0]];
			
			return;
		}

		for(int i = start;i<N;i++) { // ������ ���õȰ� �������� ����, 
			select[i] = true;
			comb(index+1,i+1);
			select[i] = false;

		}
		
	}
	static void check() {
		int indexa=0;
		int indexb=0;
		for(int i=0;i<N;i++) {
			if(select[i]) {arrA[indexa++] = i;}
			arrB[indexb++] = i;
		}
		int sumA =0;
		int sumB =0;
		
		for(int i=0;i<indexa;i++) {
			for(int j=0;j<indexa;j++) {
				if(i==j)continue;
				sumA += arr[arrA[i]][arrA[i]];
				sumB += arr[arrB[i]][arrB[i]];
			}
		}
		min = Math.min(min,Math.abs(sumA-sumB));
		
		
	}

}
