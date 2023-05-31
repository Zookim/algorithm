package review;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ_�����̰�������ִ����� {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int in [][] = new int [T][2];
		
		for(int i=0;i<T;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			in[i][0] = Integer.parseInt(st.nextToken());
			in[i][1] = Integer.parseInt(st.nextToken());
			
		}
		
		// �κ����� ���ϸ� �ּ����� ���Ѵ�.
		int min = Integer.MAX_VALUE;
		for(int i=1;i<(1<<T);i++) { // 0�ΰ��� ����
			int ssum =1;
			int bsum=0;
			for(int j=0;j < T;j++ ) { //���� ���ڸ����� Ȯ���Ѵ�.
				if((i & (1<<j)) != 0) { // �ش� �ڸ����� 1��� �����Ѵ�.
					ssum *= in[j][0]; 
					bsum += in[j][1]; 
				}
		
			}
			min = Math.min(min, Math.abs(ssum-bsum));
			
			
			
		}
		System.out.println(min);
		
		

	}

}
