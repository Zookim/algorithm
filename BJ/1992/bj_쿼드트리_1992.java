package algo.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_쿼드트리_1992 {
	//1 2
	//3 4
	//오늘과제는 내일제출
	static int arr[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr =  new int [N][N];
		for (int i = 0; i < N; i++) {
			String a[] = br.readLine().split("");
			for(int j=0;j<N;j++) {
				arr[i][j] = Integer.parseInt(a[j]);
				
		
			}
		}
		
		zip(N,0,0);
		System.out.println(sb);

	}
	static void zip(int size,int r,int c) {
		// 현재 범위에서 모든 값이 1또는 0인지 확인한다
		// 모두 같은값이면 해당 값을 반환, 아니면 다시 분할한다(괄호열고), 분할이 끝날때 괄호를 닫는다
		//왼쪽위가 시작할때 괄호를 열고, 오른쪽아래가 끝날때 괄호를 닫는다.
		
		int sum=0;
		for(int i=r;i<r+size;i++) {
			for(int j=c;j<c+size;j++) {
				sum += arr[i][j];
			}
			
		}
		if(sum == size*size) {
			sb.append(1);

			return;
		}
		else if(sum == 0) {
			sb.append(0);
	
			return;
		}
		else {
			sb.append("(");
			int half = size/2;
			zip(half,r,c);
			zip(half,r,c+half);
			zip(half,r+half,c);
			zip(half,r+half,c+half);
			sb.append(")");
			
		}
		
	}

}