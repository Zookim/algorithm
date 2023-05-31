package algo.wk4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_캐슬디펜스_17135 {

	static int max = 0;
	static int N,M,D;
	static int coordinate [][];
	static int arr[][];
	static boolean dead [];
	static int [] loc = new int[3];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		
		
		
		int count=0;
		for(int i=0; i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				int a = Integer.parseInt(st.nextToken());
				arr[i][j]=a;
				if(a == 1) count++;
			}
		}//컬렉션을 사용해 코드줄이기
		coordinate = new int [count][2]; // 0은 행,1은 열

		int index=0;
		for(int i=0; i<N;i++) {
			for(int j=0;j<M;j++) {
				if(arr[i][j] == 1) {
					coordinate[index][0] = i; // 행좌표
					coordinate[index][1] = j; //열좌표
					index++;
				}
			}
		}

		//
		
		//
		
		comb(0,0);
		System.out.println(max);
		
		
		
	}
	static void comb(int start, int index) {
		if(index == 3) {
			//System.out.println(Arrays.toString(loc));
			int m =remove();
			max = m > max ? m:max;
			//dead의 true수를 계산하고 최고일때 저장
			return;
		}
		for(int i=start;i<M;i++) {
			loc[index] = i;
			comb(i+1,index+1);
		}
	}
	static int remove() {

		dead = new boolean [coordinate.length];
		//System.out.println(Arrays.toString(dead));
		for(int k=0;k<N;k++) {//한 턴 이므로, 모든 헹의 값을 +1해주어 지나가게한다.
			int now[] = {-1,-1,-1};
			for(int j=0;j<3;j++) {//각 궁수들에 대하여
				int min = Integer.MAX_VALUE;
				int col =M;
				for(int i=0;i<coordinate.length;i++) {//각 적들에 대하여
					if(coordinate[i][0] < N && !dead[i]) { //유효한 적이면, 거리를 구한다.
						
						//열, 행
						int d = Math.abs(loc[j]-coordinate[i][1]) + Math.abs(N-coordinate[i][0]);//궁수와 coordinate의 거리를 구한다.
						
						if(d<=D && min > d) {//D의 내에 있는지 확인한다,왼쪽것이 먼저기록되면 같은 값이 와도 수정되지 않도록한다.
							//System.out.println(d + " "+coordinate[i][1]+" "+coordinate[i][0]);
							min = d;
							now[j] = i; // 최솟값이나, 왼쪽 값을 선택해둔다(한턴이 끝나면 ,기록)
							col = coordinate[i][1];
							
						}else if(d<=D && min == d) {
							int c = coordinate[i][1];
							if(col > c) {
								col =c;
								now[j] = i;
								
							}
						}
					}
				}
			}
			//System.out.println(Arrays.toString(now));
			//System.out.println(Arrays.toString(dead)+"DFG");
			for(int i=0;i<3;i++) {
				int a = now[i];
				if(a != -1) {
					dead[now[i]] = true;
				}
			}
			//System.out.println(Arrays.toString(dead)+"dfg");
			for(int i=0;i<coordinate.length;i++) {
				coordinate[i][0] +=1;
			}
		}
		int count=0;
		//System.out.println(Arrays.toString(dead));
		for(int i=0;i<coordinate.length;i++) { // 수를 세고,다음 조합을 위해 행을 되돌려준다.
			if(dead[i]) count++;
			coordinate[i][0] -=N;
		}
		//System.out.println(count);
		// 이번 시뮬레이션결와 죽은 수를 구한다.
		return count;

	}

}
