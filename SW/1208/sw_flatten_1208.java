package algo.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class sw_flatten_1208 {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		
		for(int test_case = 1; test_case <=10;test_case++){ //
			int dump = Integer.parseInt(br.readLine())+1;
			int [] count= new int [101]; //첫자리 버린다
			
			 st = new StringTokenizer(br.readLine());
			 for(int i=0;i<100;i++) {
				 count[Integer.parseInt(st.nextToken())]++;
			 }
			 //System.out.println(Arrays.toString(count));

			 int maxindex =100;
			 int minindex =1;
			 while(dump > 0) {
				 if(count[maxindex] == 0 ) {
					 maxindex--;
				 }else {
					
					 count[maxindex]--;
					 count[maxindex-1]++;
					 while(true) {
						 if(count[minindex] == 0) {
							 minindex++;
						 }else {
							 count[minindex]--;
							 count[minindex+1]++;
							 break;
						 }
					 }
					 dump--;
					 //System.out.println("dump "+dump+" maxindex "+maxindex + " minindex "+minindex);
					 //System.out.println(Arrays.toString(count));
				 }
				 
				 if((maxindex == minindex) ||(maxindex - minindex) <=1) break;
			 }
			 
			 System.out.println(maxindex - minindex);

		}

	}

}
