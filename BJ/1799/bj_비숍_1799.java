package algo.wk11;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_���_1799 {
//������ �ִ� �ִ� ����� ũ��
	static int map[][];
	static int N;
	static int maxs=0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i=0;i<N;i++) { //1�� �Ѽ� �ִ� ��
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//��� ��츦 ���� �ִ밪�� ���Ѵ�.
		//�밢���� �˻��Ѵ�.
		dfs(0,0,0);

	}
	static void dfs(int r, int c,int num) {
		
		while(true) {
			if(map[r][c] == 1) {
				//1 �̸� 0���� ����� �밢���鵵 0���� ����� ������ ����
				check(r,c);//�밢�� üũ
				dfs(r,c,num+1);
				uncheck(r,c);//�밢�� üũ����
			}
			//0�̸� 1�� ���ö����� ã�´�.
			//���� ������ �ִ밪�̸� �����Ѵ�.
			c++;
			if(c == N) {r++;c=0;}
			if(r == N) {
				maxs = maxs < num? num:maxs;
				return;
			}


			
		}
		
		
	}
	static void check(int r, int c) {
		//�ڽŰ� �밢���� üũ�Ѵ�.
		map[r][c] =0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] == 1) {
					map[i][j]=2;
				}
			}
		}
	}

}
