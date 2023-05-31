package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
//안됨
public class bj_색종이붙이기_17136_2 {

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
	
	//백트래킹시 size가  변경되어야한다
	
	static void find(int sizej) {
		if(sizej == 0) return;
		
		for(int size=5;size>=1;size--) {
			//
			for(int i=0;i<10;i++) {
				for(int j=0;j<10;j++) {
					if(map[i][j] == 1) {
						if(check(i,j,size)) {
							paper[size]--;
							count++;
							change(i,j,size);
						}
					}
				}
			}
			find(size-1);
			//
		}
		

		
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
