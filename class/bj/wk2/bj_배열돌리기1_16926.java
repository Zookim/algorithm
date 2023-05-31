package bj.wk2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_�迭������1_16926 {

static int N, M, R;
static int[][] map;

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    R = Integer.parseInt(st.nextToken());

    // �Է� ó��
    map = new int[N][M];
    for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    
    // ȸ��
    for (int i = 0; i < R; i++) {
        rotate();
    }
    
    // ���
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            System.out.print(map[i][j] + " ");
        }
        System.out.println();
    }        
}

// 1ȸ ȸ��
static void rotate() {
    // ȸ���� �������� �Ǵ� �װ��� ��ǥ �ʱ�ȭ
    // sy, sx �� 1�� ����
    // ey, ex �� 1�� ����
    int sy = 0, ey = N-1; // ����, ���� 
    int sx = 0, ex = M-1; // ����, ����
    
    while(true) {
        // �������� => ����
        if( ey - sy < 1 || ex - sx < 1 ) return;
        
        // ���κ� ȸ�� - �ݽð� ����
        int temp = map[sy][sx];
        
        // top : �·� �̵�
        for (int i = sx; i < ex; i++) {
            map[sy][i] = map[sy][i+1];
        }
        
        // right : ������ �̵�
        for (int i = sy; i < ey; i++) {
            map[i][ex] = map[i+1][ex];
        }            
        
        // bottom : ��� �̵�
        for (int i = ex; i > sx; i--) {
            map[ey][i] = map[ey][i-1];
        }
        
        // left : ������ �̵�
        for (int i = ey; i > sy; i--) {
            map[i][sx] = map[i-1][sx];
        }

        // temp
        map[sy+1][sx] = temp;
        
        // sy, sx �� 1�� ����
        // ey, ex �� 1�� ����
        sy += 1;
        sx += 1;
        ey -= 1;
        ex -= 1;
    }
}
}
