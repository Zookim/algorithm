package sw.wk1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_�丮��_4012_1 {

	static int T, N, min;
	static int[][] map;
	static boolean [] select;
	static int[] arrA,arrB; //���� ���õ� ����� index
	
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(b.readLine());
		
		for(int t =1;t<=T;t++) {
			N = Integer.parseInt(b.readLine());
			map = new int [N][N];
			select = new boolean[N];
			
			arrA = new int[N/2];
			arrB = new int[N/2];
			
			//�ó���
			for(int i=0;i<N;i++) {
				StringTokenizer st = new StringTokenizer(b.readLine());
				for(int j=0;j<N;j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
				}
			}
			
			//Ǯ��
			min = Integer.MAX_VALUE;
			comb(0,0);
			System.out.println("#"+t+" "+min);
					
			
		}	
	}
	static void comb(int src,int tgt) {

		if(tgt ==N/2) {//����� �� �ϼ� �� select�迭�� ���� true. ���� false�λ���
			check();
			return;
		}
		if(src == N)return;
		
		select[src] =true;
		comb(src+1,tgt+1); //�� ������ �޾� ���̴� ��

		select[src] = false;// ������ �޾� ������ �ʾ����Ƿ� �ٽ� false�Ѵ�.
		comb(src+1,tgt);
	}
	
	static void check() {
		//�׷� A, �׷�B�� ������.
		//�� A�� A����, B�� B���� �ó��� ���
		//�� �׷��� �ó��� ���� ���̰� �ּڰ� ����
		int idxA = 0;
		int idxB =0;
		for (int i = 0; i < N; i++) {
			if(select[i])arrA[idxA++] = i; 
			else arrB[idxB++] = i;
		}
		//���� �ó����� ����Ѵ�.
		int sumA =0;
		int sumB=0;
		for (int i = 0; i < N/2; i++) {
			for (int j = 0; j < N/2; j++) {
				if(i==j)continue;
				sumA += map[arrA[i]][arrA[j]];
				sumB += map[arrB[i]][arrB[j]];
			}
		}
		min = Math.min(min,Math.abs(sumA-sumB));
		
	}

}
