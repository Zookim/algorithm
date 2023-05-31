package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_DNA_12891 {
	
	static int S,P,ans;
	static char [] dna;
	static int minA, minC, minG,minT; //�迭�� ���� �ʴ�������
	
	//�󵵼�
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
		// ����P�� ���̸�ŭ ���� => ���� A,C,G,T�� � ���Դ��� cnt�迭�� ���
		//�� ù��°��쿡 ���� Ȯ��
		for(int i=0;i<P;i++) { cnt[dna[i] -'A']++;}
		check();
		//���� index�� �Ѱ��� �÷����鼭 ���� �κ� ���ڿ��� �Ǿ��� ������ ���ڸ� Ȯ�� ó��, ���ξ�� ���ڸ� Ȯ�� ó��
		//����� ���� ���ؼ� ���ǿ� �´��� Ȯ�� ������ ans����
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
