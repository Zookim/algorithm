package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_����ã��_4396 {

	static char[][] res;
	static char[][] map1;
	static char[][] map2;
	
	static int dr[] = {-1,1,0,0,-1,-1,1,1};//���� �¿� 
	static int dc[] = {0,0,-1,1,-1,1,-1,1};
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); 
		
		res = new char[N][N];
		map1 = new char[N][N];
		map2 = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map1[i][j] = str.charAt(j);
			}
		}

		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				map2[i][j] = str.charAt(j);
			}
		}
		
//		for(char[] res2 : map2) {
//			System.out.println(Arrays.toString(res2));
//			
//		}
		//�Է�
		boolean check = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map2[i][j] == 'x') {// ���������߿�
					//System.out.println(i+" "+j);
					//�ڽ��� �������� Ȯ���Ѵ�.
					if(map1[i][j] == '*') {
						res[i][j] = '*';
						check = true;
						continue;
					}
					//�ֺ� ������ ���� ����
					
					int count=0;
					for(int k=0;k<8;k++) {
						int r = i + dr[k];
						int c = j + dc[k];
						
						if(r < 0 || c< 0|| r >= N || c>= N) continue;
						//�������� �ְ�
						//���ڶ�� �׼��� ����.
						if(map1[r][c] == '.') continue;
						count++;
					}
					//���� �ֺ��� ���ڰ� ���ٸ� �ֺ��ֵ鵵 ������Ѵ�.
					if(count == 0 ) {
						res[i][j] = '0';
						//�ֺ��� �͵��� x�� �ƴ� �͵��� ����.
//						for(int k=0;k<8;k++) {
//							int r = i + dr[k];
//							int c = j + dc[k];
//							
//							if(r < 0 || c< 0|| r >= N || c>= N) continue;
//							if(map1[r][c] == '.') continue;
//							count++;
//						}
						
					}else {//���ڰ� �ִٸ� �ִ´�.
						res[i][j] = (char)(count+'0');
						//System.out.println(count);
					}
					
					
				}
				else {
					res[i][j] = '.';
				}
			}
		}
		
		//���ڸ� ��Ҵٸ�
		if(check) {
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(map1[i][j] == '*') {
						res[i][j] = '*';
					}
				}
			}
		}
		
		
		for(char[] res2 : res) {
			for(char a: res2) {
				System.out.print(a);				
			}
			System.out.println();
		}
		
		

	}

}
