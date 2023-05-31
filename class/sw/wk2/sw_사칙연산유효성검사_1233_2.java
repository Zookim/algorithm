package sw.wk2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
//아래에서 위로
public class sw_사칙연산유효성검사_1233_2 {
	
	static int N;
	static char[] node;
	static int ans=0;
	public static void main(String[] args) throws Exception{
		
		System.setIn(new FileInputStream("input1223.txt"));
		BufferedReader b= new BufferedReader(new InputStreamReader(System.in));

		for(int test_case =1;test_case<=10;test_case++) { //
			N = Integer.parseInt(b.readLine());
			node = new char [N+1]; //
			
			for(int i=1;i<=N;i++) {
				node[i] = b.readLine().split(" ")[1].charAt(0);
			}
			if(N%2==0) { //불완전시
				System.out.println();//
			}
			ans = 1;
			// 뒤에서 앞으로 이동
			int index = N;
			while(index != 1) { //index는 항상 tree의 마지막을 의미
				//오른쪽 마지막index
				//왼쪽 마지막  index-1
				// 부모 index/2
				
				if(! Character.isDigit(node[index])|| ! Character.isDigit(node[index-1])
						|| Character.isDigit(node[index/2])) {
					ans=0;
					break;
				}
				
				//유효
				//다음 높이에서도 확인하기위해, 계산된 값이라 가정하고 현재 부모의 값을 임의의 숫자로 바꾸어준다.
				node[index/2] = '1';
				index -= 2;
				
			}
			System.out.println("#"+test_case+" "+ans);
			
		}

	}
	// 중간 노드가 연산자이면 자식들이 숫자여야하고
	// 현재위치가 숫자이면 자식이 없고, 부모가 연산자여야한다.
	static boolean dfs(int index) {
		//기저조건
		if(index>N)return false;

		if(Character.isDigit(node[index])){ //숫자노드라면 -> 자식이 없어야한다.
			if(index*2 > N) return true;
			return false; // 자식이 있는경우로 식이 성립하지않는다.
		}else return (dfs(index*2) && dfs(index*2+1)); //숫자 노드가 아니면 그다음을 확인한다.(각 위치에서 좌우로 이동)
// 양쪽이 모두 true여야 main문에서 최종적으로 1이된다
		//즉 모든 노드를 끝까지 검사한결과를 가져오게된다.
	}
}
