package sw.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw_�����Ǹ޸𸮺����ϱ�_1290_2 {

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
			//�Է� �Ϸ�
			

			for(int i=0;i<cnt;i++) {
				if(memory[i] != input[i]) {//�ٸ��� �ٲپ��ش�.
					for(int j =i;j<cnt;j++) { // ��¥�� �ٲٴ� ����
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
