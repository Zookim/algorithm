package sw.wk1;

import java.util.Scanner;

public class sw_�����Ǹ޸𸮺����ϱ�_1289 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();
		
		for(int t=1;t<=T;t++) {
			int count =0;
			String str = sc.nextLine();
			int cnt = str.length();
			int[] inputArray = new int[cnt];
			int[] memArray = new int[cnt];
			
			for(int i=0;i<cnt;i++) {
				inputArray[i] = str.charAt(i) - 48;
			}
			
			for(int i=0;i<cnt;i++) {
				if(memArray[i] != inputArray[i]) {//�ٸ��� �ٲپ��ش�.
					for(int j =i;j<cnt;j++) { // ��¥�� �ٲٴ� ����
						memArray[j] = inputArray[i];
						
					}
					count++;
				}
			}
			System.out.println(count);
		}
		
		sc.close();
		
	}
}