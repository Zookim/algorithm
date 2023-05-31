package my.wk1.sw_1240;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw_1240 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int test_case=1;test_case <=T;test_case++) {
			String [] size = br.readLine().split(" ");
			
			

			int n = Integer.parseInt(size[0]);
			int m = Integer.parseInt(size[1]);
			int out =0;
			int ans[] = new int[8];
			String [] inarr = new String[n];

			
			for(int i=0;i<n;i++) {
				inarr[i] = br.readLine();
				//System.out.println(inarr[i]);
			}
			

			for(int i=0;i<n;i++) {
				String str = inarr[i];
				for(int j=0;j<m;j++) {
					if(str.charAt(j) == '1') {
						//
						//System.out.println(i +" "+j);
						j = find_value(str,j,ans,out)-1;
						//System.out.println("j " + j);
						out++;

					}
				}
				if(out ==8)break;
			}
			
			//System.out.println(Arrays.toString(ans));
			int sum = 0;
			int s1=0;
			int s2=0;
			for(int i=0;i<8;i++) {
				int a = ans[i];
				sum += a;
				if(i%2 ==0) { //È¦¼öÀÚ¸®
					s1+=a;
				}else {s2 += a;}
			}
			
			if((s1*3+s2)%10 ==0) {
				System.out.println("#"+test_case+" "+sum);
			}else {
				System.out.println("#"+test_case+" "+0);
			}
			
		}


		
	}
	static int find_value(String str,int index,int [] ans,int out) {
		int arr[] = new int[3];
		int tran = 0;


		while(tran < 3) {
			if(str.charAt(index) != str.charAt(index+1)) {
				//System.out.println(tran);
				tran++;
			}
			else {
				arr[tran]++;
			}
			index++;
		}


		ans[out] = values(arr);
		return index+1;

	}
	static int values(int [] arr) {
		int sum = arr[0]*9+arr[1]*3+arr[2];
		switch(sum) {
		case 9:
			return 0;
		case 12:
			return 1;
		case 4:
			return 2;
		case 27:
			return 3;
		case 7:
			return 4;
		case 15:
			return 5;
		case 3:
			return 6;
		case 19:
			return 7;
		case 11:
			return 8;
		case 1:
			return 9;
			
			
		}
		return -1;
		
	}

}
