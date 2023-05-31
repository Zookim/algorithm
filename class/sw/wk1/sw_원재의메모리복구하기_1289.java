package sw.wk1;

import java.util.Scanner;

public class sw_원재의메모리복구하기_1289 {

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
				if(memArray[i] != inputArray[i]) {//다르면 바꾸어준다.
					for(int j =i;j<cnt;j++) { // 진짜로 바꾸는 과정
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