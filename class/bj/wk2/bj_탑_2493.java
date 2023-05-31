package bj.wk2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
// 매우 큰 입력 처리
//입력 처리 => 자료구조 (배열) 존재하면 => 메모리에 대한 부담 => 입력을 읽으면서 바로 처리하는 형태로
//stack 자료구조 <= 모두 담을 것이 아니라, 필요없어진 부분은 삭제해가면서 처리한다.

//출력이 크다=> StringBuilder 사용
public class bj_탑_2493 {


	static StringBuilder sb = new StringBuilder();;
	static Stack<int[]> stack = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(b.readLine());
		
		StringTokenizer st = new StringTokenizer(b.readLine());

	
		for(int i=1;i<=N;i++) {
			int height = Integer.parseInt(st.nextToken());
			//int height = read();
			
			// 현재 탑 기준으로 stack에 들어 있는 이전 ㅌㅁ을 꺼내서 비교
			//만약 이전 탑이 현재 탑보다 크다면 현재탑이 답이 된다.
			while(! stack.isEmpty()) {
				if(stack.peek()[1] >= height) { //직전의 값이 크거나 같으면 그게 답이된다,
					sb.append(stack.peek()[0]).append(" "); //찾았다.
					break;
				}
				stack.pop(); //현재 값이 더크다면, 더 이전값 중엔 있는지 찾는다
			}
			if(stack.isEmpty()) sb.append("0");
			stack.push(new int[] {i,height});
		}
		System.out.println(sb);
	}

}