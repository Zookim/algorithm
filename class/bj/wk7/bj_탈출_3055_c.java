package bj.wk7;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 최단 - bfs + 시물레이션
// 물이 퍼지고, 고슴도치가 이동
// 물 혼자 bfs 로 다 퍼지고, 고슴도치가 bfs 로 다 갈 수 있는 데를 가고...X
public class bj_탈출_3055_c {

static int R, C, min;
static char[][] map;

static Queue<Node> wQueue = new ArrayDeque<>(); // 물
static Queue<Node> gQueue = new ArrayDeque<>(); // 고슴도치

static int[] dy = { -1, 1, 0, 0 };
static int[] dx = {  0, 0,-1, 1 };

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    
    map = new char[R][];
    
    for (int i = 0; i < R; i++) {
        map[i] = br.readLine().toCharArray();
        for (int j = 0; j < C; j++) {
            char ch = map[i][j];
            if( ch == 'S') {
                gQueue.offer(new Node(i, j, 0));
            }else if( ch == '*' ) {
                wQueue.offer(new Node(i, j, 0));
            }
        }
    }

    min = Integer.MAX_VALUE;
    bfs();
    
    System.out.println(min == Integer.MAX_VALUE ? "KAKTUS" : min);
}

static void bfs() {
    // 큐에는 이미 초기 Node 가 담겨있다.
    while( ! gQueue.isEmpty() ) { // 고슴도치 기준으로 bfs() => 최단 시간, 경로
        
        // 물 확산 <= 확산되는 형태가 bfs 형태로 퍼져나간다.
        int size = wQueue.size();
        for (int i = 0; i < size; i++) {
            Node node = wQueue.poll();
            
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                
                if( ny < 0 || nx < 0 || ny >= R || nx >= C ) continue;
                if( map[ny][nx] == '.' ) {
                    map[ny][nx] = '*';
                    wQueue.offer(new Node(ny, nx, 0));
                }
            }
        }
        
        // 고슴도치 이동
        size = gQueue.size();
        for (int i = 0; i < size; i++) {
            Node node = gQueue.poll();
            
            for (int d = 0; d < 4; d++) {
                int ny = node.y + dy[d];
                int nx = node.x + dx[d];
                
                if( ny < 0 || nx < 0 || ny >= R || nx >= C ) continue;
                // 도달 여부
                if( map[ny][nx] == 'D' ) { // 도착지 도달
                    min = node.d + 1;
                    return;
                }else if( map[ny][nx] == '.') {
                    map[ny][nx] = 'S';
                    gQueue.offer(new Node(ny, nx, node.d + 1));
                }
            }
        }
        
    }
}

static class Node{
    int y, x, d;
    Node(int y, int x, int d){
        this.y = y;
        this.x = x;
        this.d = d;
    }
}
}