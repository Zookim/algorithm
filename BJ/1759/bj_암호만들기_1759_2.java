package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_암호만들기_1759_2 {


	static int L,C;
	static String arr[];
	static StringBuilder ans = new StringBuilder();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		arr = br.readLine().split(" ");

		Arrays.sort(arr);
		//Arrays.sort(arr,(n1,n2)-> n2.compareTo(n1)); //역순

	
		
	
		comb(0,0,0);
		System.out.println(ans);


		
	}

	static void comb(int start,int index,int count) {
		
		if(index == L) {
			if(count >= 1 && (L-count) >= 2) {
				ans.append(sb).append("\n");
			}
			//sb.setLength(0);
			return;
		}
		
		for(int i=start;i<C;i++) {
			sb.append(arr[i]);
			if(arr[i].equals("a") || arr[i].equals("i") ||arr[i].equals("o") 
					||arr[i].equals("u") ||arr[i].equals("e") ) {
				comb(i+1,index+1,count+1);
				}else {
					comb(i+1,index+1,count);	
				}
			sb.setLength(sb.length()-1);
		}
	}
	


}
