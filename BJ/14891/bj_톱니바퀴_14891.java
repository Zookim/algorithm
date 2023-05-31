package swtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class bj_톱니바퀴_14891 {
	//톱니바퀴의 초기 상태와 톱니바퀴를 회전시킨 방법이 주어졌을 때, 최종 톱니바퀴의 상태 -> 점수로 나타낸다
	//12 방향의 극만을 구하면된다.

	//상태는 8개의 정수로 이루어져 있고, 12시방향부터 시계방향 순서
	//N극은 0, S극은 1로
	// 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향
	static int rotate[];//dummy 2개

	static int wheel[][] = new int[5][8]; // 바퀴 번호는 1번부터 시작
	//static int wheelStart[] = new int[5]; //wheel ,12위치를 저장한다.
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		//톱니의 초기값
		for(int i=1;i<=4;i++) {
			String str[] = br.readLine().split("");
			for(int j=0;j<8;j++) {
				wheel[i][j] = Integer.parseInt(str[j]);
			}
		}

		int K = Integer.parseInt(br.readLine());
		for(int a=0;a<K;a++) { // 톱니 동작
			//rotate초기화
			rotate = new int[8+1];

			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken()); // 시작톱니
			int d = Integer.parseInt(st.nextToken()); // 방향
			//각 톱니의 회전여부를 어떻게 결정할 것인가.
			//왼쪽 과 오른 쪽으로 돌며 회전 배열을 완성하고 그대로 회전시킨다.

			//1.톱니간의 일치여부를 합의 위치에 저장한다.
			for(int w=2;w<=4;w++) {
				if(wheel[w-1][2] == wheel[w][6]) {// 일치하지 하면 회전하지 않으므로 0
					rotate[2*w-1] =0;
				}else {
					rotate[2*w-1] =1;//회전 전파 1
				}
			}
			
			
			
			int dd=d;
			rotate[index*2]= dd;//자기자신회전
			//뒤쪽을 확인한다.
			for(int b=(index+1)*2;b<=8;b+=2) {
				dd = dd*(-1);
				if(rotate[b-1] == 1) {// 회전한다
					rotate[b]=dd;// 이전돠 반대방향으로 회전
				}else break;//같으면 종료

			}
			//앞쪽을 확인한다.
			dd=d;
			for(int b=(index-1)*2;b>=2;b-=2) {
				dd = dd*(-1);
				if(rotate[b+1] == 1) {// 회전한다
					rotate[b]=dd;
				}else break;//같으면 종료
			}
			//System.out.println("#"+Arrays.toString(rotate)); //회전 여부 확인
			// 1인 경우는 시계 방향이고, -1인 경우는 반시계 방향
			
			//ratate 값에 따라 톱니를 회전시킨다.
			for(int i=1;i<=4;i++) {
				//int s = wheelStart[i];
				if(rotate[i*2] == 1) { //시계방향,한칸씩 뒤로 밀린다.
					
					int tmp = wheel[i][7];
					for(int w=6;w>=0;w--) { 
						wheel[i][w+1] = wheel[i][w];
					}
					wheel[i][0] = tmp;
					
				}else if(rotate[i*2] == -1) {// 반시계방향이므로  배열 i번째를 i+1로 이동한다.
					
					int tmp = wheel[i][0];
					for(int w=1;w<=7;w++) {
						wheel[i][w-1] = wheel[i][w];
					}
					wheel[i][7] = tmp;
				}
				//wheelStart[i] = s;
			}
			//print();
			//System.out.println(Arrays.toString(wheelStart));
		}
		



		// 끝
		int score=0;
		for(int i=1;i<=4;i++) {
			//N극은 0, S극은 1로
			if(wheel[i][0] == 1) {
				//System.out.println("Sdf");
				score += Math.pow(2,(i-1)); //
			}

		}
		System.out.println(score);

	}
	static void print() {
		for(int i=1;i<=4;i++) {
			System.out.println(Arrays.toString(wheel[i]));
		}
	}
}

