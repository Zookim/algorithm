package sw.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class sw_��ȣ¦����_1218 {

	static int N,ans;
	static Deque<Character> stack =new ArrayDeque<>(); //1.
	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case =1;test_case <=10;test_case++) {
			
			stack.clear();
			N = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			ans =0;

			
			
			for(int i=0;i<N;i++) {
				char token = str.charAt(i);
				
				//���۹���
				if(token == '{' || token == '[' ||token == '(' ||token == '<' ) { // 2.�ΰ�¥�� ��� ||
					stack.push(token);
				}else { //���� ����Ȯ��
					// ���Ṯ���ε� stack�� ��������� ����
					if(stack.isEmpty()) {
						stack.push(token); //3.������ ���̽��̹Ƿ� �������̽��� ������ ���� �޸� �ϳ��� ������ �����Ų��.
						break;
					}
					//¦�� �´� ���ڿ��� ������.
					char prev = stack.peek(); //������ ���� ����.4.
					if(token == '>' && prev !='<')break;
					else if(token == '}' && prev !='{')break; //5.
					else if(token == ')' && prev !='(')break;
					else if(token == ']' && prev !='[')break;
					else stack.pop(); //Ȯ�� �����Ƿ� ������.
		
				}

			}
			if(stack.isEmpty()) ans=1; // 6.
			System.out.println("#"+test_case+" "+ans);
			
		}
		
		
		
	}

}
