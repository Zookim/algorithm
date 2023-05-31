package sw.wk1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw_Flatten_1208 {
/*
 834
42 68 35 1 70 25 79 59 63 65 6 46 82 28 62 92 96 43 28 37 92 5 3 54 93 83 22 17 19 96 48 27 72 39 70 13 68 100 36 95 4 12 23 34 74 65 42 12 54 69 48 45 63 58 38 60 24 42 30 79 17 36 91 43 89 7 41 43 65 49 47 6 91 30 71 51 7 2 94 49 30 24 85 55 57 41 67 77 32 9 45 40 27 24 38 39 19 83 30 42 

  */
	public static void main(String[] args)throws Exception {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));

		for(int test_case=0;test_case<1;test_case++) {
			int dump = Integer.parseInt(b.readLine());
			//System.out.println();
			//System.out.println(dump);

			String arr [] =  b.readLine().split(" ");
			int counts [] = new int[101];
			
			//System.out.println(arr.length);
			for(int i=0;i<100;i++) {
				
				counts[Integer.parseInt(arr[i])]++;
			}
			//System.out.println(dump+" "+Arrays.toString(counts));
			
			
			
			int start =0;
			int end=100;
			
			int m_s=49;
			int m_e=50;
			int i=0;
			while(true) {
				i++;
				System.out.println(dump+" "+Arrays.toString(counts));
				
//				if(counts[m_s] >= 100) {
//					m_s--;
//				}
//				if(counts[m_e] >= 100) {
//					m_e++;
//				}
				if(counts[start] > 0) {
					counts[start]--;
					counts[m_s]++;
					dump--;
					if(dump == 0) {break;}
				}else {
					start++;
				}
				if(counts[end] > 0) {
					counts[end]--;
					counts[m_e]++;
					dump--;
					if(dump == 0) {break;}
				}
				else {
					end--;
				}
				
			}
			System.out.println(dump+" "+Arrays.toString(counts));
			boolean s =false;
			boolean e =false;
			for(int i1=0;i1<101;i1++) {
				if(counts[i1] >=1 && s == false) {start = i1; s = true;}
				if(counts[100 - i1] >=1 && e == false) {end = 100-i1; e = true;}
			}
			System.out.println(start + " "+ end);
			System.out.println(end-start);
		


			
			
			
		}



	}



	

}
