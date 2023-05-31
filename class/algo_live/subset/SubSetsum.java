package algo_live.subset;

import java.util.Scanner;

public class SubSetsum {
	static int[] input;
	static int totalCount;
	static int N;
	static boolean [] isSelected;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		input = new int[N];
		isSelected = new boolean[N];
		
		for (int i = 0; i < N; i++) {
			input[i] = sc.nextInt();
		}
		generateSubSet(0,0);
		System.out.println("totalCount "+totalCount);
	}
	private static void generateSubSet(int cnt, int sum) {
		totalCount++;
		if(cnt ==N) {
			for(int i=0;i<N;i++) {
				System.out.print((isSelected[i] ? input[i] : "X") + "\t");
			}
			
			System.out.println(sum);
			return;
		}

		//현재 원소를 부분 집합의 구성에 포함
		isSelected[cnt] = true;
		generateSubSet(cnt+1,sum+input[cnt]); //지금것이 선택되었기때문에

		//현재 원소를 부분 집합의 구성에 비포함
		isSelected[cnt] = false;
		generateSubSet(cnt+1,sum);


	}

}
