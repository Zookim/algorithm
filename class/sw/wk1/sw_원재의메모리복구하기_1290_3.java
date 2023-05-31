package sw.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;


//Scanner => BufferedReader
//local =>static
public class sw_원재의메모리복구하기_1290_3 {

	static int T,count;
	static char[] input;


	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T=Integer.parseInt(br.readLine());

		for(int t=1;t<=T;t++) {
			count =0;
			input = br.readLine().toCharArray(); 
			int cnt = input.length;
			
	
			//입력 완료
			char current ='0';
			for(int i=0;i<cnt;i++) {
				if(input[i] != current) count++;
				current = input[i];
			}
			System.out.println(count);
		}
		
		br.close();
		
		
		


	}


}
