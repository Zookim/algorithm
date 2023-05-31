package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_규영이와인영이의카드게임_6808_z {
/*규영이가 내는 경우의 수는 정해져있다. 인영이의 경우*/
	//static int[] array;
	static int N=9; 
	static boolean [] total;
	static int win,lose;
	public static void main(String[] args) throws Exception {
		// 이기는 경우와 지는 경우의 수 BufferedReader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		int [] array = new int[9];
		int [] array2 = new int[9];
		
		for(int test_case=0;test_case<T;test_case++) {
			total = new boolean[N*2];
			win=0;lose=0;

			st = new StringTokenizer(br.readLine());
			for(int i=0;i<9;i++) {
				int a = Integer.parseInt(st.nextToken());
				array[i] = a;
				total[a-1] = true;
			}// 입력을 받아온다.
			
			int index=0;
			for(int i=0;i<18;i++) {
				if(!total[i]) array2[index++] = i+1;
			}
			
			while(true) { 
				int c = count(array,array2); //현재턴에서 이겼는지 졌는지 확인
				if(c > 0) {win++;}
				else if(c<0) {lose++;}

				if(!perm(array2)) break;
			}

			System.out.println(win + " "+lose);
		}


	}
	static int count(int[] a,int[] b) {
		int s_sum=0;
		int t_sum=0;

		for(int i=0;i<N;i++) {
			int aa = a[i];
			int bb= b[i];
			if(aa > bb) { //a이김
				s_sum+=bb+aa;
			}else if(bb>aa) { //a가 짐 //
				t_sum+=bb+aa;
			}
		}
		if(s_sum >t_sum) return 1;
		else if(s_sum<t_sum) return -1;
		else return 0;
		
	}
	
	static boolean perm(int[] arr) { 
		
		int i=N-1;
		while(i>0 && arr[i-1] >=arr[i]) i--;
		if(i==0) return false;
		
		int j = N-1;
		while(arr[i-1] >= arr[j]) j--;
		
		swap(i-1,j,arr);
		
		int k=N-1;
		if(i<k) {
			swap(i++,k--,arr);
		}
		
		return true;
	}
	static void swap(int i,int j,int[] arr) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

}
