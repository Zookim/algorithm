package sw.wk2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
//�� ->�Ʒ��� �˻�
public class sw_��Ģ������ȿ���˻�_1233 {
	
	static int N;
	static char[] node;
	static int ans=0;
	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("input1223.txt"));
		BufferedReader b= new BufferedReader(new InputStreamReader(System.in));

		for(int test_case =1;test_case<=10;test_case++) { //
			N = Integer.parseInt(b.readLine());
			node = new char [N+1]; //
			
			for(int i=1;i<=N;i++) {
				node[i] = b.readLine().split(" ")[1].charAt(0);
			}
			//��->�Ʒ� �������� ����
			ans = dfs(1)?1:0;
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
