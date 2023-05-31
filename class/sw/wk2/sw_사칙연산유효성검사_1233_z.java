package sw.wk2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class sw_��Ģ������ȿ���˻�_1233_z {
	
	static int N;
	static char []  arr;
	static boolean select; 
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input1223.txt"));
		BufferedReader b= new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		
		for(int test_case =1;test_case<=10;test_case++) { //
			//System.out.println(test_case);
			N = Integer.parseInt(b.readLine());
			arr = new char [N+1];
			
			for(int i=1;i<=N;i++) {
				arr[i] = b.readLine().split(" ")[1].charAt(0);
			}
			//System.out.println(test_case);
			ans = bfs(1);
			System.out.println("#"+test_case+" "+ans);
			
		}

	}
	// �߰� ��尡 �������̸� �ڽĵ��� ���ڿ����ϰ�
	// ������ġ�� �����̸� �ڽ��� ����, �θ� �����ڿ����Ѵ�.
	static int bfs(int index) {
		
		Queue<Integer> que = new ArrayDeque<>();
		
		que.offer(index);
		
		while(!que.isEmpty()) {
			index = que.poll(); // �ڽ��� �̾ƺ���
			
			int left = index*2;
			int right = index*2+1;
			
			if(Character.isDigit(arr[index])) {
				if(left < N+1) return 0;
			} //�ڽ��� �����̸� �ڽ��� ������Ѵ�.
			else {

				//�ڽ��� �����̸� �ڽ����� �Ѿ��.
				if(left >= (N+1))  return 0;
				que.offer(left);
				que.offer(right);
			}
		}
		return 1; // ��ȿ�Ѱ��
	}
	
	 

}
