package algogo.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class bj_��ȣ�ǰ�_2504_2 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char c[] = br.readLine().toCharArray();
		Stack<Character> stack = new Stack<>();
		int value =1;
		int res=0;
		
		
		for(int i=0; i<c.length;i++) {
			char now = c[i];
			
			if(now == '(') {
				stack.push('(');
				value *= 2;
			}else if(now == '[') {
				stack.push('[');
				value *= 3;
			}else if(now == ')') {
				//������ ����ų� �ڽ��� ���� �ƴϸ� ����
				if(stack.isEmpty() || stack.peek() != '(') {
					res =0;
					break;
				}// �ƴ϶�� �ڽ��� ���̹Ƿ� ���� �����ش�.�� ��� �ݴ� ��ȣ�����ؼ������̶�
				// ��� ���� ������ȣ�϶��� ���� �����ش�.
				else if(c[i-1] == '(') {
					res += value;
				}
				//�ϴ� �����ٸ� �������� ���� �ٽ� �ٿ��ش�.
				value /= 2;
				stack.pop();
				
			}else if(now == ']') {
				//������ ����ų� �ڽ��� ���� �ƴϸ� ����
				if(stack.isEmpty() || stack.peek() != '[') {
					res =0;
					break;
				}// �ƴ϶�� �ڽ��� ���̹Ƿ� ���� �����ش�.�� ��� �ݴ� ��ȣ�����ؼ������̶�
				// ��� ���� ������ȣ�϶��� ���� �����ش�.
				else if(c[i-1] == '[') {
					res += value;
				}
				//�ϴ� �����ٸ� �������� ���� �ٽ� �ٿ��ش�.pop�� �ؾ��Ѵ�.
				value /= 3;
				stack.pop();
				
				
				
			}
		}
		
		if(stack.isEmpty()) {
			System.out.println(res);
		}else {
			System.out.println(0);

		}
		
		

	}

}
