package sw.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_�ܹ��Ŵ��̾�Ʈ_5215_c2 {

	//Į�θ������� ����, ��ȣ�ϴ� ����
	//2���� �̻��� Ǯ��
	static int arr[][];
	static int N,L,T;
	static int max;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		T = Integer.parseInt(br.readLine());
		for(int test=1;test<=T;test++) {
			max=0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); //����Ǽ�
			L = Integer.parseInt(st.nextToken()); //Į�θ�
			
			arr = new int [N][2];
			for(int i=0;i<N;i++) {
				st = new StringTokenizer(br.readLine());
				arr[i][0] =Integer.parseInt(st.nextToken()); //��
				arr[i][1] = Integer.parseInt(st.nextToken());
				
			}
			//�κ� ���� 
			subSet(0,0,0);
			System.out.println("#"+test+" "+max);

		}
	} //���, for
	static void subSet(int index,int point,int cal) {
		if(cal > L) {return;}
		if(index == N) {

			max = Math.max(max,point);
			return;
		}
		subSet(index+1,point+arr[index][0],cal+arr[index][1]);
		subSet(index+1,point,cal);
		
		
	}
	
}


