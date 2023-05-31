package algo_live.floyd;
import java.util.Scanner;

/*
5
0 4 2 5 0
0 0 1 0 4
1 3 0 1 2
-2 0 0 0 2
0 -3 3 1 0


5
0 4 2 5 0
0 0 1 0 4
1 3 0 1 2
2 0 0 0 2
0 3 3 1 0
*/

/**
 * @author taeheekim
 */
public class Floyd {

	static final int INF = 9999999;
	static int N,adjMatrix[][];
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adjMatrix = new int[N][N];
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				adjMatrix[i][j] = sc.nextInt();
				if(i != j && adjMatrix[i][j]==0) {//�옄湲곗옄�떊�쑝濡쒖쓽 �씤�젒 �젙蹂닿� �븘�땲怨� �씤�젒�빐�엳吏� �븡�떎硫� INF濡� 梨꾩슦湲�
					adjMatrix[i][j]=INF;
				}
			}
		}
		System.out.println("===========예제==========");
		print();
        // 맨 바깥이 경유지가 되어야한다.
		for(int k=0; k<N; ++k) {
			for(int i=0; i<N; ++i) {
				if(i==k) continue; //출발지와 경유지가같다면 패스
				for(int j=0; j<N; ++j) {
					if(i==j || k==j) continue; //경유지와 목적지와 같거나 출발지와 목적지가 동일하다면 패스
					// adjMatrix[i][j] = Math
					if(adjMatrix[i][j] > adjMatrix[i][k]+adjMatrix[k][j]) {
						adjMatrix[i][j] = adjMatrix[i][k]+adjMatrix[k][j];
					}
				}
			}
			print();
		}
	
	}
	private static void print() {
		for(int i=0; i<N; ++i) {
			for(int j=0; j<N; ++j) {
				System.out.print(adjMatrix[i][j]+"\t");
			}
			System.out.println();
		}
		System.out.println("=====================================");
		
	}

}
