package algogo.wk1;
// �߸��� Ǯ��
// �̷��� Ǯ�� ���ÿ��� pop�Ǵ� ���� �׻� (�̹Ƿ� . ��Ȯ�� ���� ���Ҽ� ����.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bj_�踷���_10799_2 {

	static class Stack{
		//p�� ��ĭ�� ����Ų��.
		String stack[];
		int p=0;
		
		public Stack(int n) {
			stack = new String[n];
		}
		public void push(String str) {
			stack[p++] = str;
		}
		public String pop() {
			//return stack[--p];
			String s = stack[--p];
			stack[p] = null;
			return s;
		}
		public String peek() {
			return stack[p-1];
		}
		public int size() {
			return p;
		}
		public void print() {
			System.out.println(Arrays.toString(stack));
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str[] = br.readLine().split("");
		int totalpiece =0;
		Stack stack = new Stack(str.length);
		
		for(int i=0;i<str.length;i++) {
			if(str[i].equals(")")) {
				if(stack.pop().equals("(")) {
					totalpiece += stack.size();
				}else {// �ٵ� �� ���� �������� �ʴ´�.
					//
					totalpiece += 1;
				}
				System.out.println(totalpiece);
				
			}else {
				stack.push(str[i]);				
			}
			stack.print();
			
		}
		System.out.println(totalpiece);
		
	}

}
