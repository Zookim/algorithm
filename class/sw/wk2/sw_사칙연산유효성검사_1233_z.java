package sw.wk2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class sw_사칙연산유효성검사_1233_z {
	
	static int N;
	static char []  arr;
	static boolean select; 
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("input1223.txt"));
		BufferedReader b= new BufferedReader(new InputStreamReader(System.in));
		int ans=0;
		
		for(int test_case =1;test_case<=10;test_case++) { //
			//System.out.println(test_case);
			N = Integer.parseInt(b.readLine());
			arr = new char [N+1];
			
			for(int i=1;i<=N;i++) {
				arr[i] = b.readLine().split(" ")[1].charAt(0);
			}
			//System.out.println(test_case);
			ans = bfs(1);
			System.out.println("#"+test_case+" "+ans);
			
		}

	}
	// 중간 노드가 연산자이면 자식들이 숫자여야하고
	// 현재위치가 숫자이면 자식이 없고, 부모가 연산자여야한다.
	static int bfs(int index) {
		
		Queue<Integer> que = new ArrayDeque<>();
		
		que.offer(index);
		
		while(!que.isEmpty()) {
			index = que.poll(); // 자신을 뽑아보고
			
			int left = index*2;
			int right = index*2+1;
			
			if(Character.isDigit(arr[index])) {
				if(left < N+1) return 0;
			} //자신이 숫자이면 자식은 없어야한다.
			else {

				//자신이 문자이면 자식으로 넘어간다.
				if(left >= (N+1))  return 0;
				que.offer(left);
				que.offer(right);
			}
		}
		return 1; // 유효한경우
	}
	
	 

}
