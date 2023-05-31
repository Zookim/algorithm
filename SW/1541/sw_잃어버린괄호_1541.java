package my.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class sw_잃어버린괄호_1541 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		String str = br.readLine();
		//String hex = hexNums.substring(i,i+oneSize);
		
		
		int start =0;
		int on=0;
		
		int sum=0;
		int index=1;
		while(start < str.length()) {
			if(index==str.length()||str.charAt(index) =='-' ||str.charAt(index) =='+' ) {
				if(on==1) {
				
					sum -=Integer.parseInt(str.substring(start,index));
				}else {

					sum +=Integer.parseInt(str.substring(start,index));
				}
				//System.out.println(sum);
				start = index+1;
			}
			if(index < str.length() &&str.charAt(index) == '-') {on=1;}

			index++;
			
		}
		

		System.out.println(sum);
	}

}
