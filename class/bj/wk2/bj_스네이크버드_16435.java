package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_������ũ����_16435 {
	//�ִ� ���� 
	//1. ���ĵǸ�, ���ų�,��������
	
	static int [] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		int count=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		count = M;
		for(int i=0;i<N;i++) {
			if (count>=arr[i]) {
				count++;
			}else break;
		}
		
		System.out.println(count);
	

	}


}
