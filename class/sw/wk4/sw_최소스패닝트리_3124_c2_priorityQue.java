package sw.wk4;
//된다.
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class sw_최소스패닝트리_3124_c2_priorityQue {

static int T, V, E;
static long sum;

static List<List<Edge>> adjList; // 인접 리스트
static boolean[] visit; 
static PriorityQueue<Edge> pqueue = new PriorityQueue<>( (e1, e2) -> e1.c - e2.c );

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());
    
    for (int t = 1; t <= T; t++) {
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        
        adjList = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            adjList.add(new ArrayList<Edge>());
        }
        visit = new boolean[V + 1];	
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 방향이 없으므로 2군데 처리
            adjList.get(v1).add(new Edge(v2, c));
            adjList.get(v2).add(new Edge(v1, c));
        }
        
        // 풀이
        sum = 0;
        pqueue.clear();
        
        // 프림
        prim();
        
        System.out.println("#" + t + " " + sum);
    }
}

static void prim() {
    // 1번 정점부터
    int cnt = 1;
    visit[1] = true;
    pqueue.addAll(adjList.get(1)); // 1번으로부터 갈 수 있는 정점(간선) 을 모두 넣는다.
    
    while( ! pqueue.isEmpty() ) {
        Edge edge = pqueue.poll();
        if( visit[edge.v] ) continue;
        
        visit[edge.v] = true; // 선택
        sum += edge.c; // 비용 누적
        cnt++;
        if( cnt == V ) break; // 모두 선택되면 종료
        
//            pqueue.addAll(adjList.get(edge.v)); // 비효율적...통과
            for (Edge e : adjList.get(edge.v)) {
                if( !visit[e.v] ) pqueue.add(e);
            }
        }
    }

    // 간선
    static class Edge{
        int v, c;
        Edge( int v, int c){
            this.v = v;
            this.c = c;
        }
    }
}