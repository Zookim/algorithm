package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_�似Ǫ������_1158_2 {

	
	static int N,K;
	static Queue<Integer> queue =new LinkedList<>();
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(b.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());


		for (int i = 1; i <= N; i++) {
			queue.offer(i);
			
		}
		
		// Ǯ��
		int count =0; // ���� ����� ��, ��� ������ count ==N <= ��������
		int index =1; //���� ��� ���� //2.index
		int step=1; // ����ִ� ��ȣ������ ���� (K��°�� ������.)
		
		//������ 0���� ǥ���Ѵ�.
		sb.append("<");
		
		int alive=1;
		while(! queue.isEmpty()) {
			int num = queue.poll();
			if(alive %K==0) {
				sb.append(num + ", ");
			}
			else {
				queue.offer(num);
			}
			alive++;
		}
		sb.setLength(sb.length()-2); // �������� ����,�� empty space�� ����
		sb.append(">");
		System.out.println(sb);
	
	}
}
