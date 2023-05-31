package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_배열돌리기1_16926_z {
	// ���� ���� ¦���̴�.
	static int N; 
	static int M; 
	static int R; 
	static int[][] arr;
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		int count =0;
		for(int i =0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0;j<M;j++) {
				
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//�Է� �Ϸ�
		
		for(int i =0;i<N;i++) {
			for(int j =0;j<M;j++) {
				count = Math.min(Math.min(i-0, N-1-i),Math.min(j-0,M-1-j)); //
				sb.append(out(i,j,count)).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		
	}
	//0,0,/ N-1,0,/ N-1,M-1,/0,M-1 �̸� ���� �̵�
	// �׾��� �͵���
	
	static int out(int r,int c, int count) { // �ݴ� ������ �ش���ġ
		for(int i=0; i<R; i++) {
			if (r == 0+count & (c !=(M-1-count))) { // �������� �̵�
				c++; 
				//if(c >= M) {c--; r--;}
			}
			else if(c==(M-1-count) & (r != (N-1-count))) { // �Ʒ��� �̵�
				r++;
				//if(r >= N) {r--;c--;}
			}
			else if(r==(N-1-count) & (c != 0+count)) {
				c--;
				//if(c<0) {c++;r++;}
			}
			else if(c==0+count & (r !=0+count)) {
				r--;
				//if(r<0) {c++;r++;}
			}
		}
		return arr[r][c];
		
	}

}
