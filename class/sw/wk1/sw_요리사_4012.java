package sw.wk1;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class sw_요리사_4012 {
static int N;
static int min = Integer.MAX_VALUE;;
static int [] now; 
//static int [][] all = new int[][N/2]; //
static int all_index=0;
	public static void main(String[] args) throws Exception {

		System.setIn(new FileInputStream("sample_input.txt"));
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder all = new StringBuilder();
		int min;
		
		int T = Integer.parseInt(b.readLine());
		
		for(int test_case =1;test_case<=1;test_case++) {//
			N = Integer.parseInt(b.readLine());
			String [][]arr = new String[N][N];
			now = new int[N/2]; 
			
			for(int i=0;i<N;i++) {
				arr[i] = b.readLine().split(" ");
			}
			
			 comb(0,0,all);
			 System.out.println(all);
			 StringTokenizer ;
			 // 음식 조합의 합과 차를 구하기 //대칭적으로 구해지므로
			 while()
			 min = Math.min(min,check())
			 
			 
			 
			 
		
		}

	}//N개중에서 2개만 뽑는다.
	static void comb(int index, int start,StringBuilder all) {
		
		if(index == N/2) {
			for(int a : now) {
				all.append(a);
			}
			all.append(" ");
			//System.out.println();
			return;
		}
		
		for(int i = start;i<N;i++) {
			//System.out.println("start " + start);
			//System.out.println("i " + i +"index "+index);
			//System.out.println(now.length);
			now[index] = i;
			
			//System.out.println("i " + i);
			comb(index+1,start+i+1,all);
			
			
		}
		
		
	}

}
