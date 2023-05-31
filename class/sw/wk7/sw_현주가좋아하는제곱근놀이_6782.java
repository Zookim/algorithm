package sw.wk7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class sw_현주가좋아하는제곱근놀이_6782 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb =new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case=1;test_case<=T;test_case++) {
			long res=0;
			long n = Long.parseLong(br.readLine());
			
			
			while(n >2) {
				
				double root = Math.sqrt(n);
				long rootn = (int)root;
				//System.out.println(root);
				//System.out.println((double)rootn);

				if(root == (double)rootn) {
					res++;
					n = rootn;

				}else {
					long a = (rootn+1)*(rootn+1);
					res += a-n;
					n = a;

				}
				
			}
			sb.append("#").append(test_case).append(" ").append(res).append("\n");

		}
		System.out.println(sb);

	}

}
