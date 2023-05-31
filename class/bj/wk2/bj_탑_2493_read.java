package bj.wk2;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class bj_탑_2493_read {

	static StringBuilder sb = new StringBuilder();;
	static Stack<int[]> stack = new Stack<>();
	public static void main(String[] args) throws Exception{
		BufferedReader b = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(b.readLine());
		
		StringTokenizer st = new StringTokenizer(b.readLine());

	
		for(int i=1;i<=N;i++) {
			//int height = Integer.parseInt(st.nextToken());
			int height = read();
			
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

	//극단적으로java io에서 쥐어짠 코드 => BufferedReader, StringTokenizer를 이용하는 것보다 아주아주 빠르게 처리
	private static int read() throws Exception {
		int d,o =  System.in.read()&15;
		while((d= System.in.read())>32) o = (o<<3)+(o<<1)+(d&15);
		return o;
	}
}