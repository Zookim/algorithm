package algo.wk5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class bj_차량번호판_16968 {

	//처음 값이 작아지는 동안 왼쪽 자손으로 입력한다.
	//값이 커지고, 루트보다 커질때까지 오른 자손으로 입력한다.
	//다시작아지면 왼자손, 커지면 오른자손
	static int arr[];
	static boolean visit[];
	static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br =  new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		N = str.length();
		int ans=0;
		int num=0;
		int total=1;
		for(int i=0;i<N;i++) {
			if(str.charAt(i) == 'd') {
				if(num ==0) {
					total *= 10;
				}else {
					total *= 9;
				}
				ans=0;
				num++;
				
			}else {
				if(ans ==0) {
					total *= 26;
				}else {
					total *= 25;
				}
				num=0;
				ans++;
			}
		}
		System.out.println(total);
		
		
		
	
			
	}

}
