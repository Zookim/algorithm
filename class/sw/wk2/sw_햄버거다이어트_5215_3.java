package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_�ܹ��Ŵ��̾�Ʈ_5215_3 {

	//Į�θ������� ����, ��ȣ�ϴ� ����
	//2���� �̻��� Ǯ��
	static int arr[][];
	static int N,L;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			max=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //����Ǽ�
			L = Integer.parseInt(st.nextToken()); //Į�θ�
			arr = new int[N][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] = Integer.parseInt(st.nextToken()); //��
				arr[i][1] = Integer.parseInt(st.nextToken()); //Į�θ�
			}
			//�κ� ���� 
			subSet(0,0,0);
			System.out.println("#"+test+" "+max);

		}
	} //���, for
	static void subSet(int index,int calsum,int tsum) { 
		if(index == N) {
			System.out.println(tsum);
			max = (max > tsum) ? max:tsum;
			return;
		}
		
		if(calsum > L) {return;}
		
		subSet(index+1,calsum,tsum); //�������� �ʴ°��
		
		calsum += arr[index][1];
		tsum += arr[index][0];
		subSet(index+1,calsum,tsum);//����
		calsum -= arr[index][1];
		tsum -= arr[index][0];

	}
//	static void cal(int mask) {
//		int tsum=0;
//		int calsum=0;
//		for(int i=0;i<N;i++) {
//			if((mask &(1<<i)) !=0) {
//				calsum += arr[i][1];
//				tsum += arr[i][0];
//			}
//		}
//		
//		//System.out.println(tsum);
//		if(calsum <= L) {
//			System.out.println("�� " +tsum+"Į�θ� "+calsum);
//			max = (max > tsum) ? max:tsum;
//		}
//		
//	}
	
}


