package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_�似Ǫ������_1158 {

	
	static int N,K;
	static int[] input;
	static StringBuilder sb = new StringBuilder();
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(b.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		input = new int[N+1]; // 0 dummy

		for (int i = 1; i <= N; i++) {
			input[i] = i;
			
		}
		
		// Ǯ��
		int count =0; // ���� ����� ��, ��� ������ count ==N <= ��������
		int index =1; //���� ��� ���� //2.index
		int step=1; // ����ִ� ��ȣ������ ���� (K��°�� ������.)
		
		//������ 0���� ǥ���Ѵ�.
		sb.append("<");
		while(true) {
			if(count == N) break; //��������
			//k��° ����� �����ؼ� ���δ�.
			//System.out.println(index);
			
			//����ִ� ����߿� k��°�� ���δ�.
			//int newIdx = index % N+1; //1.
			if(input[index] != 0) {
				if((step % K) == 0) {
					sb.append(input[index]).append(", ");
					input[index] = 0; //�������� ǥ��
					count++; //������ ����.
				}
				step++; //����ִµ�k��°�� �ƴϴ�.
			}
			index++;
			if(index >N) index =1; //2. �갡 ������ �� �ܼ��ϱ⿡ �� ������, C���� ū���̰� ������, �ڹٿ��� ���̰� ũ��
			//�ܼ��һӸ��ƴ϶� ���ǿ� �ش��Ҷ��� �ʱ�ȭ�ϹǷ� ��������.
		}
		sb.setLength(sb.length()-2); // �������� ����,�� empty space�� ����
		sb.append(">");
		System.out.println(sb);
	
	}
}
