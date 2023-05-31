package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_배열돌리기1_16926 {

static int N, M, R;
static int[][] map;

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    // 입력 처리
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    
    // 회전
    for (int i = 0; i < R; i++) {
        rotate();
    }
    
    // 출력
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            System.out.print(map[i][j] + " ");
        }
        System.out.println();
    }        
}

// 1회 회전
static void rotate() {
    // 회전의 기준점이 되는 네개의 좌표 초기화
    // sy, sx 는 1씩 증가
    // ey, ex 는 1씩 감소
    int sy = 0, ey = N-1; // 시작, 종료 
    int sx = 0, ex = M-1; // 시작, 종료
    
    while(true) {
        // 기저조건 => 종료
        if( ey - sy < 1 || ex - sx < 1 ) return;
        
        // 라인별 회전 - 반시계 방향
        int temp = map[sy][sx];
        
        // top : 좌로 이동
        for (int i = sx; i < ex; i++) {
            map[sy][i] = map[sy][i+1];
        }
        
        // right : 상으로 이동
        for (int i = sy; i < ey; i++) {
            map[i][ex] = map[i+1][ex];
        }            
        
        // bottom : 우로 이동
        for (int i = ex; i > sx; i--) {
            map[ey][i] = map[ey][i-1];
        }
        
        // left : 하으로 이동
        for (int i = ey; i > sy; i--) {
            map[i][sx] = map[i-1][sx];
        }

        // temp
        map[sy+1][sx] = temp;
        
        // sy, sx 는 1씩 증가
        // ey, ex 는 1씩 감소
        sy += 1;
        sx += 1;
        ey -= 1;
        ex -= 1;
    }
}
}
