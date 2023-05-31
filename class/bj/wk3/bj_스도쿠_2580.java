package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//blank에따로 저장해줘서 0이 많으면 안된다.
public class bj_스도쿠_2580 {
	// 작은 사각형, 세로,가로 의 조건을 만족
	//한가지의 경우만 출력한다

	// 0인 위치에 모든 가능한 수를 따진다
	//후보중에 하나를 선택한다.
	// 1. 가장 숫자가 많이 채워진 곳의 숫자부터 결정한다. -> 후보가 한개인 것부터 결정한다.
	//다른것이 결정되면 나머지의 후보도 변경된다.
	// 2.
	static int N=9;
	static int [][] arr = new int [N][N];
	static int [][] blank;
	static int len;
	static StringBuilder sb = new StringBuilder();
	static boolean complete = false;
	public static void main(String[] args) throws Exception {
		StringTokenizer st;

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

	    len=0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				arr[i][j] =  Integer.parseInt(st.nextToken());
				if(arr[i][j] ==0)len++;
			}
		}
		blank = new int[len][2];
		int index=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] ==0) {
					blank[index][0] =i;
					blank[index][1] =j;
					index++;
				}
			}
		}
		// 해당위치를 매순간 임의로 결정, 모두돌면 위치에 저장하고 끝낸다. 
		
		find(0);
		System.out.println(sb);

	}
	static void find(int index) {
		if(complete)return;
		if(index == len) {
			complete = true;
			//여기서 값을 출력
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					sb.append(arr[i][j]).append(" ");
				}
				sb.append("\n");
			}
			return;
		}
		boolean [] lst = new boolean [N+1]; //0은 버린다.
		
		int r = blank[index][0];
		int c = blank[index][1];
		
		//격자의 후보 제외, 현재 상태에서 후보 확인
		grid(r,c,lst);
		for(int i=0;i<N;i++) {
			if(arr[r][i] !=0) { lst[arr[r][i]] =true;} //후보에서 제외
			if(arr[i][c] !=0) lst[arr[i][c]] =true; //후보에서 제외
			
		}
		
		for(int i=1;i<=N;i++) {
			if(lst[i] == false) {//후보에 있다면 임시로 그값으로 본다
				 arr[blank[index][0]][blank[index][1]] = i;
				 find(index+1); // 다음 blank로간다.
				 arr[blank[index][0]][blank[index][1]] = 0; //찾지 못한경우 다시 돌린다.
			}
		}
		
	}
	static void grid(int r,int c,boolean [] lst) { //////////sdfsdfsdf
		
		
		r = (r/3)*3;
		c = (c/3)*3;
		
		
		for(int i =r;i<(r+3);i++) {
			for(int j =c;j<(c+3);j++) {
				lst[arr[i][j]] =true;
			}
		}
		

		
		
	}

}
