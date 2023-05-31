package algogo.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_¼è¸·´ë±â_10799 {

	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split("");
		int totalpiece = 0;
		int num=0;
		
		String pre=str[0];
		if(pre.equals("(")) {
			num=1;
		}
		String now="";
		for(int i=1;i<str.length;i++) {
			now = str[i];
			if(now.equals(")")) {
				//System.out.println(str[i]);
				if( pre.equals("(")) {
					num--;
					totalpiece += num;					
				}else {
					totalpiece +=1;
					num--;
				}
			}else {
				num++;
			}
			pre = now;
		}
		System.out.println(totalpiece);
		
	}

}
