package sw.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw_원재의메모리복구하기_1290_2 {

	static int T,count;
	static char[] input, memory;


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++) {
			count =0;
			input = br.readLine().toCharArray(); 
			int cnt = input.length;
			
			memory = new char[cnt];
			for(int i=0;i<cnt;i++) {
				
				memory[i] ='0';
			}
			//입력 완료
			

			for(int i=0;i<cnt;i++) {
				if(memory[i] != input[i]) {//다르면 바꾸어준다.
					for(int j =i;j<cnt;j++) { // 진짜로 바꾸는 과정
						memory[j] = input[i];

					}
					count++;
				}
			}
			System.out.println(count);
		}
		
		br.close();
		


	}


}
