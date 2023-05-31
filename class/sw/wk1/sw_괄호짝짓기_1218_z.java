package sw.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class sw_°ýÈ£Â¦Áþ±â_1218_z {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // for¹® ¹Ù±ùÂÊ¿¡¼­ »ý¼º
		for(int test_case =1;test_case <=10;test_case++) {
			String str1 = br.readLine();
			//System.out.println(str1);
			int T = Integer.parseInt(str1);
			
			
			String str = br.readLine();
			int out =1;

			Stack<Character> stack =new Stack<>();
			for(int i=0;i<T;i++) {
				char now = str.charAt(i);
				
				if(now == '{' ||now == '[' ||now == '(' ||now == '<' ) { 
					stack.push(now);
				}
				
				else {
					if(stack.isEmpty()) {out=0;break;}
					char now2 = stack.pop();
					
		
					switch(now) {
					case ')':
						if('(' !=now2) {out =0;}
						break;
					case '}':
						if('{' !=now2) {out =0;}
						break;
					case ']':
						if('[' !=now2) {out =0;}
						break;
					case '>':
						if('<' !=now2) {out =0;}
						break;
					}
					if(out == 0) {break;}
					
				}

			}
			System.out.println("#"+test_case+" "+out);
			
		}
		
		
		
	}

}
