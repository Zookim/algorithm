package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class bj_온풍기안녕_23289 {
	//1.온풍기
	//  같은! 온풍기에서 나온 바람이 여러 번 도착한다고 해도 온도는 여러번 상승하지 않는다.
	//이 경우 각각의 온풍기에 의해서 상승한 온도를 모두 합한 값이 해당 칸의 상승한 온도이다.
	//온풍기가 있는 칸도 다른 온풍기에 의해 온도가 상승할 수 있다.
	//2. 온도가 조정됨
	//⌊(두 칸의 온도의 차이)/4⌋만큼 온도가 조절된다. 온도가 높은 칸은 이 값만큼 온도가 감소!하고, 낮은 칸은 온도가 상승
	//벽이 있는 경우 : 두 칸 사이에 벽이 있는 경우에는 온도가 조절되지 않는다.
	//조절된결과를 사용할 또다른 맵이 필요하다
	//3. 가장바깥쪽의 칸들만! 1씩감소한다.,0아래로 감소하진 않느다.
	//위의 과정을 한턴이라 할때. 몇번째 턴이 지나는지
	//4. 지정된 칸이 K온도 이상인지확인
	static int R,C,K,W;
	static int map[][];
	static List<int[]> check = new ArrayList<>();
	static List<int[]> hotList = new ArrayList<>();
	static int[][] wall;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//1행 1열이 시작!
		
		//입력
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken()); //통과 온도
		
		map = new int[R][C];
		for (int i = 0; i <R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j <C; j++) {
				 int n= Integer.parseInt(st.nextToken()); 
				 if(n==5) {//검사해야할 칸
					 check.add(new int[] {i,j});
					 n=0;
				 }else if(n >=1 && n<=4) {//온풍기
					 hotList.add(new int[] {i,j,n});//온풍기 리스트
					 n=0;
				 }
				 
				 map[i][j] = n;
			}
		}
		//벽의 정보
		W = Integer.parseInt(br.readLine());
		wall = new int[W][3]; //r,c,t
		for (int i = 0; i < W; i++) {
			st = new StringTokenizer(br.readLine());
			wall[i][0] = Integer.parseInt(st.nextToken())-1; 
			wall[i][1] = Integer.parseInt(st.nextToken())-1; 
			wall[i][2] = Integer.parseInt(st.nextToken()); 
		}
		//입력 끝
		
		//벽을 항상고려 : 온풍기 -> 온도조절 4방 -> 바깥쪽 하락 -> 특정 위치의 온도 확인
		
		
		while(true) {
			
			
			
			
			
			
			
			
		}

	}

}
