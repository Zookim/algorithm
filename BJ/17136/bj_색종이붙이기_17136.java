package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//안됨
public class bj_색종이붙이기_17136 {

	static int [] paper = {0,5,5,5,5,5}; //1 2 3 4 5
	static int [][] map = new int[10][10];
	static int count;
	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st ;

		for(int i=0;i<10;i++) {
			st =new StringTokenizer(br.readLine());
			for(int j=0;j<10;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		

		find(5);
		for(int i=1;i<=5;i++) {
			if(paper[i] < 0)
				count =-1;
		}

		System.out.println(count);

	}
	static void find(int size) {
		if(size == 0) return;
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<10;j++) {
				if(map[i][j] == 1) {
					boolean c =check(i,j,size);
					if(c) {//당장은 되도 장기적으론 안될 수 있다.
						paper[size]--;
						count++;
						change(i,j,size);
					}
				}
			}
		}
		//전부다 돈다
		find(size-1);
		
	}
	static boolean check(int r,int c,int size) {
		int row = r+size;
		int col = c+size;
		
		if((row-1) >= 10 || (col-1) >= 10) {
			return false;
		}
		
		for(int i=r;i<row;i++) {
			for(int j=c;j<col;j++) {
				
				if(map[i][j] == 0) {
					return false;
				}

			}
		}
		return true;
		
	}
	static void change(int r,int c,int size) {
		int row = r+size;
		int col = c+size;
		for(int i=r;i<row;i++) {
			for(int j=c;j<col;j++) {
				map[i][j] = 0;

			}
		}
	}
}
