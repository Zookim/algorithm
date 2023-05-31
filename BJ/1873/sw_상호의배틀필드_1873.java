package algo.hw;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class sw_상호의배틀필드_1873 {
	//맵의 최후 상태는 ? 
	static String map[][];
	static int start[] = {0,0}; 
	static int state; // 1좌,2상,3우,4하
	static int H,W;
	public static void main(String[] args) throws Exception  {
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int test_case=1;test_case<=T;test_case++) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new String [H][W];
			for(int i=0;i<H;i++) {
				map[i] = br.readLine().split("");
				for(int j=0;j<W;j++) {
					if(map[i][j].equals("<")) {
						state = 1;				
					}else if( map[i][j].equals("^")) {
						state = 2;
					}else if(map[i][j].equals(">")) {
						state = 3;
					}else if(map[i][j].equals("v") ) {
						state = 4;				
					}else { continue;}
					start[0] =i;
					start[1] =j;
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			String input = br.readLine();
			
			for(int i=0;i<N;i++) {
//				for(String [] a: map) {
//					System.out.println(Arrays.toString(a));
//				}System.out.println();
//				
				char ch = input.charAt(i);
				//System.out.println(ch);
				switch(ch) {
				case 'U':
					up(start);
					break;
				case 'D':
					down(start);
					break;
				case 'L':
					left(start);
					break;
				case 'R':
					right(start);
					break;
				case 'S':
					shoot(start);
					break;

				}
			}
			sb.append("#").append(test_case).append(" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					sb.append(map[i][j]);
				}
				sb.append("\n");
			}
			
			System.out.println(sb);
			
			
		}

	}
	static void shoot(int start[]) {
		int r = start[0];
		int c = start[1];
		//벽돌은 한개만 부술수있다.
		// 1좌,2상,3우,4하
		if(state ==1) {
			for(int i=c;i>=0;i--) {
				if(map[r][i].equals("#")) {return;}
				else if(map[r][i].equals("*")) {map[r][i] = ".";return;}
			}
		}else if(state ==2) {
			for(int i=r;i>=0;i--) {
				if(map[i][c].equals("#")) {return;}
				else if(map[i][c].equals("*")) {map[i][c] = ".";return;}
			}

		}else if(state ==3) {
			for(int i=c;i<W;i++) {
				if(map[r][i].equals("#")) {return;}
				else if(map[r][i].equals("*")) {map[r][i] = ".";return;}
			}

		}else{
			for(int i=r;i<H;i++) {
				if(map[i][c].equals("#")) {return;}
				else if(map[i][c].equals("*")) {map[i][c] = ".";return;}
			}
		}

	}
	static void left(int start[]) {
		int r = start[0];
		int c = start[1];
		state = 1;
		
		if((c-1) >= 0 && map[r][c-1].equals(".") ) { // 범위 내이고, 평지이다
			map[r][c-1] =  "<";
			map[r][c] =  ".";
			start[1]--;
			

		}else { // 범위 밖이거나 평지가 아니다
			map[r][c] =  "<";

		}
		
	}

	static void right(int start[]) {
		int r = start[0];
		int c = start[1];
		state = 3;
		
		if((c+1) < W && map[r][c+1].equals(".") ) { // 범위 내이고, 평지이다
			map[r][c+1] =  ">";
			map[r][c] =  ".";
			start[1]++;
			

		}else { // 범위 밖이거나 평지가 아니다
			map[r][c] =  ">";

		}
		
	}
	
	static void down(int start[]) {
		int r = start[0];
		int c = start[1];
		state = 4;
		
		if((r+1) < H && map[r+1][c].equals(".") ) { // 범위 내이고, 평지이다
			map[r+1][c] =  "v";
			map[r][c] =  ".";
			start[0]++;
			

		}else { // 범위 밖이거나 평지가 아니다
			map[r][c] =  "v";

		}
		
	}
	static void up(int start []) {
		int r = start[0];
		int c = start[1];
		state = 2;
		if((r-1) >= 0 && map[r-1][c].equals(".") ) { // 범위 내이고, 평지이다
			map[r-1][c] =  "^";
			map[r][c] =  ".";
			start[0]--;
			

		}else { // 범위 밖이거나 평지가 아니다
			map[r][c] =  "^";

		}
		
	}

}