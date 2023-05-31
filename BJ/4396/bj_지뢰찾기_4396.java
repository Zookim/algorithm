package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_지뢰찾기_4396 {

	static char[][] res;
	static char[][] map1;
	static char[][] map2;
	
	static int dr[] = {-1,1,0,0,-1,-1,1,1};//상하 좌우 
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
		//입력
		boolean check = false;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map2[i][j] == 'x') {// 눌러진것중에
					//System.out.println(i+" "+j);
					//자신이 지뢰인지 확인한다.
					if(map1[i][j] == '*') {
						res[i][j] = '*';
						check = true;
						continue;
					}
					//주변 지뢰의 수를 센다
					
					int count=0;
					for(int k=0;k<8;k++) {
						int r = i + dr[k];
						int c = j + dc[k];
						
						if(r < 0 || c< 0|| r >= N || c>= N) continue;
						//범위내에 있고
						//지뢰라면 그수를 센다.
						if(map1[r][c] == '.') continue;
						count++;
					}
					//만약 주변에 지뢰가 없다면 주변애들도 열어야한다.
					if(count == 0 ) {
						res[i][j] = '0';
						//주변의 것들중 x가 아닌 것들을 연다.
//						for(int k=0;k<8;k++) {
//							int r = i + dr[k];
//							int c = j + dc[k];
//							
//							if(r < 0 || c< 0|| r >= N || c>= N) continue;
//							if(map1[r][c] == '.') continue;
//							count++;
//						}
						
					}else {//지뢰가 있다면 넣는다.
						res[i][j] = (char)(count+'0');
						//System.out.println(count);
					}
					
					
				}
				else {
					res[i][j] = '.';
				}
			}
		}
		
		//지뢰를 밟았다면
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
