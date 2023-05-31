package algo_live.combination;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_DiceTest {

	
	static int N; //������ �ֻ��� ��
	static int [] numbers; //���� �ֻ����� ��
	static int totalCnt;
	static boolean [] select;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int mode  = sc.nextInt();
		N = sc.nextInt();
		
		numbers = new int[N];
		select = new boolean[7]; // 0���� ���� �ʴ´�.
		
		switch(mode) {
		case 1: //�ߺ� ����
			dice1(0); //���� 0ȸ��
			break;
		case 2: //����
			dice2(0); //���� 0ȸ��
			break;
		case 3: //�ߺ�����
			dice3(0,1); //���� 0ȸ��, 1���� ����
			break;
		case 4: //����
			dice4(0,1); //���� 0ȸ��, 1���� ����
			break;
		}
		System.out.println("totalCnt " + totalCnt);

	}
	
	private static void dice1(int cnt) { // cnt: �������� ������ �ֻ��� ��, �� ���� ���° �ڸ����� �ε���
		
		if(cnt == N) { // Nȸ �����ٸ� ���� ����� ���� ����ϰ� ����
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		for(int i=1; i<=6;i++) {
			numbers[cnt] = i; // ����ϰ�
			//���� �ֻ����� ������ ����.
			dice1(cnt+1);
		}

		
	}

	private static void dice2(int cnt) { // cnt: �������� ������ �ֻ��� ��, �� ���� ���° �ڸ����� �ε���

		if(cnt == N) { // Nȸ �����ٸ� ���� ����� ���� ����ϰ� ����
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}

		for(int i=1; i<=6;i++) {
			if(select[i]) continue;
			numbers[cnt] = i; // ����ϰ�
			select[i] = true;
			//���� �ֻ����� ������ ����.
			dice2(cnt+1);
			select[i] = false;
		}

	}
	private static void dice3(int cnt,int start) { // cnt: �������� ������ �ֻ��� ��, �� ���� ���° �ڸ����� �ε���

		if(cnt == N) { // Nȸ �����ٸ� ���� ����� ���� ����ϰ� ����
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		for(int i=start; i<=6;i++) { // i�� �����ϴ� ��ġ�� �߿�, �ڱ��ڽ��� �����ϸ� �ߺ� ����
			numbers[cnt] = i;  //������� ������ �Ϲ� ����, ������ �߿����� �����Ƿ�, 
			dice3(cnt+1,i); //

		}

	}
	private static void dice4(int cnt,int start) { // cnt: �������� ������ �ֻ��� ��, �� ���� ���° �ڸ����� �ε���

		if(cnt == N) { // Nȸ �����ٸ� ���� ����� ���� ����ϰ� ����
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		for(int i=start; i<=6;i++) {
			numbers[cnt] = i; 
			dice4(cnt+1,i+1);

		}

	}

}
