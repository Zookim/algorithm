package algo_live.combination;

import java.util.Arrays;
import java.util.Scanner;

public class Ex_DiceTest {

	
	static int N; //던지는 주사위 수
	static int [] numbers; //각각 주사위의 눈
	static int totalCnt;
	static boolean [] select;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int mode  = sc.nextInt();
		N = sc.nextInt();
		
		numbers = new int[N];
		select = new boolean[7]; // 0번을 쓰지 않는다.
		
		switch(mode) {
		case 1: //중복 순열
			dice1(0); //아직 0회쨰
			break;
		case 2: //순열
			dice2(0); //아직 0회쨰
			break;
		case 3: //중복조합
			dice3(0,1); //아직 0회쨰, 1부터 시작
			break;
		case 4: //조합
			dice4(0,1); //아직 0회쨰, 1부터 시작
			break;
		}
		System.out.println("totalCnt " + totalCnt);

	}
	
	private static void dice1(int cnt) { // cnt: 기존까지 던져진 주사위 수, 즉 지금 몇번째 자리인지 인덱스
		
		if(cnt == N) { // N회 던졌다면 형재 경우의 수를 출력하고 종료
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		
		for(int i=1; i<=6;i++) {
			numbers[cnt] = i; // 기록하고
			//다음 주사위를 던지러 간다.
			dice1(cnt+1);
		}

		
	}

	private static void dice2(int cnt) { // cnt: 기존까지 던져진 주사위 수, 즉 지금 몇번째 자리인지 인덱스

		if(cnt == N) { // N회 던졌다면 형재 경우의 수를 출력하고 종료
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}

		for(int i=1; i<=6;i++) {
			if(select[i]) continue;
			numbers[cnt] = i; // 기록하고
			select[i] = true;
			//다음 주사위를 던지러 간다.
			dice2(cnt+1);
			select[i] = false;
		}

	}
	private static void dice3(int cnt,int start) { // cnt: 기존까지 던져진 주사위 수, 즉 지금 몇번째 자리인지 인덱스

		if(cnt == N) { // N회 던졌다면 형재 경우의 수를 출력하고 종료
			System.out.println(Arrays.toString(numbers));
			totalCnt++;
			return;
		}
		for(int i=start; i<=6;i++) { // i가 시작하는 위치가 중요, 자기자신을 포함하면 중복 조합
			numbers[cnt] = i;  //허용하지 않으면 일반 조합, 순서가 중요하지 않으므로, 
			dice3(cnt+1,i); //

		}

	}
	private static void dice4(int cnt,int start) { // cnt: 기존까지 던져진 주사위 수, 즉 지금 몇번째 자리인지 인덱스

		if(cnt == N) { // N회 던졌다면 형재 경우의 수를 출력하고 종료
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
