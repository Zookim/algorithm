package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_문자열집합_14425 {

	public static void main(String[] args) throws Exception {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(b.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		String arr[] = new String[N];
		for(int i=0;i<N;i++){
			arr[i] = b.readLine(); 
		}
		int count=0;
		for(int i=0;i<M;i++){
			String str = b.readLine(); 
			for(int j=0;j<N;j++) {
				if(arr[j].equals(str)) {// 부분 문자열도 포함
					//System.out.println(str);
					count++;
					break;

				}

			}
		}
		System.out.println(count);


	}
	static boolean same(String arr,String str) {
		//System.out.println(str);
		if(arr.equals(str)) {
			return true;
		}
		int len = arr.length();
		int strlen = str.length();
		
		for(int i=0;i<=(len-strlen);i++) {
			int n=0;
			for(int j=0;j<strlen;j++) {
				if(arr.charAt(i+j) !=str.charAt(j)) {
					n=1;
					break;
				}
			}
			if(n==0) return true;
		}
		return false;
		
	}

}
