package sw.wk2;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
//위 ->아래로 검사
public class sw_사칙연산유효성검사_1233 {
	
	static int N;
	static char[] node;
	static int ans=0;
	public static void main(String[] args) throws Exception{
		
		//System.setIn(new FileInputStream("input1223.txt"));
		BufferedReader b= new BufferedReader(new InputStreamReader(System.in));

		for(int test_case =1;test_case<=10;test_case++) { //
			N = Integer.parseInt(b.readLine());
			node = new char [N+1]; //
			
			for(int i=1;i<=N;i++) {
				node[i] = b.readLine().split(" ")[1].charAt(0);
			}
			//위->아래 방향으로 진행
			ans = dfs(1)?1:0;
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
