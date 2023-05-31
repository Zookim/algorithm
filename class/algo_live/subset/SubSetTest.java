package algo_live.subset;

import java.util.Scanner;

public class SubSetTest {
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
		generateSubSet(0);
		System.out.println("totalCount "+totalCount);

	}
	private static void generateSubSet(int cnt) {
		totalCount++;
		if(cnt ==N) {
			for(int i=0;i<N;i++) {
				System.out.print((isSelected[i] ? input[i] : "X") + "\t");
			}
			
			System.out.println();
			return;
		}

		//���� ���Ҹ� �κ� ������ ������ ����
		isSelected[cnt] = true;
		generateSubSet(cnt+1);

		//���� ���Ҹ� �κ� ������ ������ ������
		isSelected[cnt] = false;
		generateSubSet(cnt+1);


	}

}
