package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_규영이와인영이의카드게임_6808 {
/*규영이가 내는 경우의 수 인영이의 경우*/
	//static int[] array;
	static int T,win,lose,N=9;
	static int[] input = new int[19];
	
	static int[] guCard=new int[9];
	static int[] inCard=new int[9];
	static int[] tgt = new int[9];
	
	static boolean[] select = new boolean[N];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());		
		for(int test_case=1;test_case<=T;test_case++) {
			
			win=0;lose=0;
			Arrays.fill(input, 0);

			st = new StringTokenizer(br.readLine());
			
			int num=0;
			for(int i=0;i<N;i++) {
				num = Integer.parseInt(st.nextToken());
				input[num] =1;
				guCard[i] = num;
			}
			
			
			num=0;
			for(int i=1;i<=18;i++) {
				if(input[i] == 0) inCard[num++] = i;
			}
			//순열 1.
			perm1(0);
			System.out.println("#"+test_case+" "+win+" "+lose);

		}

	}
	static void perm1(int index) {
		if(index == N) {
			check();
			return;
		}
		for(int i=0; i<N;i++) {
			if(select[i]) continue;

			tgt[index] = inCard[i];
			select[i] = true;
			perm1(index+1);
			select[i] = false;
		}
	}


	static void check() {
		int guSum = 0;
		int inSum = 0;
		for(int i=0;i<N;i++) {
			if(guCard[i] > tgt[i]) guSum += guCard[i] + tgt[i];
			else inSum +=guCard[i] + tgt[i]; //

		}
		if(guSum > inSum) win++;
		else if(guSum < inSum)lose++;

	}

	

}
