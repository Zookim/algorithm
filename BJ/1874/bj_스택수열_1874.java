package algogo.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class bj_스택수열_1874 {

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
			 
			 //1. 넣는다. 
			stack[++pointer] = i;
			sb.append("+").append("\n");
			 //2. pointer가 가리키는 값과 비교한다.
			while(pointer != -1 && stack[pointer] == num) {
				//System.out.println(stack[pointer]+ " "+num);
				//3-1. 같으면 다음 입력을 받는다., stack은 pop
				
				pointer--;
				//System.out.println(pointer);
				sb.append("-").append("\n");
				count++;
				if(count == N) break;
				num = Integer.parseInt(br.readLine());
			}//3-2. 다르면  다음 반복문으로
				
		}
		if(count == N) {
			System.out.print(sb);			
		}else {
			//System.out.println(count);
			System.out.print("NO");	
		}
		

	}

}
