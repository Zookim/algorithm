package algo.wk6;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//모르겠는데...
public class bj_백조의호수_3197 {

	//k만큼만
	static String [][] arr;
	static int R,C;

	static int[][] Loc= new int[2][2];
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new String[R][C];

		int loc=0;
		for(int i=0;i<R;i++) {
			arr[i] = br.readLine().split("");
			for(int j=0;j<C;j++) {
				if(arr[i][j].equals("L")) {
					Loc[loc][0] = i;
					Loc[loc][1] = j;
					loc++;
				}
			}
		}
		
		
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				if(arr[i][j].equals("X")) {
					int min=Integer.MAX_VALUE;
					for(int k=0;k<4;k++) {
						int row = i+dr[k];
						int col = j+dc[k];
						if(row >=0 && row < R && col >=0 && col < C) {
							String s = arr[row][col];
							if(s.equals(".")) {
								arr[i][j]= "1";
								break;
							}else {
								int a=Integer.parseInt(s);
								min = min < a ? min :a;
							}
							
						}
						arr[i][j] = Integer.toString(min);
					}
				}
			}
		}


		
		

		
		

	}
	
	

}
