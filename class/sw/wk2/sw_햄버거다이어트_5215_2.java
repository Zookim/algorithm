package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_�ܹ��Ŵ��̾�Ʈ_5215_2 {

	//Į�θ������� ����, ��ȣ�ϴ� ����
	//2���� �̻��� Ǯ��
	static int arr[][];
	static int N,L;
	static int max;
	static boolean select[];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			max=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //����Ǽ�
			L = Integer.parseInt(st.nextToken()); //Į�θ�
			select = new boolean[N];
			arr = new int[N][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); //��
				arr[i][1] = Integer.parseInt(st.nextToken()); //Į�θ�
			}
			//�κ� ���� 
			subSet(0);
			System.out.println("#"+test+" "+max);

		}
	} //���, for
	static void subSet(int index) { 
		if(index == N) {
			//System.out.println(mask);//mask�� �ٽ�
			cal();
			return;
		}
		select[index]=true;
		subSet(index+1);
		select[index]=false;
		subSet(index+1);
	}
	static void cal() {
		int tsum=0;
		int calsum=0;
		for(int i=0;i<N;i++) {
			if(select[i]) {
				calsum += arr[i][1];
				tsum += arr[i][0];
			}
		}
		
		//System.out.println(tsum);
		if(calsum <= L) {
			System.out.println("�� " +tsum+"Į�θ� "+calsum);
			max = (max > tsum) ? max:tsum;
		}
		
	}
	
}


