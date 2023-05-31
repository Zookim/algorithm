package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_DNA_12891 {
	
	static int S,P,ans;
	static char [] dna;
	static int minA, minC, minG,minT; //배열로 주지 않는이유는
	
	//빈도수
	// A B C D E F G H I J K L M N O P Q R S T
	
	static int[] cnt = new int[20];
	
	public static void main(String[] args) throws Exception {
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(b.readLine());
		S= Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		dna = b.readLine().toCharArray();
		
		st = new StringTokenizer(b.readLine());
		minA= Integer.parseInt(st.nextToken());
		minC= Integer.parseInt(st.nextToken());
		minG= Integer.parseInt(st.nextToken());
		minT= Integer.parseInt(st.nextToken());
		
		solve();

		System.out.println(ans);
		
		
		
	}
	static void solve() {
		// 최초P의 길이만큼 조사 => 각각 A,C,G,T가 몇개 나왔는지 cnt배열에 기록
		//위 첫번째경우에 대해 확인
		for(int i=0;i<P;i++) { cnt[dna[i] -'A']++;}
		check();
		//이후 index를 한개씩 늘려가면서 이전 부분 문자열의 맨앞의 버리는 문자를 확인 처리, 새로얻는 문자를 확인 처리
		//경우의 수에 대해서 조건에 맞는지 확인 맞으면 ans증가
		for(int i=P;i<S;i++) { 
			cnt[dna[i-P] -'A']--;
			cnt[dna[i] -'A']++;
			check();
			}
		}
	static void check() {
		
		if(cnt[0] >= minA && cnt[2] >= minC && cnt[6] >= minG && cnt[19] >= minT ) {
			ans++;
		}

	}

	
}
