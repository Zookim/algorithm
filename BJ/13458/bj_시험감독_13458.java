package swtest;
// !!!
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_시험감독_13458 {

	static int N;
	static long ap[];
	
	static long adv;
	static long adv2;
	static long total_adv;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine()); //시험장의 수
		ap = new long[N];
		//total_adv = N;// 총감독관은 무조건 한면씩 있다.
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			ap[i] =Long.parseLong(st.nextToken()); //시험장별 인원
		}
		st = new StringTokenizer(br.readLine());
		adv =Long.parseLong(st.nextToken()); //총감독관
		adv2 =Long.parseLong(st.nextToken()); //부 감독관
		
		//입력
		
		for (int i = 0; i < N; i++) {
			total_adv++;
			//부감독의 필요유무를 따진다.
			long n = (ap[i] - adv);
			if(n>0) {
				total_adv += n/adv2;
				if(n%adv2 > 0) { //
					total_adv++;
				}
			}
		}
		System.out.println(total_adv);
		
	}

}
