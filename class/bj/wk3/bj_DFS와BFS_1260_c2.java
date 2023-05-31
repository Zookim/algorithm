package bj.wk3;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_DFS와BFS_1260_c2 {

static int N, M, V;
static List<List<Integer>> list = new ArrayList<>();
static boolean[] visit;
static Queue<Integer> queue = new ArrayDeque<>();
static StringBuilder sb = new StringBuilder();

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());
    V = Integer.parseInt(st.nextToken());

    for (int i = 0; i <= N; i++) {
        list.add(new ArrayList<Integer>());
    }
    visit = new boolean[N+1];
    
    for (int i = 0; i < M; i++) {
        st = new StringTokenizer(br.readLine());
        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());
        list.get(n1).add(n2);
        list.get(n2).add(n1);
    }
    
    // 정렬 필요
    int size = list.size();
    for (int i = 1; i < size; i++) {
        Collections.sort(list.get(i));
    }
    
    visit[V] = true;
    dfs(V);
    
    sb.setCharAt(sb.length()-1, '\n'); // 마지막 공백 문자를 개행 처리
    
    for (int i = 1; i <= N; i++) {
        visit[i] = false;
    }
    
    bfs();
    
    sb.setLength( sb.length() - 1); // 맨 뒤 공백문자 지운다.
    
    System.out.println(sb);
}

static void dfs( int num ) {
    sb.append(num).append(" ");
    
    int size = list.get(num).size();
    for (int i = 0; i < size; i++) {
        int v = list.get(num).get(i);
        if(  visit[v] ) continue;
        visit[v] = true;
        dfs(v);
    }
}

static void bfs() {
    visit[V] = true;
    queue.offer(V);
    
    while(! queue.isEmpty() ) {
        int num = queue.poll();
        sb.append(num).append(" ");
        
        for (int i = 0; i < list.get(num).size(); i++) {
            int v = list.get(num).get(i);
            if( visit[v] ) continue;
            visit[v] = true;
            queue.offer(v);
        }
    }
}
}
