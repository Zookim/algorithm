package algo.wk5;
//근데 이 순서 안됨
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_암호만들기_1759 {


	static int L,C;
	static String arr[];
	static StringBuilder ans = new StringBuilder();
	static StringBuilder sb = new StringBuilder();
	static int input[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		//System.out.println(Arrays.toString(arr));
		arr = br.readLine().split(" ");

		//Arrays.sort(arr);
		Arrays.sort(arr,(n1,n2)-> n2.compareTo(n1)); //역순
		
		//System.out.println(Arrays.toString(arr));
		//1.모든 조합을 구한다
		//2.모음이 1개 이상,자음이 2개이상인지 확인한다.
		input = new int[C];
		for(int i=(C-L);i<C;i++) {
			input[i]=1;
		}//정렬해서 넣어준다.
		
		
		//System.out.println(Arrays.toString(input));
		while(true) {
			int count=0;
			for(int i=C-1;i>=0;i--) {
				if(input[i] == 0) continue;

				if(arr[i].equals("a") || arr[i].equals("i") ||arr[i].equals("o") 
						||arr[i].equals("u") ||arr[i].equals("e") ) {

					count++;}
				sb.append(arr[i]);
			}
			
			//System.out.println(sb);
			if(count >= 1 && (L-count) >= 2) {
				ans.append(sb).append("\n");
			}

			sb.setLength(0);

			if(!np(input)) break;
		}
		System.out.println(ans);


		
	}

	

	
	static boolean np(int[] arr) {
		int n = arr.length-1;
		int i = n;
		while(i > 0 && arr[i-1] >= arr[i]) {i--;}
		if(i==0) return false;
		
		int j=n;
		while(arr[j] <= arr[i-1]) {j--;}
		swap(i-1,j);
		
		int k=n;
		while(i<k) {swap(i++,k--);}
		
		return true;
		
	}
	static void swap(int i,int j) {
		
		int tmp =input[i];
		input[i] = input[j];
		input[j] = tmp;
	}

}
