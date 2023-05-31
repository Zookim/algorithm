package bj.wk7;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 쿠르스칼 : 간선 중심 <= 간선 정렬 후, 비용이 작은 간선을 계속 선택해 가면서 ( cycle 발생 X 조건) 정점의 개수 - 1 선택
// dfs
// hr() vr() <= 옆으로, 밑으로 움직이면서 간선 파악 <= bfs로 대체 가능

public class BJ_다리만들기2_17472_프림 {

static int N, M, min;
static int[][] map;

// dfs
static boolean[][] visit;
static int[] dy = { -1, 1, 0, 0 };
static int[] dx = {  0, 0,-1, 1 };

static int V; // 정점의 수
// 간선
static class Edge{
    int v, cost;
    Edge(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
}    

static PriorityQueue<Edge> pqueue = new PriorityQueue<>( (e1, e2) -> e1.cost - e2.cost );

// prim
static ArrayList<ArrayList<Edge>> vertex;
static boolean[] visitPrim;

static void dfs(int y, int x, int num) {
    visit[y][x] = true;
    map[y][x] = num;
    
    for (int d = 0; d < 4; d++) {
        int ny = y + dy[d];
        int nx = x + dx[d];
        
        if( ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx] ) continue;
        if( map[ny][nx] == -1 ) dfs( ny, nx, num );
    }
}

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    
    map = new int[N][M];
    visit = new boolean[N][M];
    
    for (int i = 0; i < N; i++) {
        st = new StringTokenizer(br.readLine());
        for (int j = 0; j < M; j++) {
            map[i][j] = Integer.parseInt(st.nextToken())*(-1); // 1 => -1
        }
    }
    
    // dfs
    int num = 1;
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            if( map[i][j] == -1 && ! visit[i][j] ) {
                dfs( i, j, num );
                num++;
            }
        }
    }
    
    // graph
    
    // 정점
    V = num - 1;
    
    vertex = new ArrayList<ArrayList<Edge>>();
    for (int i = 0; i <= V; i++) {
        vertex.add(new ArrayList<Edge>());
    }
    visitPrim = new boolean[V + 1];
    
    // 간선 파악해서 자료구조에 저장 (PriorityQueue)
    hr();
    vr();
    
    // 프림 적용
    int cnt = 1;
    visitPrim[1] = true;
    pqueue.addAll(vertex.get(1));
    
    while( ! pqueue.isEmpty() ) {
        Edge edge = pqueue.poll();
        if( visitPrim[edge.v]) continue;
        
        pqueue.addAll(vertex.get(edge.v));
        visitPrim[edge.v] = true;
        min += edge.cost;
        
        cnt++;
        if( cnt == V ) break;
    }
    
    if( cnt != V ) min = -1;
    System.out.println(min == 0 ? -1 : min );
}

static void hr() {
    
    for (int i = 0; i < N; i++) {
        
        int prev = 0;
        int curr = 0;
        int v1 = 0;
        int v2 = 0;
        int cost = 0;
        
        for (int j = 0; j < M; j++) {
            curr = map[i][j];
            if( prev == 0 && curr != 0 ) { // 바다 -> 섬
                if( v1 == 0 ) v1 = curr;
                else {
                    v2 = curr;
                    if( cost > 1 ) {
                        // addEdge
                        addEdge(v1, v2, cost);
                        addEdge(v2, v1, cost);
                    }
                    v1 = v2;
                    v2 = 0;
                    cost = 0;
                }
            }else if( v1 != 0 && curr == 0 ) {
                cost++;
            }
            
            prev = curr;
        }
    }
}

static void vr() {
    
    for (int i = 0; i < M; i++) { // hr() 대비 N, M 반대로
        int prev = 0;
        int curr = 0;
        int v1 = 0;
        int v2 = 0;
        int cost = 0;
        for (int j = 0; j < N; j++) { // hr() 대비 N, M 반대로
            curr = map[j][i]; // hr() 대비 i, j 반대로
            if( prev == 0 && curr != 0 ) {
                if( v1 == 0 ) v1 = curr;
                else {
                    // edge 발생
                    v2 = curr;
//                        System.out.println(v1 + "---" + v2 + " : " + cost );
                        if( cost > 1 ) {
                            addEdge(v1, v2, cost);
                            addEdge(v2, v1, cost); // 쿠르스칼은 한쪽 만 해도 해결
                        }
                        v1 = v2;
                        v2 = 0;
                        cost = 0;
                    }
                }else if( v1 != 0 && curr == 0 ) {
                    cost++;
                }

                prev = curr;
            }
        }
    }

    // pqueue 에서 동일 간선이 있으면 비용 최소값으로 갱신, 없으면 추가 
    static void addEdge(int v1, int v2, int cost) {

        boolean same = false;

        for (Edge edge : vertex.get(v1)) {
            if( edge.v == v2 ) {
                same = true;
                edge.cost = Math.min(edge.cost, cost);
                break;
            }
        }

    if( ! same ) vertex.get(v1).add(new Edge(v2, cost));
}
}