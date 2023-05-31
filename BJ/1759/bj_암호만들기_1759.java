package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_암호만들기_1759 {

	static char [] arr;
	static int L;
	static int C;
	static char [] select;
	static StringBuilder sb;
	public static void main(String[] args) throws Exception  {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(b.readLine());
		
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		select = new char[L];
		arr = new char[C];
		
		int [] alph = new int[26]; 
		st = new StringTokenizer(b.readLine());
		for(int i=0;i<C;i++) {
			alph[(st.nextToken().charAt(0)-'a')]=1;
		}
		int index=0;
		for(int i=0;i<26;i++) {
			if(alph[i] == 1) arr[index++] = (char) ((char)i+'a');
		}
		//정렬
		
		//System.out.println(Arrays.toString(arr));
		
		// C중에서 C-L개를 뽑는 조합
		comb(0,0);
		System.out.print(sb);


	}
	static void comb(int start,int index) {
		if(index == L) {
			int c=0;
			for(int i=0;i<L;i++) {
				char a=select[i];
				if(a =='i' ||a =='o'||a =='e'||a =='a'||a =='u' ) {c+=1;}
			}
			if(c==0 || (L-c) <2 )return ;
			for(int i=0;i<L;i++) {
				sb.append(select[i]);
			}
			sb.append("\n");
			return;
		}
		for(int i=start;i<C;i++) {
			char a=arr[i];
			select[index]=a;
			//if(a =='i' ||a =='o'||a =='e'||a =='a'||a =='u' ) {count+=1;}
			comb(i+1,index+1);
			//if(a =='i' ||a =='o'||a =='e'||a =='a'||a =='u' ) {count-=1;}
			
		}
	}

}
