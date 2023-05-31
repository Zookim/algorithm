package sw.wk2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
//�Ʒ����� ����
public class sw_��Ģ������ȿ���˻�_1233_2 {
	
	static int N;
	static char[] node;
	static int ans=0;
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("input1223.txt"));
		BufferedReader b= new BufferedReader(new InputStreamReader(System.in));

		for(int test_case =1;test_case<=10;test_case++) { //
			N = Integer.parseInt(b.readLine());
			node = new char [N+1]; //
			
			for(int i=1;i<=N;i++) {
				node[i] = b.readLine().split(" ")[1].charAt(0);
			}
			if(N%2==0) { //�ҿ�����
				System.out.println();//
			}
			ans = 1;
			// �ڿ��� ������ �̵�
			int index = N;
			while(index != 1) { //index�� �׻� tree�� �������� �ǹ�
				//������ ������index
				//���� ������  index-1
				// �θ� index/2
				
				if(! Character.isDigit(node[index])|| ! Character.isDigit(node[index-1])
						|| Character.isDigit(node[index/2])) {
					ans=0;
					break;
				}
				
				//��ȿ
				//���� ���̿����� Ȯ���ϱ�����, ���� ���̶� �����ϰ� ���� �θ��� ���� ������ ���ڷ� �ٲپ��ش�.
				node[index/2] = '1';
				index -= 2;
				
			}
			System.out.println("#"+test_case+" "+ans);
			
		}

	}
	// �߰� ��尡 �������̸� �ڽĵ��� ���ڿ����ϰ�
	// ������ġ�� �����̸� �ڽ��� ����, �θ� �����ڿ����Ѵ�.
	static boolean dfs(int index) {
		//��������
		if(index>N)return false;

		if(Character.isDigit(node[index])){ //���ڳ���� -> �ڽ��� ������Ѵ�.
			if(index*2 > N) return true;
			return false; // �ڽ��� �ִ°��� ���� ���������ʴ´�.
		}else return (dfs(index*2) && dfs(index*2+1)); //���� ��尡 �ƴϸ� �״����� Ȯ���Ѵ�.(�� ��ġ���� �¿�� �̵�)
// ������ ��� true���� main������ ���������� 1�̵ȴ�
		//�� ��� ��带 ������ �˻��Ѱ���� �������Եȴ�.
	}
}
