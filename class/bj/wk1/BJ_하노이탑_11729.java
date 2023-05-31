package bj.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BJ_�ϳ���ž_11729 {

	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		hanoi(N,1,2,3); //
		System.out.println(sb.toString());

	}
	//�� �ܰ迡�� �̵��� ���õ� ������ sb�� append
	static void hanoi(int n, int from, int temp,int to) {
		//���� ����
		 if (n==0) {return;}
		//���� �ܰ迡�� ������ ���� ��������
		 // �����۾�
		 hanoi(n-1,from,to,temp);
		 //���� �۾� :  from�l �ǹ� ������ to�� �̵� <= ��� ����
		 //System.out.println(from + " "+to);
		 sb.append(from).append(" ").append(to).append("\n");
		 hanoi(n-1,temp,from,to);
		//��� ȣ���� ���� �Ұ�����? ��� ȣ��� ������ ����ϴ��� ���
	}
}
