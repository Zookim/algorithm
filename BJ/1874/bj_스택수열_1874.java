package algogo.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_���ü���_1874 {

	static int stack[];
	static int pointer = -1;
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		stack = new int[N];
		int num = Integer.parseInt(br.readLine());
		int count=0;
		
		for(int i=1;i<=N;i++) {
			//System.out.println(pointer);
			 
			 //1. �ִ´�. 
			stack[++pointer] = i;
			sb.append("+").append("\n");
			 //2. pointer�� ����Ű�� ���� ���Ѵ�.
			while(pointer != -1 && stack[pointer] == num) {
				//System.out.println(stack[pointer]+ " "+num);
				//3-1. ������ ���� �Է��� �޴´�., stack�� pop
				
				pointer--;
				//System.out.println(pointer);
				sb.append("-").append("\n");
				count++;
				if(count == N) break;
				num = Integer.parseInt(br.readLine());
			}//3-2. �ٸ���  ���� �ݺ�������
				
		}
		if(count == N) {
			System.out.print(sb);			
		}else {
			//System.out.println(count);
			System.out.print("NO");	
		}
		

	}

}
