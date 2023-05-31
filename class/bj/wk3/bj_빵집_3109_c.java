package bj.wk3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class bj_빵집_3109_c {

static char[][] map;
static int R, C, ans;
static int[] dy = { -1, 0, 1 }; // dx 는 항상 오른쪽이므로 필요X

public static void main(String[] args) throws Exception{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    R = Integer.parseInt(st.nextToken());
    C = Integer.parseInt(st.nextToken());
    
    map = new char[R][]; // 2차원 배열 비워둔다.
    
    for (int i = 0; i < R; i++) {
        map[i] = br.readLine().toCharArray();
    }

    // 행으로 위부터 아래로 내려가면서 dfs()
    for (int i = 0; i < R; i++) {
        if( dfs(i, 0) ) ans++;
    }
    
    System.out.println(ans);
}

// 해당 좌표에서 오른쪽으로 이동 시도, dy[] 이용
// true : 맨 끝 도착
//        자신의 좌표보다 다음 좌표 재귀 호출 결과가 true 
static boolean dfs(int y, int x) {
    int nx = x + 1; // 열 이동은 단순 오른족 이동
    if( nx == C - 1 ) return true; // 오른쪽 도착이면 한 건 성공
    
    // 3개 방향으로 우선순위대로 탐색 이어간다.
    for (int d = 0; d < 3; d++) {
        int ny = y + dy[d];
        if( ny < 0 || ny >= R || map[ny][nx] == 'x' ) continue;
        // 아직 방문하지 않은 좌표
        map[ny][nx] = 'x'; // 이미 방문했다. 성공해도, 실패해도 다시 올 필요 X
        
        if( dfs(ny, nx) )  return true; // 다음 좌표이동에서 성공 return ( for 종료 )
    }
    
    return false;
}
}