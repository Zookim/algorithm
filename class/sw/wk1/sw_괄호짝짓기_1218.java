package sw.wk1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class sw_괄호짝짓기_1218 {

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
				
				//시작문자
				if(token == '{' || token == '[' ||token == '(' ||token == '<' ) { // 2.두개짜리 사용 ||
					stack.push(token);
				}else { //종료 문자확인
					// 종료문자인데 stack이 비어있으면 오류
					if(stack.isEmpty()) {
						stack.push(token); //3.비정상 케이스이므로 정상케이스가 끝났을 때와 달리 하나를 넣은후 종료시킨다.
						break;
					}
					//짝이 맞는 문자열을 꺼낸다.
					char prev = stack.peek(); //꺼내기 전에 본다.4.
					if(token == '>' && prev !='<')break;
					else if(token == '}' && prev !='{')break; //5.
					else if(token == ')' && prev !='(')break;
					else if(token == ']' && prev !='[')break;
					else stack.pop(); //확인 했으므로 버린다.
		
				}

			}
			if(stack.isEmpty()) ans=1; // 6.
			System.out.println("#"+test_case+" "+ans);
			
		}
		
		
		
	}

}
