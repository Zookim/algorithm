package bj.wk2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_ž_2493_read {

	static StringBuilder sb = new StringBuilder();;
	static Stack<int[]> stack = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(b.readLine());
		
		StringTokenizer st = new StringTokenizer(b.readLine());

	
		for(int i=1;i<=N;i++) {
			//int height = Integer.parseInt(st.nextToken());
			int height = read();
			
			// ���� ž �������� stack�� ��� �ִ� ���� ������ ������ ��
			//���� ���� ž�� ���� ž���� ũ�ٸ� ����ž�� ���� �ȴ�.
			while(! stack.isEmpty()) {
				if(stack.peek()[1] >= height) { //������ ���� ũ�ų� ������ �װ� ���̵ȴ�,
					sb.append(stack.peek()[0]).append(" "); //ã�Ҵ�.
					break;
				}
				stack.pop(); //���� ���� ��ũ�ٸ�, �� ������ �߿� �ִ��� ã�´�
			}
			if(stack.isEmpty()) sb.append("0");
			stack.push(new int[] {i,height});
		}
		System.out.println(sb);
	}

	//�ش�������java io���� ���§ �ڵ� => BufferedReader, StringTokenizer�� �̿��ϴ� �ͺ��� ���־��� ������ ó��
	private static int read() throws Exception {
		int d,o =  System.in.read()&15;
		while((d= System.in.read())>32) o = (o<<3)+(o<<1)+(d&15);
		return o;
	}
}