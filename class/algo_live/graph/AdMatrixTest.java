package algo_live.graph;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdMatrixTest {

	static int adMatrix[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v=sc.nextInt();
		int e=sc.nextInt();
		
		adMatrix = new int [v][v]; //모두 0올 초기화

		int from, to;
		for (int i = 0; i <e; i++) {
			from = sc.nextInt();
			to = sc.nextInt();
			
			//무방향 그래프
			adMatrix[to][from] = adMatrix[from][to] = 1;
			//방향그래프시 , 한쪽에만 적어준다
			//adMatrix[from][to] = 1;
		
		}
		print();
	}
	static void print() {
		for(int [] a: adMatrix) {
			System.out.println(Arrays.toString(a));
		}
	}

}
