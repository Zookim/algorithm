package algo_live.backtracking;

import java.util.Scanner;

public class NQueen {

	static int [] col;
	static int N,answer;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		col = new int[N+1];
		
		setQueen(1);
		System.out.println(answer);

	}
	private static void setQueen(int rowNo) {
		if(!isAvailable(rowNo-1)) return; //직전까지의 상태가 얼마나 유망한지
		if(rowNo>N) {
			answer +=1;
			return;
		}
		for(int c=1;c<=N;c++) {
			col[rowNo]=c;
			setQueen(rowNo+1);
		}
	}
	private static boolean isAvailable(int rowNo) {
		for (int i = 1; i < rowNo; i++) {
			if(col[i] == col[rowNo] || Math.abs(col[i]-col[rowNo]) == rowNo-i )return false;//열이 같으므로 유망하지않다, 
			
		}
		return true; //모두 조건을 만족한 경우
	}

}
