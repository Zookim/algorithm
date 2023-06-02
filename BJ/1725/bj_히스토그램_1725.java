package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_������׷�_1725 {

	static int N,M,K;
	static int [] histogram;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<Integer> stack = new Stack<>();
		
//		StringBuilder sb = new StringBuilder();
//		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(br.readLine()); 

		histogram = new int[N+2];
		histogram[0] = 0;
		histogram[N+1] =0;
		
		int maxs=0;
		stack.push(0);
		for(int i=1;i<=N;i++) {
			// �ʱ� ���� �����Ѵ�.
			histogram[i] = Integer.parseInt(br.readLine()); //���̸� ����
			
			while(!stack.isEmpty() && histogram[stack.peek()] > histogram[i]) { 
				//���� ������ ���� ���� ������ �۴ٸ� pop�ϸ鼭 �ֳ� �ʺ� ���Ѵ�.
				int index = stack.pop();
				int now = (histogram[index]*(i-stack.peek()-1));
				//(���� ���� - stack�� �ֻ������� ���� index���������� �� �ִ밪�� �����Ǵ� �Ⱓ�̹Ƿ�)
				maxs = (maxs > now )?maxs:now;
				System.out.println(now);
			}
			stack.push(i);
			
			
			
		}
		
		while(!stack.isEmpty() && histogram[stack.peek()] > histogram[N+1]) { 
			//���� ������ ���� ���� ������ �۴ٸ� pop�ϸ鼭 �ֳ� �ʺ� ���Ѵ�.
			int index = stack.pop();
			int now = (histogram[index]*((N+1)-stack.peek()-1));
			//(���� ���� - stack�� �ֻ������� ���� index���������� �� �ִ밪�� �����Ǵ� �Ⱓ�̹Ƿ�)
			maxs = (maxs > now )?maxs:now;
			//System.out.println(now);
		}
		
		System.out.println(maxs);
	
		
		
	}

}
