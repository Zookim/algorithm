package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//blank에따로 저장해줘서 0이 많으면 안된다.
public class bj_스도쿠_2580_z2 {
	// 작은 사각형, 세로,가로 의 조건을 만족
	//한가지의 경우만 출력한다

	// 0인 위치에 모든 가능한 수를 따진다
	//후보중에 하나를 선택한다.
	// 1. 가장 숫자가 많이 채워진 곳의 숫자부터 결정한다. -> 후보가 한개인 것부터 결정한다.
	//다른것이 결정되면 나머지의 후보도 변경된다.
	// 2.
	static int N=9;
	static int [][] arr = new int [N][N];
	//static int [][] blank;
	static int len;
	static StringBuilder sb = new StringBuilder();
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
		
		// 해당위치를 매순간 임의로 결정, 모두돌면 위치에 저장하고 끝낸다. 
		
		find(0);
		System.out.println(sb);

	}
	static void find(int index) {
		if(index == len) {
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
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if (arr[i][j] ==0) {
					//후보를 골라낸다.
					grid(i,j,lst);
					for(int k=0;k<N;k++) {
						if(arr[i][k] !=0) { lst[arr[i][k]] =true;} //후보에서 제외
						if(arr[k][j] !=0) lst[arr[k][j]] =true; //후보에서 제외
						
					}
					//\\
					for(int k=1;k<=N;k++) {
						if(lst[k] == false) {//후보에 있다면 임시로 그값으로 본다
							 arr[i][j] = k;
							 find(index+1); // 다음 blank로간다.
							 arr[i][j] = 0; //찾지 못한경우 다시 돌린다.
						}
					}
					
					
					
				}
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
