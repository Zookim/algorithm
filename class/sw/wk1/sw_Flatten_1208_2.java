package sw.wk1;
// ����
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
//Sanner �̿� :  0.17341s
//
import java.util.Scanner;

public class sw_Flatten_1208_2 {
	static int[] floor;
	static int dump,minidx,maxidx;
	
	public static void main(String[] args)throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		
		for(int t =1; t<=10;t++) {
			
			dump  = sc.nextInt();
			floor = new int[100];
			
			for(int i=0;i<100;i++) {
				floor[i] = sc.nextInt();
			}
			// �ݺ������� dump��ŭ
			for(int i=0;i< dump;i++) {
				
				//�ּ�, �ִ� ���̸� ������ minidx, maxidx�� ���
				reset();
				//������ �ܰ��� ���� Ȯ�� - �������̸� break �ƴϸ� ��źȭ �۾� ���� maxIdx �ϳ� ���̰� minidx�ϳ� �ø���
				int gap = floor[maxidx] - floor[minidx];
				if(gap ==0 || gap ==1) break;
				
				floor[maxidx]--;
				floor[minidx]++;
				
				
			}
			reset();
			
			int res = floor[maxidx] - floor[minidx];
			System.out.println("#" + t +" "+ res);
		}

	}
	
	// floor �迭�� �ִ� �ּ� ���
	static void reset() {
		for(int i=0;i<100;i++) {
			//min
			if(floor[i] < floor[minidx]) minidx = i;
			if(floor[i] > floor[maxidx]) maxidx = i;
			
		}
		
		
	}


}
