package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_2048_12100_memo {
	// 더이상 같은 수가 없으면 합쳐지지 않는다, 1개 밖에 없어도 합쳐지지 않는다.(인접하지 않아도 합쳐지지 않는다.)
	// 행,열을 같게한다 , 각 숫자는 한턴에선 한번만 합쳐질 수 있다.
	static int N;
	static int arr[][];
	static int Max;
	static int reset[][][];
	public static void main(String[] args) throws Exception{
		//5번 이동후 최대값을 출력하도록한다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int [N][N];
		reset = new int[6][N][N]; //직전 배열을 저장한다.
		StringTokenizer st;

		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++) {
				int n = Integer.parseInt(st.nextToken());
				reset[0][i][j] =n;
			}
		}

		perm(0);
		System.out.println(Max);


	}
	static void perm(int index) {
		if(index == 5) {
			//여기서 최대값을 구한다.
			int res = 0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(res < reset[index][i][j]) {
						res = reset[index][i][j];
					}
				}
			}
			if(res > Max) {
				Max = res;
			}
			return;
		}
		for(int i=1;i<=4;i++) {
			moves(i,index); //여기서 계산하고
			perm(index+1);
		}
	}

	static int moves(int move,int index) {
		//배열 초기화 필요
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				arr[i][j] = reset[index][i][j];
			}
		}
		switch(move) {
		case 1:
			up();
			break;
		case 2:
			down();
			break;
		case 3:
			right();
			break;
		case 4:
			left();
			break;
		}

		//배열 저장
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				reset[index+1][i][j] = arr[i][j];
			}
		}
		
		int min=0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] > min) {min = arr[i][j];}
			}
		}
		return min;
		
		
	}
	static void right() { //<-
		for(int r=0;r<N;r++) {
			int pre = N-1; //얘
			for(int c=N-1;c>=0;c--) { //얘
				int now=arr[r][c];				
				if(now != 0) {
					for(int i=pre;i>c;i--) {//얘
						int pre_node = arr[r][i];
						if(pre_node == 0) {
							arr[r][i] = now; 
							arr[r][c] =0; 
							pre = i;
							break;
						}
						else if(pre_node == now){
							arr[r][i] += now;
							arr[r][c]=0; 
							pre = i-1;//얘
							break;
						}
						
						if(i == c+1) { //얘
							pre = c; 
						}
					}					
				}
			}
		}
	}
	static void left() { //<-
		for(int r=0;r<N;r++) {
			int pre = 0; //얘
			for(int c=0;c<N;c++) { //얘
				int now=arr[r][c];				
				if(now != 0) {
					for(int i=pre;i<c;i++) {//얘
						int pre_node = arr[r][i];
						if(pre_node == 0) {
							arr[r][i] = now; 
							arr[r][c] =0; 
							pre = i;
							break;
						}
						else if(pre_node == now){
							arr[r][i] += now;
							arr[r][c]=0; 
							pre = i+1;//얘
							break;
						}
						
						if(i == c-1) { //얘
							pre = c; 
						}
					}					
				}
			}
		}
	}
	static void up() {
		for(int c=0;c<N;c++) {
			int pre = 0; //얘
			for(int r=0;r<N;r++) { //얘
				int now=arr[r][c];				
				if(now != 0) {
					for(int i=pre;i<r;i++) {//얘
						int pre_node = arr[i][c];
						if(pre_node == 0) {
							arr[i][c] = now; 
							arr[r][c] =0; 
							pre = i;
							break;
						}
						else if(pre_node == now){
							arr[i][c] += now;
							arr[r][c]=0; 
							pre = i+1;//얘
							break;
						}
						
						if(i == r-1) { //얘
							pre = r; 
						}
					}					
				}
			}
		}
	}
	static void down() {
		for(int c=0;c<N;c++) {
			int pre = N-1;
			for(int r=N-1;r>=0;r--) {
				int now=arr[r][c];
				if(now != 0) {// 0이아닌 수를 찾으면 이동시킨다.
					for(int i=pre;i>r;i--) {//자신의 앞만 검사
						
						int pre_node = arr[i][c];
						if(pre_node == 0) {
							arr[i][c] = now; 
							arr[r][c] =0; //원본 수정
							pre = i;
							break;
						}
						else if(pre_node == now){
							arr[i][c] += now;
							arr[r][c]=0; //얘는 원본을 수정
							pre = i-1;//한번 더해진값은 고려되지 않도록한다.
							break;
						}
						if(i == r+1) { //이동하지 못한경우
							pre = r; //현재위치부터 고려
						}
					}
				}
			}
		}
	}
}
